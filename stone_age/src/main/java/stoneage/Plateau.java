package stoneage;


import java.lang.reflect.Array;
import java.util.*;

/**
 * La classe du plateau de jeu
 */
public class Plateau {

    //CHAMPS

    /**
     * La liste des zones disponibles au placement
     */
    private ArrayList<Zone> ZonesDispo;
    /**
     * La liste des zones pleines au placement
     */
    private ArrayList<Zone> ZonesPleines;
    /**
     * La liste des zones visitées par le joueur
     */
    private ArrayList<ArrayList<Zone>> ZoneVisitees;
    private Dictionary dicoJoueurs = new Hashtable();
    /**
     * Liste des inventaires des joueurs
     */
    private ArrayList<Inventaire> listeInventaire = new ArrayList<Inventaire>();
    /**
     * L'IA qui fait les choix de jeu
     */
    Joueur IA = new Joueur();

    //CONSTRUTEUR

    /**
     * Constructeur de la classe
     * @param nbjoueur Le nombre de joueurs dans le jeu
     */
    Plateau(int nbjoueur){
        this.ZonesDispo = new ArrayList<Zone>(Arrays.asList(Zone.values()));
        this.ZoneVisitees = new ArrayList<ArrayList<Zone>>();
        this.ZonesPleines = new ArrayList<Zone>();
        ArrayList<Zone> zp;
        for (int i = 0; i < nbjoueur ; i++) {
            Inventaire inventaire = new Inventaire();
            dicoJoueurs.put(i, inventaire); //Non utilisé, donc utilité ?
            listeInventaire.add(inventaire);
            zp = new ArrayList<Zone>();
            ZoneVisitees.add(zp);
        }

    }

    //METHODES

    /**
     * Récupère les zones disponibles lors du placement
     * @return La liste des zones disponibles
     */
    public ArrayList<Zone> getZonesDispo() {
        return ZonesDispo;
    }

    /**
     * Récupère les zones pleines lors du placement
     * @return La liste des zones pleines
     */
    public ArrayList<Zone> getZonesPleines() {
        return ZonesPleines;
    }

    public Dictionary getDicoJoueurs() {
        return dicoJoueurs;
    }

    /**
     * Récupère la liste des inventaires
     * @return Les inventaires
     */
    public ArrayList<Inventaire> getListeInventaire() {
        return listeInventaire;
    }

    /**
     * Récupère le nombre d'ouvriers total qui ne sont pas encore placés
     * @return Le nombre d'ouvriers
     */
    protected int nbOuvrierDispoTotal() {
        int n = 0;
        for (int i = 0; i<listeInventaire.size(); i++){
            n += listeInventaire.get(i).getNbOuvrier(); //On reste que sur nbOuvriers et on ne travaille plus avec nbOuvriersDispo
        }
        return n;
    }

    /**
     * Lance la phase de placement
     */
    public void placementPhase(){
        boolean placed; // J'initialise dans la boucle while pour que le joueur ait plusieurs choix de zone avant de passer à un autre joueur.
        boolean disponibiliteZone;
        int choixNbOuvrier;
        Zone choixZone;

        while (nbOuvrierDispoTotal()>0) { // J'utilise la methode et non plus une variable afin que le compteur s'actualise
            for (int i = 0; i<listeInventaire.size(); i++) {
                if (listeInventaire.get(i).getNbOuvrier()==0) //S'il a déjà posé tous ses ouvriers, il passe son tour.
                    continue;
                do {
                    placed = true;
                    choixZone = IA.choixZone(ZonesDispo);
                    choixNbOuvrier = IA.choixNbOuvrier(listeInventaire.get(i), choixZone);
                    disponibiliteZone = verifierDisponibiliteZone(choixZone, choixNbOuvrier,i);
                    if (disponibiliteZone){
                        //System.out.println("----AVANT----");
                        //AfficheInfoJoueur(i,choixZone);
                        listeInventaire.get(i).setNbOuvrier(listeInventaire.get(i).getNbOuvrier() - choixNbOuvrier);
                        choixZone.placeOuvrierSurZone(listeInventaire.get(i), choixNbOuvrier, i); //J'ajoute le num du joueur en parametre.
                        ZoneVisitees.get(i).add(choixZone);
                        updateStatutZone(); // Je fais l'uptade apres la placement et non plus avant afin que l'autre joueur beneficie de l'uptade pour le choix de la zone.
                        placed = false;
                        //System.out.println("----APRES----");
                        AfficheInfoJoueur(i,choixZone, ZoneVisitees, listeInventaire.get(i));
                    }

                }
                while (placed);
            }
        }
    }

    /**
     * Lance la phase de récupération
     */
    public void recuperationPhase(){
        Zone zoneCourant;
        for (int i = 0; i < listeInventaire.size() ; i++) {
            while(ZoneVisitees.get(i).size()>0) { // Je parcoure la taille de la sous-liste et non plus de la liste afin d'eviter Out-Bound
                zoneCourant = IA.choixZone(ZoneVisitees.get(i));
                //System.out.println("----AVANT----");
                //AfficheInfoJoueur(i,zoneCourant);
                //zoneCourant = ZoneVisite.get(i).get(j); // Ici a changer afin de recuperer dans une zone aleatoire.
                zoneCourant.gainZone(listeInventaire.get(i),i); // J'ajoute le num du joueur.
                //System.out.println("----APRES----");
                ZoneVisitees.get(i).remove(zoneCourant);
                AfficheInfoJoueur(i,zoneCourant, ZoneVisitees, listeInventaire.get(i));
            }
            ZoneVisitees.get(i).clear();
        }
        ZonesPleines.clear();
        ZonesDispo.clear();
        resetZoneDispo();
    }

    /**
     * Lance la phase nourrir
     */
    public void phaseNourrir(){
        for (int i = 0 ; i < listeInventaire.size(); i++) {
            IA.nourrir(listeInventaire.get(i));
        }
    }

    /**
     * Affiche les informations du joueur
     * @param numJ Le numero du joueur
     * @param z Une zone
     * @param ZoneVisitees La  liste des zones visitées par le joueur
     * @param inventaire L'inventaire du joueur
     */
    public static void AfficheInfoJoueur(int numJ, Zone z, ArrayList<ArrayList<Zone>> ZoneVisitees, Inventaire inventaire) {
        System.out.println("********Joueur " + (numJ+1) + "********");
        System.out.println("Nb d'ouvrier total dans la zone " + z.getRessource() + " : " + z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier du joueur dans la zone " + z.getRessource() + " : " + z.getNbOuvirerDuJoueur(numJ));
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrier());
        //System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbRessource());
        if (ZoneVisitees.get(numJ).size()>0) {
            System.out.println("Les zones visitées : " + ZoneVisitees.get(numJ));
        }
    }

    /**
     * Restaure la liste des zones disponibles
     */
    private void resetZoneDispo() {
        for (Zone z: Zone.values()) {
            ZonesDispo.add(z);
        }
    }

    /**
     * Met à jour le status des zones : disponible ou pleine
     */
    public void updateStatutZone(){
        for (Zone z : Zone.values()) {
            if (z.getNbOuvrierSurZone() >= z.getNbOuvrierMaxSurZone()){
                ZonesPleines.add(z);
                ZonesDispo.remove(z);
            }
        }
    }

    /**
     * Vérifie si la zone est disponible pour pouvoir placer des ouvriers
     * @param choixZone La zone de placement
     * @param choixNbOuvrier Le nombre d'ouvriers à placer
     * @param i Le numéro du joueur
     * @return True ou False
     */
    private boolean verifierDisponibiliteZone(Zone choixZone, int choixNbOuvrier, int i) {
        if ((ZonesPleines.contains(choixZone)) | (choixNbOuvrier >choixZone.getNbOuvrierMaxSurZone()-choixZone.getNbOuvrierSurZone()) | (listeInventaire.get(i).getNbOuvrier()<choixNbOuvrier) ){
            return false;
        }
        if (ZoneVisitees.get(i).contains(choixZone) & choixZone!=Zone.CHASSE)
            return false;
        return true;
    }


}
