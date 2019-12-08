package stoneage.partie;

import stoneage.joueur.Joueur;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Plateau;
import stoneage.plateaudejeu.cartes.Cartebatiment;
import stoneage.plateaudejeu.zones.Zone;
import stoneage.plateaudejeu.zones.ZoneVillage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Iterator;


/**
 * Classe Tour : Traite les actions liées à un tour avec la phase de placement, de récupération
 * et la phase nourrissage.
 */
public class Tour {

    Plateau plateau;
    Dictionary placementZone;

    public Tour(Plateau p){
        this.plateau = p;
    }


    /**
     * Lance la phase de placement
     * @param affichage Si l'affichage se fait
     */
    public void placementPhase(boolean affichage){
        /**
         * Accumulateur pour savoir quand deux zones village sont occupeés afin de supprimer le 3eme !
         */
        int accVillage=0;

        boolean disponibiliteZone;
        boolean placed;
        int choixNbOuvrier;
        Zone choixZone;
        Cartebatiment choixCarte;
        int nbOuvrierDispoTotal = plateau.nbOuvrierDispoTotal(plateau.getListeInventaire());


        while (nbOuvrierDispoTotal>0) { // J'utilise la methode et non plus une variable afin que le compteur s'actualise
            for (int i : plateau.getTableauFirstPlayer()) {
                if (plateau.getListeInventaire().get(i).getNbOuvrier()==0){ //S'il a déjà posé tous ses ouvriers, il passe son tour.
                    continue;
                }
                do {
                    placed = true;
                    int choixCarteOuZone = plateau.getIA().get(i).choixCarteOuZone();
                    if (choixCarteOuZone==1) {
                        choixZone = plateau.getIA().get(i).choixZone(plateau.getZonesDispo());
                        choixNbOuvrier = plateau.getIA().get(i).choixNbOuvrier(plateau.getListeInventaire().get(i), choixZone);
                        disponibiliteZone = verifierDisponibiliteZone(choixZone, choixNbOuvrier,i);

                        if (disponibiliteZone){
                            plateau.getListeInventaire().get(i).setNbOuvrier(plateau.getListeInventaire().get(i).getNbOuvrier() - choixNbOuvrier);
                            choixZone.placeOuvrierSurZone(choixNbOuvrier, i); //J'ajoute le num du joueur en parametre.
                            plateau.getZoneVisitees().get(i).add(choixZone);
                            if (plateau.isTwoPlayers() && choixZone!=plateau.getChasse()) { plateau.getZonesPleines().add(choixZone);}
                            if (plateau.isTwoPlayers()| plateau.isThreePlayers())
                            {
                                if (choixZone instanceof ZoneVillage) { accVillage++; }
                            }
                            updateStatutZone(); // Je fais l'uptade apres la placement et non plus avant afin que l'autre joueur beneficie de l'uptade pour le choix de la zone.
                            placed = false;
                            if(affichage)
                            {
                                AfficheInfoJoueur(i,choixZone, plateau.getZoneVisitees(), plateau.getCarteVisitees(), plateau.getListeInventaire().get(i));
                            }
                            if(accVillage==2){ plateau.getZonesDispo().remove(plateau.getZonesDispo().size()-1);}

                        }
                    }
                    if (choixCarteOuZone==2) {
                        choixCarte = plateau.getIA().get(i).choixCartePlacement(plateau.getListeCarteTotale());
                        plateau.getListeInventaire().get(i).setNbOuvrier(plateau.getListeInventaire().get(i).getNbOuvrier() - 1);
                        plateau.getCarteVisitees().get(i).add(choixCarte);
                        placed = false;
                        if(affichage)
                        {
                            AfficheInfoJoueur(i,choixCarte,plateau.getZoneVisitees(), plateau.getCarteVisitees(), plateau.getListeInventaire().get(i));
                        }
                    }


                }
                while (placed);

            }
            nbOuvrierDispoTotal = plateau.nbOuvrierDispoTotal(plateau.getListeInventaire());
        }
    }



    /**
     * Lance la phase de récupération
     * @param affichage Si l'affichage se fait
     */
    public void recuperationPhase(boolean affichage){
        Zone zoneCourant;
        Cartebatiment carteCourant;
        int gainDeZone;
        //Inventaire inventaireTemp; Peut-être faire comme ça pour rendre la lecture du code plus simple
        for (int i :plateau.getTableauFirstPlayer()) {
            while((plateau.getZoneVisitees().get(i).size()+plateau.getCarteVisitees().get(i).size())>0) { // Je parcoure la taille de la sous-liste et non plus de la liste afin d'eviter Out-Bound
                int choixCarteOuZone = plateau.getIA().get(i).choixCarteOuZone();

                if (choixCarteOuZone==1 && plateau.getZoneVisitees().get(i).size()>0) {
                    zoneCourant = plateau.getIA().get(i).choixZone(plateau.getZoneVisitees().get(i));

                    if (plateau.getIA().get(i).choixUtiliser()) { //IA choisit d'utiliser ses ouvriers ou non --> && verifier si getNbRessourde>=prixCarte
                        /* On lance les dés et on recupère combien le joueur i gagne*/
                        gainDeZone = zoneCourant.gainZone(plateau.getListeInventaire().get(i),i,plateau.getIA().get(i)); // J'ajoute le num du joueur.
                        /* On rend au joueur i (son inventaire) ses ouvriers qui étaient sur la zone */
                        plateau.getListeInventaire().get(i).setNbOuvrier(plateau.getListeInventaire().get(i).getNbOuvrier() + zoneCourant.getNbOuvirerDuJoueur(i));
                        /* On eleve de la Zone les ouvriers du Joueur i*/
                        zoneCourant.retirerOuvrierSurZone(plateau.getListeInventaire().get(i), zoneCourant.getNbOuvirerDuJoueur(i), i);

                    }
                    else {
                        zoneCourant.retirerOuvrierSurZone(plateau.getListeInventaire().get(i), zoneCourant.getNbOuvirerDuJoueur(i), i);
                    }
                    plateau.getZoneVisitees().get(i).remove(zoneCourant);
                    if(affichage){
                        AfficheInfoJoueur(i,zoneCourant, plateau.getZoneVisitees(), plateau.getCarteVisitees(),plateau.getListeInventaire().get(i));
                    }
                }

                if (choixCarteOuZone==2 && plateau.getCarteVisitees().get(i).size()>0){
                    carteCourant = plateau.getIA().get(i).choixCarteRecuperation(plateau.getCarteVisitees().get(i));
                    if (plateau.getListeInventaire().get(i).getNbRessourceTotal()>=carteCourant.getNbRessourceApayer() && plateau.getIA().get(i).choixUtiliser()) {
                        int choixNbRessource = plateau.getIA().get(i).choixNbRessource();
                        carteCourant.payement(plateau.getListeInventaire().get(i),choixNbRessource);
                        plateau.getListeInventaire().get(i).getCartesBatiments().add(carteCourant);
                        for (int j = 0; j < plateau.getListeCarteTotale().size(); j++) {
                            if (plateau.getListeCarteTotale().get(j).contains(carteCourant)){
                                plateau.getListeCarteTotale().get(j).remove(carteCourant);
                            }
                        }
                    }
                    else {
                        carteCourant.retirerOuvrierSurCarte(plateau.getListeInventaire().get(i));
                    }
                    plateau.getCarteVisitees().get(i).remove(carteCourant);
                    if(affichage){
                        AfficheInfoJoueur(i,carteCourant,plateau.getZoneVisitees(), plateau.getCarteVisitees(), plateau.getListeInventaire().get(i));
                    }
                }

            }
            plateau.getZoneVisitees().get(i).clear();
            plateau.getCarteVisitees().get(i).clear();
        }
        resetZone();
    }



    /**
     * Lance la phase nourrir
     */
    public void phaseNourrir(){
        for (int i :plateau.getTableauFirstPlayer()) {
            plateau.getJoueurs().get(i).nourrir(plateau.getListeInventaire().get(i));
            resetOutils(i);
        }
    }


    /**
     * Restaure la liste des outils disponibles
     */
    public void resetOutils(int i) {
        plateau.getListeInventaire().get(i).getOutilsNonDispo().clear();
        plateau.getListeInventaire().get(i).getOutilsDispo().clear();
        for (int o : plateau.getListeInventaire().get(i).getOutils()) {
            plateau.getListeInventaire().get(i).getOutilsDispo().add(o);
        }
    }



    /**
     * Vérifie si la zone est disponible pour pouvoir placer des ouvriers
     * @param choixZone La zone de placement
     * @param choixNbOuvrier Le nombre d'ouvriers à placer
     * @param i Le numéro du joueur
     * @return True ou False
     */
    public boolean verifierDisponibiliteZone(Zone choixZone, int choixNbOuvrier, int i) {
        if ((plateau.getZonesPleines().contains(choixZone)) | (choixNbOuvrier > choixZone.getNbOuvrierMaxSurZone()-choixZone.getNbOuvrierSurZone()) | (plateau.getListeInventaire().get(i).getNbOuvrier()<choixNbOuvrier) ){
            return false;
        }
        return !(plateau.getZoneVisitees().get(i).contains(choixZone) & choixZone != plateau.getChasse());
    }



    /**
     * Met à jour le status des zones : disponible ou pleine
     */
    public void updateStatutZone(){
        Iterator<Zone> iter = plateau.getZonesDispo().iterator();
        while (iter.hasNext()) {
            Zone z = iter.next();

            if (z.getNbOuvrierSurZone() >= z.getNbOuvrierMaxSurZone()){
                plateau.getZonesPleines().add(z);
                iter.remove();
            }

            if (plateau.isThreePlayers() && plateau.getZonesDispo().contains(z)){
                int acc=0;
                for (int i = 0; i <3; i++) {
                    if (z.getNbOuvirerDuJoueur(i)>0){acc++;}
                }
                if (acc==2)
                {
                    plateau.getZonesPleines().add(z);
                    iter.remove();
                }
            }
        }
    }



    /**
     * Affiche les informations du joueur numero numJ
     * @param numJ Le numero du joueur
     * @param z Une zone
     * @param ZoneVisitees La  liste des zones visitées par le joueur
     * @param inventaire L'inventaire du joueur
     */
    public static void AfficheInfoJoueur(int numJ, Zone z,
                                         ArrayList<ArrayList<Zone>> ZoneVisitees,
                                         ArrayList<ArrayList<Cartebatiment>> CarteVisitees,
                                         Inventaire inventaire) {
        System.out.println("********Joueur " + (numJ+1) + "********");
        System.out.println("Nb d'ouvrier total dans la zone " + z + " : " + z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier du joueur dans la zone " + z + " : " + z.getNbOuvirerDuJoueur(numJ));
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrier());
        if (ZoneVisitees.get(numJ).size()>0) {
            System.out.println("Les zones visitées : " + (ZoneVisitees.get(numJ)));
        }
        if (CarteVisitees.get(numJ).size()>0) {
            System.out.println("Les cartes visitées : " + (CarteVisitees.get(numJ)));
        }
    }

    /**
     * Affiche les informations du joueur numero numJ
     * @param numJ
     * @param c
     * @param ZoneVisitees
     * @param CarteVisitees
     * @param inventaire
     */
    public static void AfficheInfoJoueur(int numJ, Cartebatiment c,
                                         ArrayList<ArrayList<Zone>> ZoneVisitees,
                                         ArrayList<ArrayList<Cartebatiment>> CarteVisitees,
                                         Inventaire inventaire) {
        System.out.println("********Joueur " + (numJ+1) + "********");
        // System.out.println("Nb d'ouvrier total dans la zone " + z + " : " + z.getNbOuvrierSurZone());
        //System.out.println("Nb d'ouvrier du joueur dans la zone " + z + " : " + z.getNbOuvirerDuJoueur(numJ));
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrier());
        if (ZoneVisitees.get(numJ).size()>0) {
            System.out.println("Les zones visitées : " + (ZoneVisitees.get(numJ)));
        }
        if (CarteVisitees.get(numJ).size()>0) {
            System.out.println("Les cartes visitées : " + (CarteVisitees.get(numJ)));
        }
    }


    /**
     * Restaure la liste des zones disponibles
     */
    public void resetZone() {
        plateau.getZonesPleines().clear();
        plateau.getZonesDispo().clear();
        //ZonesDispo.addAll(Arrays.asList(tabAllZone));
        for (Zone z: plateau.getTabAllZone()) {
            plateau.getZonesDispo().add(z);
        }
    }






}
