package stoneage.partie;

import stoneage.joueur.Joueur;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Plateau;
import stoneage.plateaudejeu.Ressource;
import stoneage.plateaudejeu.cartes.Cartebatiment;
import stoneage.plateaudejeu.zones.Zone;
import stoneage.plateaudejeu.zones.ZoneVillage;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
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
    Affichage affichage;

    public Tour(Plateau p){
        this.plateau = p;
        this.affichage = new Affichage(false);
    }

    public Tour(Plateau p, Affichage affichage){
        this.plateau = p;
        this.affichage = affichage;
    }


    /**
     * Lance la phase de placement
     */
    public void placementPhase(){
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
                            /* On affiche le num du joueur*/
                            affichage.AffichageNumJoueur(i);

                            /* Le Joueur place ses ouvriers sur la Zone choisie*/
                            plateau.getJoueurs().get(i).placementOuvrierSurZone(plateau.getListeInventaire().get(i), choixNbOuvrier);
                            choixZone.placeOuvrierSurZone(choixNbOuvrier, i);

                            /* Affichage du placement*/
                            affichage.AffichePlacement(i,choixZone);
                            plateau.getZoneVisitees().get(i).add(choixZone);

                            if (plateau.isTwoPlayers() && choixZone!=plateau.getChasse()) { plateau.getZonesPleines().add(choixZone);}
                            if (plateau.isTwoPlayers()| plateau.isThreePlayers()) {
                                if (choixZone instanceof ZoneVillage) { accVillage++; }
                            }
                            updateStatutZone();
                            placed = false;
                            //affichage.AfficheInfoJoueur(i,choixZone, 0, plateau.getZoneVisitees().get(i), plateau.getCarteVisitees().get(i), plateau.getListeInventaire().get(i));
                            if(accVillage==2){ plateau.getZonesDispo().remove(plateau.getZonesDispo().size()-1);}

                        }
                    }
                    if (choixCarteOuZone==2) {
                        /* On affiche le num du joueur*/
                        affichage.AffichageNumJoueur(i);

                        /* L'IA fait un choix de carte*/
                        choixCarte = plateau.getIA().get(i).choixCartePlacement(plateau.getListeCarteTotale());

                        /* Le Joueur place ses ouvriers sur la Carte choisie*/
                        plateau.getJoueurs().get(i).placementOuvrierSurZone(plateau.getListeInventaire().get(i), 1);

                        /* On affiche le placement*/
                        affichage.AffichePlacement(choixCarte);

                        plateau.getCarteVisitees().get(i).add(choixCarte);
                        placed = false;
                        //affichage.AfficheInfoJoueur(i,choixCarte,0,plateau.getZoneVisitees().get(i), plateau.getCarteVisitees().get(i), plateau.getListeInventaire().get(i));
                    }


                }
                while (placed);

            }
            nbOuvrierDispoTotal = plateau.nbOuvrierDispoTotal(plateau.getListeInventaire());
        }
    }



    /**
     * Lance la phase de récupération
     */
    public void recuperationPhase(){
        Zone zoneCourant;
        Cartebatiment carteCourant;
        int gainDeZone;
        //Inventaire inventaireTemp; Peut-être faire comme ça pour rendre la lecture du code plus simple

        for (int i :plateau.getTableauFirstPlayer()) {
            while((plateau.getZoneVisitees().get(i).size()+plateau.getCarteVisitees().get(i).size())>0) { // Je parcoure la taille de la sous-liste et non plus de la liste afin d'eviter Out-Bound
                int choixCarteOuZone = plateau.getIA().get(i).choixCarteOuZone();

                if (choixCarteOuZone==1 && plateau.getZoneVisitees().get(i).size()>0) {
                    /* Ici on recupere les ouvriers sur les zones*/
                    zoneCourant = plateau.getIA().get(i).choixZone(plateau.getZoneVisitees().get(i));

                    /* On affiche le num du Joueur*/
                    affichage.AffichageNumJoueur(i);

                    if (plateau.getIA().get(i).choixUtiliser()) { //IA choisit d'utiliser ses ouvriers ou non --> && verifier si getNbRessourde>=prixCarte
                        if (zoneCourant.equals(plateau.getHutte()) || zoneCourant.equals(plateau.getChamp()) || zoneCourant.equals(plateau.getFabriqueOutils())) {
                            /* Affiche le message de la récuperation*/
                            affichage.AfficheRecup(i,zoneCourant);

                            attributionGainVillage(plateau.getListeInventaire().get(i), zoneCourant);
                        }
                        else {
                            /* On affiche le message recupération*/
                            affichage.AfficheRecup(i, zoneCourant);

                            /* On lance les dés et on recupère combien le joueur i gagne*/
                            gainDeZone = zoneCourant.gainZone(plateau.getListeInventaire().get(i), i, plateau.getIA().get(i), affichage);

                            /* On lui attribue ses gains*/
                            attributionGain(plateau.getListeInventaire().get(i), zoneCourant.getRessource(), gainDeZone);

                            /* On rend au joueur i (son inventaire) ses ouvriers qui étaient sur la zone */
                            plateau.getJoueurs().get(i).retraitOuvrierSurZone(plateau.getListeInventaire().get(i), zoneCourant.getNbOuvirerDuJoueur(i));

                            /* On eleve de la Zone les ouvriers du Joueur i*/
                            zoneCourant.retirerOuvrierSurZone(plateau.getListeInventaire().get(i), zoneCourant.getNbOuvirerDuJoueur(i), i);
                        }

                    }
//                    else { //inutile
//                        zoneCourant.retirerOuvrierSurZone(plateau.getListeInventaire().get(i), zoneCourant.getNbOuvirerDuJoueur(i), i);
//                    }
                    plateau.getZoneVisitees().get(i).remove(zoneCourant);
                }

                if (choixCarteOuZone==2 && plateau.getCarteVisitees().get(i).size()>0){
                    carteCourant = plateau.getIA().get(i).choixCarteRecuperation(plateau.getCarteVisitees().get(i));
                    if (plateau.getListeInventaire().get(i).getNbRessourceTotal()>=carteCourant.getNbRessourceApayer() && plateau.getIA().get(i).choixUtiliser()) {
                        int choixNbRessource = plateau.getIA().get(i).choixNbRessource();
                        carteCourant.payement(plateau.getListeInventaire().get(i),choixNbRessource);

                        /* On affiche la recupération*/
                        affichage.AfficheRecup(carteCourant);

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
                    plateau.getJoueurs().get(i).retraitOuvrierSurZone(plateau.getListeInventaire().get(i), 1);
                    plateau.getCarteVisitees().get(i).remove(carteCourant);
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
        if ((plateau.getZonesPleines().contains(choixZone))
                || (choixNbOuvrier > (choixZone.getNbOuvrierMaxSurZone() - choixZone.getNbOuvrierSurZone()))
                || (plateau.getListeInventaire().get(i).getNbOuvrier() < choixNbOuvrier)
                || (choixZone.equals(plateau.getHutte())) && choixNbOuvrier != 2){
            return false;
        }
        return !(plateau.getZoneVisitees().get(i).contains(choixZone) && choixZone != plateau.getChasse());
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

    public void resetOuvrierDispoDesInventaires(){
        for (Inventaire inventaire : plateau.getListeInventaire()) {
            inventaire.resetNbOuvrierDispo();
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




    public void attributionGain(Inventaire inventaire, Ressource ressourceDeLaZone, int gain){
        if (ressourceDeLaZone == Ressource.OR){
            inventaire.setNbOr(inventaire.getNbOr()+gain);
            affichage.AfficheGainRessource(gain,ressourceDeLaZone);
        }
        else if (ressourceDeLaZone == Ressource.NOURRITURE){
            inventaire.setNbNourriture(inventaire.getNbNourriture()+gain);
            affichage.AfficheGainRessource(gain,ressourceDeLaZone);
        }
        else if (ressourceDeLaZone == Ressource.BOIS){
            inventaire.setNbBois(inventaire.getNbBois()+gain);
            affichage.AfficheGainRessource(gain,ressourceDeLaZone);
        }
        else if (ressourceDeLaZone == Ressource.ARGILE){
            inventaire.setNbArgile(inventaire.getNbArgile()+gain);
            affichage.AfficheGainRessource(gain,ressourceDeLaZone);
        }
        else if (ressourceDeLaZone == Ressource.PIERRE){
            inventaire.setNbPierre(inventaire.getNbPierre()+gain);
            affichage.AfficheGainRessource(gain,ressourceDeLaZone);
        }
        else {
        }
    }

    public void attributionGainVillage(Inventaire inventaire, Zone zone){
        if (zone.equals(plateau.getChamp())){
            /* On augmente le niveau d'agriculture de l'inventaire*/
            inventaire.setNiveauAgriculture(inventaire.getNiveauAgriculture()+1);

            /* Affiche le message du gain (ce dont il a gagné)*/
            affichage.AfficheGainVillage(0);
        }

        else if (zone.equals(plateau.getFabriqueOutils())){
            /* On augmente le nombre d'outils total de l'inventaire ( et on rajoute le niveau de l'outils dans le tableau Outils))*/
            if (inventaire.getNbOutils()<12){
                inventaire.setNbOutils(inventaire.getNbOutils()+1);
                for (int i = 0; i < 3; i++) {
                    if (inventaire.getNbOutils()<4) {
                        if (inventaire.getOutils().get(i)<1) {
                            inventaire.getOutils().set(i, 1);
                            break;
                        }
                    }
                    if (inventaire.getNbOutils()>=3 && inventaire.getNbOutils()<7) {
                        if (inventaire.getOutils().get(i)<2) {
                            inventaire.getOutils().set(i, 2);
                            break;
                        }
                    }
                    if (inventaire.getNbOutils()>=6 && inventaire.getNbOutils()<10) {
                        if (inventaire.getOutils().get(i)<3) {
                            inventaire.getOutils().set(i, 3);
                            break;
                        }
                    }
                    if (inventaire.getNbOutils()>=9 && inventaire.getNbOutils()<13) {
                        if (inventaire.getOutils().get(i)<4) {
                            inventaire.getOutils().set(i, 4);
                            break;
                        }
                    }

                }
                /* Affiche le message du gain (ce dont il a gagné)*/
                affichage.AfficheGainVillage(1);
            }

        }

        else {
            if (inventaire.getNbOuvrierTotal()<10){
                inventaire.setNbOuvrier(inventaire.getNbOuvrier()+1);
                inventaire.setNbOuvrierTotal(inventaire.getNbOuvrierTotal()+1);
                /* Affiche le message du gain (ce dont il a gagné)*/
                affichage.AfficheGainVillage(2);
            }
        }
    }


}
