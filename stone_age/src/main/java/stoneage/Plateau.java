package stoneage;


import java.util.*;

/**
 * La classe du plateau de jeu
 */
public class Plateau {


    //CHAMPS

    boolean twoPlayers= (Partie.getNbJoueur()==2);
    boolean threePlayers= (Partie.getNbJoueur()==3);

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
     * Zone Champ
     */
    private Zone Champ;

    /**
     * Zone Hutte
     */
    private Zone Hutte;

    /**
     * Zone FabriqueOutils
     */
    private Zone FabriqueOutils;
    
    /*
     * tableau qui contient toutes les cartes de civilisations .
     * */
    
    
   public static  ArrayList<CarteCivilisation> cards=CarteCivilisation.CreationCarte();


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
     * La liste des zones visitées par le joueur
     */
    private ArrayList<ArrayList<Cartebatiment>> CarteVisitees;

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


    /**
     * La liste de toutes les cartes batiment
     */
    private  ArrayList<Cartebatiment> cartetotale;

    /**
     * Liste qui contient le deck des cartes batiment construit grace a la liste cartetotale
     */
    private ArrayList<ArrayList<Cartebatiment>> listeCarteTotale;


    /**
     * Creation de cartes batiments
     */
    private Cartebatiment carte1,carte2,carte3,carte4,carte5,carte6,carte7,
            carte8,carte9,carte10,carte11,carte12,carte13,carte14,carte15,
            carte16,carte17,carte18,carte19,carte20,carte21,carte22,carte23,
            carte24,carte25,carte26,carte27,carte28;


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
        this.carte5=new Cartebatiment(12,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.PIERRE)));
        this.carte6=new Cartebatiment(12,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.PIERRE)));
        this.carte7=new Cartebatiment(13,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.ARGILE,Ressource.PIERRE)));
        this.carte8=new Cartebatiment(14,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.PIERRE,Ressource.OR)));
        this.carte9=new Cartebatiment(14,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.PIERRE,Ressource.OR)));
        this.carte10=new Cartebatiment(13,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.PIERRE,Ressource.PIERRE)));
        this.carte11=new Cartebatiment(13,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.OR)));
        this.carte12=new Cartebatiment(13,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.OR)));
        this.carte13=new Cartebatiment(14,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.ARGILE,Ressource.OR)));
        this.carte14=new Cartebatiment(14,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.PIERRE,Ressource.PIERRE)));
        this.carte15=new Cartebatiment(15,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.PIERRE,Ressource.OR)));
        this.carte16=new Cartebatiment(15,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.PIERRE,Ressource.OR)));
        this.carte17=new Cartebatiment(15,new ArrayList<Ressource>(Arrays.asList(Ressource.PIERRE,Ressource.PIERRE,Ressource.OR)));
        this.carte18=new Cartebatiment(5,4,2);
        this.carte19=new Cartebatiment(5,3,2);
        this.carte20=new Cartebatiment(5,2,2);
        this.carte21=new Cartebatiment(5,1,2);
        this.carte22=new Cartebatiment(4,4,2);
        this.carte23=new Cartebatiment(4,3,2);
        this.carte24=new Cartebatiment(4,2,2);
        this.carte25=new Cartebatiment(4,1,2);
        this.carte26=new Cartebatiment(1,7,3);
        this.carte27=new Cartebatiment(1,7,3);
        this.carte28=new Cartebatiment(1,7,3);

        this.cartetotale = new ArrayList<Cartebatiment>(Arrays.asList(this.carte1,this.carte2,this.carte3,this.carte4,
                this.carte5,this.carte6,this.carte7,this.carte8,
                this.carte9,this.carte10,this.carte11,this.carte12,
                this.carte13,this.carte14,this.carte15,this.carte16,
                this.carte17,this.carte18,this.carte19,this.carte20,
                this.carte21,this.carte22,this.carte23,this.carte24,
                this.carte25,this.carte26,this.carte27,this.carte28));
        Collections.shuffle(cartetotale);
        this.listeCarteTotale= new ArrayList<ArrayList<Cartebatiment>>();

        this.Riviere = new Zone(Ressource.OR, 12, 6, 0, 7);
        this.Chasse = new Zone(Ressource.NOURRITURE, 12, 2, 0, Integer.MAX_VALUE);
        this.Foret = new Zone(Ressource.BOIS, 12, 3, 0, 7);
        this.Glaisiere = new Zone(Ressource.ARGILE, 12, 4, 0, 7);
        this.Carriere = new Zone(Ressource.PIERRE, 12, 5, 0, 7);
        this.Champ = new ZoneVillage(0,1,0);
        this.FabriqueOutils = new ZoneVillage(0,1,1);
        this.Hutte = new ZoneVillage(0,2,2);
        this.tabAllZone = new Zone[] {this.Riviere, this.Chasse, this.Foret, this.Glaisiere, this.Carriere,this.Champ,this.FabriqueOutils,this.Hutte};
        this.ZonesDispo = new ArrayList<Zone>(Arrays.asList(tabAllZone));
        this.ZoneVisitees = new ArrayList<ArrayList<Zone>>();
        this.CarteVisitees = new ArrayList<ArrayList<Cartebatiment>>();
        this.ZonesPleines = new ArrayList<Zone>();
        this.tableauFirstPlayer = new ArrayList<Integer>();

        ArrayList<Zone> zp;
        ArrayList<Cartebatiment> cp;
        ArrayList<Cartebatiment> carteTuiles;
        for (int i = 0; i < nbjoueur ; i++) {
            Inventaire inventaire = new Inventaire();
            listeInventaire.add(inventaire);
            zp = new ArrayList<Zone>();
            ZoneVisitees.add(zp);
            cp = new ArrayList<Cartebatiment>();
            CarteVisitees.add(cp);

            carteTuiles = new ArrayList<Cartebatiment>();
            listeCarteTotale.add(carteTuiles);
            for (int j = 0; j < 7; j++) {
                listeCarteTotale.get(i).add(cartetotale.get(0));
                cartetotale.remove(0);
            }
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
    public   ArrayList<Inventaire> getListeInventaire() {
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
        /**
         * Accumulateur pour savoir quand deux zones village sont occupeés affin de supprimer le 3eme !
         */
        int accVillage=0;

        boolean disponibiliteZone;
        boolean placed;
        int choixNbOuvrier;
        Zone choixZone;
        Cartebatiment choixCarte;


        while (nbOuvrierDispoTotal()>0) { // J'utilise la methode et non plus une variable afin que le compteur s'actualise
            for (int i : tableauFirstPlayer) {
                if (listeInventaire.get(i).getNbOuvrier()==0){ //S'il a déjà posé tous ses ouvriers, il passe son tour.
                    continue;
                }
                do {
                    placed = true;
                    int choixCarteOuZone = IA.choixCarteOuZone();
                    if (choixCarteOuZone==1) {
                        choixZone = IA.choixZone(ZonesDispo);
                        choixNbOuvrier = IA.choixNbOuvrier(listeInventaire.get(i), choixZone);
                        disponibiliteZone = verifierDisponibiliteZone(choixZone, choixNbOuvrier,i);

                        if (disponibiliteZone){
                            listeInventaire.get(i).setNbOuvrier(listeInventaire.get(i).getNbOuvrier() - choixNbOuvrier);
                            choixZone.placeOuvrierSurZone(choixNbOuvrier, i); //J'ajoute le num du joueur en parametre.
                            ZoneVisitees.get(i).add(choixZone);
                            if (twoPlayers && choixZone!=Chasse) { ZonesPleines.add(choixZone);}
                            if (twoPlayers| threePlayers)
                            {
                                if (choixZone instanceof ZoneVillage) { accVillage++; }
                            }
                            updateStatutZone(); // Je fais l'uptade apres la placement et non plus avant afin que l'autre joueur beneficie de l'uptade pour le choix de la zone.
                            placed = false;
                            if(affichage)
                            {
                                AfficheInfoJoueur(i,choixZone, ZoneVisitees,CarteVisitees, listeInventaire.get(i));
                            }
                            if(accVillage==2){ ZonesDispo.remove(ZonesDispo.size()-1);}

                        }
                    }
                    if (choixCarteOuZone==2) {
                        choixCarte = IA.choixCartePlacement(listeCarteTotale);
                        listeInventaire.get(i).setNbOuvrier(listeInventaire.get(i).getNbOuvrier() - 1);
                        CarteVisitees.get(i).add(choixCarte);
                        placed = false;
                        if(affichage)
                        {
                            AfficheInfoJoueur(i,choixCarte,ZoneVisitees, CarteVisitees, listeInventaire.get(i));
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
        Cartebatiment carteCourant;
        for (int i :tableauFirstPlayer) {
            while((ZoneVisitees.get(i).size()+CarteVisitees.get(i).size())>0) { // Je parcoure la taille de la sous-liste et non plus de la liste afin d'eviter Out-Bound
                int choixCarteOuZone = IA.choixCarteOuZone();

                if (choixCarteOuZone==1 && ZoneVisitees.get(i).size()>0) {
                    zoneCourant = IA.choixZone(ZoneVisitees.get(i));
                    if (IA.choixUtiliser()) { //IA choisit d'utiliser ses ouvriers ou non --> && verifier si getNbRessourde>=prixCarte
                        zoneCourant.gainZone(listeInventaire.get(i),i,IA); // J'ajoute le num du joueur.
                    }
                    else {
                        zoneCourant.retirerOuvrierSurZone(listeInventaire.get(i), zoneCourant.getNbOuvirerDuJoueur(i), i);
                    }
                    ZoneVisitees.get(i).remove(zoneCourant);
                    if(affichage){
                        AfficheInfoJoueur(i,zoneCourant, ZoneVisitees, CarteVisitees,listeInventaire.get(i));
                    }
                }

                if (choixCarteOuZone==2 && CarteVisitees.get(i).size()>0){
                    carteCourant = IA.choixCarteRecuperation(CarteVisitees.get(i));
                    if (listeInventaire.get(i).getNbRessourceTotal()>=carteCourant.getNbRessourceApayer() && IA.choixUtiliser()) {
                        int choixNbRessource = IA.choixNbRessource();
                        carteCourant.payement(listeInventaire.get(i),choixNbRessource);
                        listeInventaire.get(i).getCartesBatiments().add(carteCourant);
                        for (int j = 0; j < listeCarteTotale.size(); j++) {
                            if (listeCarteTotale.get(j).contains(carteCourant)){
                                listeCarteTotale.get(j).remove(carteCourant);
                            }
                        }
                    }
                    else {
                        carteCourant.retirerOuvrierSurCarte(listeInventaire.get(i));
                    }
                    CarteVisitees.get(i).remove(carteCourant);
                    if(affichage){
                        AfficheInfoJoueur(i,carteCourant,ZoneVisitees, CarteVisitees, listeInventaire.get(i));
                    }
                }

            }
            ZoneVisitees.get(i).clear();
            CarteVisitees.get(i).clear();
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
    public static void AfficheInfoJoueur(int numJ, Zone z, ArrayList<ArrayList<Zone>> ZoneVisitees,ArrayList<ArrayList<Cartebatiment>> CarteVisitees, Inventaire inventaire) {
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

    public static void AfficheInfoJoueur(int numJ, Cartebatiment c, ArrayList<ArrayList<Zone>> ZoneVisitees,ArrayList<ArrayList<Cartebatiment>> CarteVisitees, Inventaire inventaire) {
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

            if (threePlayers && ZonesDispo.contains(z)){
                int acc=0;
                for (int i = 0; i <3; i++) {
                    if (z.getNbOuvirerDuJoueur(i)>0){acc++;}
                }
                if (acc==2)
                {
                    ZonesPleines.add(z);
                    iter.remove();
                }
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

    public boolean verifierNbCarteBatiment() {
        for (int i = 0; i < listeCarteTotale.size(); i++) {
            if (listeCarteTotale.get(i).size()<1) {
                return false;
            }
        }
        return true;
    }

}
