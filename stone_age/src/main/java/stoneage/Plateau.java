package stoneage;


import java.util.*;

/**
 * La classe du plateau de jeu
 */
public class Plateau {

    //CHAMPS

    /**
     * Zone riviere
     */
    private Zone Riviere;

    /**
     * Zone chasse
     */
    private Zone Chasse;

    /**
     * Zone Foret
     */
    private Zone Foret;

    /**
     * Zone Glaciere
     */
    private Zone Glaisiere;

    /**
     * Zone Carriere
     */
    private Zone Carriere;
    
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
    
    /**
     * Liste des inventaires des joueurs
     */
    private ArrayList<Inventaire> listeInventaire = new ArrayList<Inventaire>();
    /**
     * L'IA qui fait les choix de jeu
     */
    Joueur IA = new Joueur();
    /**
     * La liste des numéro des joueurs
     */
    private ArrayList<Integer> tableauFirstPlayer;

    /**
     * Le tableau de toutes les zones
     */
    private Zone [] tabAllZone;

    ArrayList<Cartebatiment> listeCarteB = new ArrayList<Cartebatiment>();
    ArrayList<Cartebatiment> listeCarteVisible;
    Cartebatiment[] listeCarteTotale;
    ArrayList<Cartebatiment> listeCarteReserve;

    private Cartebatiment carte1;
    private Cartebatiment carte2;
    private Cartebatiment carte3;
    private Cartebatiment carte4;



    //CONSTRUTEUR

    /**
     * Constructeur de la classe
     * @param nbjoueur Le nombre de joueurs dans le jeu
     */
    Plateau(int nbjoueur){
        this.carte1=new Cartebatiment(10,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.BOIS,Ressource.ARGILE)));
        this.carte2=new Cartebatiment(11,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.BOIS,Ressource.PIERRE)));
        this.carte3=new Cartebatiment(11,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.ARGILE)));
        this.carte4=new Cartebatiment(12,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.BOIS,Ressource.OR)));
        this.listeCarteTotale= new Cartebatiment[] {this.carte1,this.carte2,this.carte3,this.carte4};
        this.listeCarteVisible= new ArrayList<Cartebatiment>(Arrays.asList(listeCarteTotale));
        this.listeCarteReserve=new ArrayList<Cartebatiment>();
        this.listeCarteVisible=new ArrayList<Cartebatiment>();
        this.Riviere = new Zone(Ressource.OR, 12, 6, 0, 7);
        this.Chasse = new Zone(Ressource.NOURRITURE, 12, 2, 0, Integer.MAX_VALUE);
        this.Foret = new Zone(Ressource.BOIS, 12, 3, 0, 7);
        this.Glaisiere = new Zone(Ressource.ARGILE, 12, 4, 0, 7);
        this.Carriere = new Zone(Ressource.PIERRE, 12, 5, 0, 7);
        this.tabAllZone = new Zone[] {this.Riviere, this.Chasse, this.Foret, this.Glaisiere, this.Carriere};
        this.ZonesDispo = new ArrayList<Zone>(Arrays.asList(tabAllZone));
        this.ZoneVisitees = new ArrayList<ArrayList<Zone>>();
        this.ZonesPleines = new ArrayList<Zone>();
        this.tableauFirstPlayer = new ArrayList<Integer>();
        ArrayList<Zone> zp;
        for (int i = 0; i < nbjoueur ; i++) {
            Inventaire inventaire = new Inventaire();
            listeInventaire.add(inventaire);
            zp = new ArrayList<Zone>();
            ZoneVisitees.add(zp);
            tableauFirstPlayer.add(i);
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
     * @param affichage Si l'affichage se fait
     */
    public void placementPhase(boolean affichage){
        boolean disponibiliteZone;
        boolean placed;
        int choixNbOuvrier;
        Zone choixZone;


        while (nbOuvrierDispoTotal()>0) { // J'utilise la methode et non plus une variable afin que le compteur s'actualise
            for (int i : tableauFirstPlayer) {
                if (listeInventaire.get(i).getNbOuvrier()==0){ //S'il a déjà posé tous ses ouvriers, il passe son tour.
                    continue;
                }
                do {
                    placed = true;
                    choixZone = IA.choixZone(ZonesDispo);
                    choixNbOuvrier = IA.choixNbOuvrier(listeInventaire.get(i), choixZone);
                    disponibiliteZone = verifierDisponibiliteZone(choixZone, choixNbOuvrier,i);
                    if (disponibiliteZone){
                        listeInventaire.get(i).setNbOuvrier(listeInventaire.get(i).getNbOuvrier() - choixNbOuvrier);
                        choixZone.placeOuvrierSurZone(choixNbOuvrier, i); //J'ajoute le num du joueur en parametre.
                        ZoneVisitees.get(i).add(choixZone);
                        updateStatutZone(); // Je fais l'uptade apres la placement et non plus avant afin que l'autre joueur beneficie de l'uptade pour le choix de la zone.
                        placed = false;
                        if(affichage){
                            AfficheInfoJoueur(i,choixZone, ZoneVisitees, listeInventaire.get(i));
                        }
                    }

                }
                while (placed);
            }
        }
    }

    /**
     * Lance la phase de récupération
     * @param affichage Si l'affichage se fait
     */
    public void recuperationPhase(boolean affichage){
        Zone zoneCourant;
        for (int i :tableauFirstPlayer) {
            while(ZoneVisitees.get(i).size()>0) { // Je parcoure la taille de la sous-liste et non plus de la liste afin d'eviter Out-Bound
                zoneCourant = IA.choixZone(ZoneVisitees.get(i));
                if (IA.choixUtiliser()) { //IA choisit d'utiliser ses ouvriers ou non --> && verifier si getNbRessourde>=prixCarte
                    zoneCourant.gainZone(listeInventaire.get(i),i,IA); // J'ajoute le num du joueur.
                }
                else {
                    zoneCourant.retirerOuvrierSurZone(listeInventaire.get(i), zoneCourant.getNbOuvirerDuJoueur(i), i);
                }
                ZoneVisitees.get(i).remove(zoneCourant);
                if(affichage){
                    AfficheInfoJoueur(i,zoneCourant, ZoneVisitees, listeInventaire.get(i));
                }
            }
            ZoneVisitees.get(i).clear();
        }
        resetZone();
    }

    /**
     * Lance la phase nourrir
     */
    public void phaseNourrir(){
        for (int i :tableauFirstPlayer) {
            IA.nourrir(listeInventaire.get(i));
            resetOutils(i);
        }
        swap(tableauFirstPlayer);
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
        if (ZoneVisitees.get(numJ).size()>0) {
            System.out.println("Les zones visitées : " + (ZoneVisitees.get(numJ)));
        }
    }

    /**
     * Restaure la liste des outils disponibles
     */
    public void resetOutils(int i) {
        listeInventaire.get(i).getOutilsNonDispo().clear();
        listeInventaire.get(i).getOutilsDispo().clear();
        for (int o : listeInventaire.get(i).getOutils()) {
            listeInventaire.get(i).getOutilsDispo().add(o);
        }
    }

    /**
     * Restaure la liste des zones disponibles
     */
    public void resetZone() {
        ZonesPleines.clear();
        ZonesDispo.clear();
        //ZonesDispo.addAll(Arrays.asList(tabAllZone));
        for (Zone z: tabAllZone) {
            ZonesDispo.add(z);
        }
    }

    /**
     * Met à jour le status des zones : disponible ou pleine
     */
    public void updateStatutZone(){
        Iterator<Zone> iter = ZonesDispo.iterator();
        while (iter.hasNext()) {
            Zone z = iter.next();

            if (z.getNbOuvrierSurZone() >= z.getNbOuvrierMaxSurZone()){
                ZonesPleines.add(z);
                iter.remove();
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
    public boolean verifierDisponibiliteZone(Zone choixZone, int choixNbOuvrier, int i) {
        if ((ZonesPleines.contains(choixZone)) | (choixNbOuvrier > choixZone.getNbOuvrierMaxSurZone()-choixZone.getNbOuvrierSurZone()) | (listeInventaire.get(i).getNbOuvrier()<choixNbOuvrier) ){
            return false;
        }
        return !(ZoneVisitees.get(i).contains(choixZone) & choixZone != Chasse);
    }

    /**
     * Permutation de l'ordre du premier joueur à jouer
     * @param tableauFirstPlayer Le tableau des numéros des joueurs
     */
    public void swap (ArrayList<Integer> tableauFirstPlayer) {
        int a;
        for (int i =0;i < tableauFirstPlayer.size()-1; i++) {
            Collections.swap(tableauFirstPlayer, i, i+1);

        }
    }

//    public boolean verifierNbCarteCivilisation() {
//        if ((carteCivilisationPioche.size()+carteCivilisationDispo.size())<4)
//            return false;
//        else
//            return true;
//    }
//
//    public boolean verifierNbCarteBatiment() {
//        for (int i = 0; i < carteBatiment.size(); i++) {
//            if (carteBatiment.get(i).size()<1) {
//                return false;
//            }
//        }
//        return true;
//    }

}
