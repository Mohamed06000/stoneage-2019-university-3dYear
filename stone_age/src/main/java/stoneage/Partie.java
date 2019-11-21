package stoneage;

import org.apache.commons.lang.ArrayUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Partie {
    private final ArrayList<Joueur> joueurs = new ArrayList<>(Arrays.asList(new Joueur(), new Joueur()));
    private final ArrayList<Inventaire> inventaires = new ArrayList<>(Arrays.asList(new Inventaire(), new Inventaire()));
    private final Plateau plateau = new Plateau();
    private static Random rand = new Random();


    public void jouer() {
        int tour = 1;
        System.out.println("Nb de joueur : " + Joueur.getNbJoueur());
        System.out.println("Nb d'ouvriers non place : " + Inventaire.getNbOuvrierNonPlace());


        while(tour<5) {
            System.out.println("_________________________________________________");
            System.out.println("|                Tour : "+tour+"                      |");
            System.out.println("_________________________________________________");

            System.out.println("================PHASE DE PLACEMENT================");
            placementPhase(joueurs, inventaires, plateau.getZonesDispo());

            System.out.println("================PHASE DE RECUPERATION================");
            recuperationPhase(joueurs, inventaires);

            System.out.println("================PHASE NOURRIR================");

            for (int i = 0; i < Joueur.getNbJoueur(); i++) {
                Joueur joueur = (Joueur) joueurs.get(i);
                Inventaire inventaire = (Inventaire) inventaires.get(i);
                phaseNourrir(joueur, inventaire);
            }
            tour++;
        }


        System.out.println("_____RESULTAT_____");
        resultat(joueurs, inventaires);
    }


    public static void placementPhase(ArrayList joueurs, ArrayList inventaires, ArrayList zoneDispo){

        while(Inventaire.getNbOuvrierNonPlace() > 0){
            for (int i=0; i < Joueur.getNbJoueur(); i++)
            {
                Joueur joueur = (Joueur) joueurs.get(i);
                Inventaire inventaire = (Inventaire) inventaires.get(i);
                if (inventaire.getNbOuvrier()==0)
                    continue;
                while(true)
                {
                    int indexZone = rand.nextInt(zoneDispo.size()); //IA choisit random une zone
                    System.out.println("Nb d'ouvriers  : " + inventaire.getNbOuvrier());
                    int nbOuvrier = new Random().nextInt(inventaire.getNbOuvrier())+1; //IA choisit random le nb d'ouvrier a placer
                    if(joueur.getZoneVisite().contains(zoneDispo.get(indexZone))==false)
                    {
                        if ((joueur.getZoneVisite().size()+1) == zoneDispo.size())
                        {
                            phasePlacement(joueur, inventaire, (Zone) zoneDispo.get(indexZone), inventaire.getNbOuvrier());
                            break;
                        }
                        else
                            {
                                phasePlacement(joueur, inventaire, (Zone) zoneDispo.get(indexZone), nbOuvrier);
                                break;
                            }
                    }
                    //if (inventaire.getNbOuvrier()==0) {break;}
                    }

                }

            }
        }

    public static void recuperationPhase(ArrayList joueurs, ArrayList inventaires ){
        for (int i=0; i < Joueur.getNbJoueur(); i++){
            Joueur joueur = (Joueur) joueurs.get(i);
            Inventaire inventaire = (Inventaire) inventaires.get(i);
            int nbZone = joueur.getZoneVisite().size();
            for (int j=0; j< nbZone; j++){
                int ind = rand.nextInt(nbZone);
                phaseRecuperation(joueur, inventaire, joueur.getZoneVisite().get(ind));
                joueur.getZoneVisite().remove(ind);
            }
            Inventaire.setNbOuvrierNonPlace(Inventaire.getNbOuvrierNonPlace() + inventaire.getNbOuvrier());
        }
    }

    public static void resultat(ArrayList joueurs, ArrayList inventaires){
        int arrayRessource[] = new int[joueurs.size()];
        int max = 0;
        int listGagnant[] = {};


        for (int i = 0; i < Joueur.getNbJoueur(); i++) {
            Inventaire inventaire = (Inventaire) inventaires.get(i);
//            arrayRessource[i] = inventaire.getNbRessource();
//            if (inventaire.getNbRessource()> max){
//                max = inventaire.getNbRessource();
//            }
        }
        for (int i=0; i<arrayRessource.length; i++){
            if (max == arrayRessource[i]){
                listGagnant = ArrayUtils.add(listGagnant,i);
            }
        }

        for (int i = 0; i < listGagnant.length; i++) {
            if (listGagnant.length>1){
                System.out.println("Egalité entre :");
                for (int el : listGagnant){
                    Joueur joueur = (Joueur) joueurs.get(el);
                    System.out.println("joueur " + joueur.getNum());
                }
                break;
            }
            else{
                Joueur joueur = (Joueur) joueurs.get(listGagnant[i]);
                System.out.println("Le gagnant est le joueur " + joueur.getNum());
            }
        }
    }


    /**
     * Lancement de la phase de jeu de placement
     *
     * @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public static void phasePlacement(Joueur j, Inventaire inventaire, Zone z, int nbOuvrier) {
        j.placement(inventaire, z, nbOuvrier);
        System.out.println("********Joueur " + j.getNum() + "********");
        System.out.println("Nb d'ouvrier total dans la zone " + z.getClass().getSimpleName() + " : " + z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier du joueur dans la zone " + z.getClass().getSimpleName() + " : " + z.getNbOuvrierDuJoueurI(j.getNum()));
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbOuvrier());
        //System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbRessource());
        System.out.println("Les zones visitées : " + j.getZoneVisite());
    }

    /**
     * Lancement de la phase de jeu de recuperation
     *  @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public static void phaseRecuperation(Joueur j, Inventaire inventaire, Zone z) {
        System.out.println("Joueur " + j.getNum() + " :");
        z.gainZone(inventaire,j);
        //System.out.println("Nb bois : : " + inventaire.getNbRessourceBois());
        z.retirerOuvrierSurZone(inventaire, j.getNum());
        //j.recupere(z);
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        //System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());
        System.out.println("********Joueur " + j.getNum() + "********");
        //z.gainZone(j);
        /*public void gainZone(){
        int somme=0;
        for(int i=0;i<z.getNbOuvrierDuJoueurI(j.getNum());i++){
            somme += j.de();
        }
        if(somme >= 6)
            double gain = somme/3; //formule qui change
        j.getInventaireJoueur().setBois(getBois()+gain); //si zone est Foret
        diminuerRessource(gain);
        retirerOuvrier(getNbOuvrierDuJoueurI(j.getNum()));
}*/
        //j.recupere(z); //z.getNbOuvrierDuJoueur(j.getNum());

        System.out.println("Nb d'ouvrier dans la zone "  + z.getClass().getSimpleName() + " : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier du joueur " + j.getNum() + " dans la zone " + z.getClass().getSimpleName() + " : " + z.getNbOuvrierDuJoueurI(j.getNum()));
        /*if (z instanceof ZoneRessource){
            System.out.println("Nb de ressource dans la zone " + z.getClass().getSimpleName() + " : " + ((ZoneRessource) z).getNbRessourceZone());
        }*/
        System.out.println("niveauAgriculture pour le "+ j.getNum()+ " : "+ inventaire.getNiveauAgriculture() );
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbOuvrier());
        //System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbRessource());

    }



    /**
     * Lancement de la phase de jeu "nourrir"
     *
     * @param j L'objet de la classe Joueur
     */
    public static void phaseNourrir(Joueur j, Inventaire inventaire) {
        j.nourrir(inventaire);
        System.out.println(" Quantitée de nouriture pour le joueur " + j.getNum() + " : " + inventaire.getNbNourriture());

    }
}
