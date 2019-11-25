package stoneage;


import java.util.*;

public class Plateau {
    private static ArrayList<Zone> ZonesDispo;
    private static ArrayList<Zone> ZonesPleines;
    private static ArrayList<ArrayList<Zone>> ZoneVisite;
    private Dictionary dicoJoueurs = new Hashtable();
    private static ArrayList<Inventaire> listeInventaire = new ArrayList<Inventaire>();


    Plateau(int nbjoueur){
        this.ZonesDispo = new ArrayList<Zone>(Arrays.asList(Zone.values()));
        this.ZoneVisite = new ArrayList<ArrayList<Zone>>();
        this.ZonesPleines = new ArrayList<Zone>();
        ArrayList<Zone> zp;
        for (int i = 0; i < nbjoueur ; i++) {
            Inventaire inventaire = new Inventaire();
            dicoJoueurs.put(i, inventaire); //Non utilisé, donc utilité ?
            listeInventaire.add(inventaire);
            zp = new ArrayList<Zone>();
            ZoneVisite.add(zp);
        }

    }

    public ArrayList<Zone> getZonesDispo() {
        return ZonesDispo;
    }

    public ArrayList<Zone> getZonesPleines() {
        return ZonesPleines;
    }

    public Dictionary getDicoJoueurs() {
        return dicoJoueurs;
    }

    public ArrayList<Inventaire> getListeInventaire() {
        return listeInventaire;
    }

    public void placementPhase(){
        boolean placed; // J'initialise dans la boucle while pour que le joueur ait plusieurs choix de zone avant de passer à un autre joueur.
        boolean disponibiliteZone;
        Joueur IA = new Joueur();
        int choixNbOuvrier;
        Zone choixZone;

        while (nbOuvrierDispoTotal()>0) { // J'utilise la methode et non plus une variable afin que le compteur s'actualise
            for (int i = 0; i<listeInventaire.size(); i++) {
                if (listeInventaire.get(i).getNbOuvrier()==0) //S'il a déjà posé tous ses ouvriers, il passe son tour.
                    continue;
                do {
                    placed = true;
                    choixNbOuvrier = IA.choixNbOuvrier(listeInventaire.get(i));
                    choixZone = IA.choixZone(ZonesDispo);
                    disponibiliteZone = verifierDisponibiliteZone(choixZone, choixNbOuvrier);
                    if (disponibiliteZone){
                        System.out.println("----AVANT----");
                        AfficheInfoJoueur(i,choixZone);
                        listeInventaire.get(i).enleveOuvrierDispo(choixNbOuvrier);
                        choixZone.placeOuvrierSurZone(listeInventaire.get(i), choixNbOuvrier, i); //J'ajoute le num du joueur en parametre.
                        ZoneVisite.get(i).add(choixZone);
                        updateStatutZone(); // Je fais l'uptade apres la placement et non plus avant afin que l'autre joueur beneficie de l'uptade pour le choix de la zone.
                        placed = false;
                        System.out.println("----APRES----");
                        AfficheInfoJoueur(i,choixZone);
                    }

                }
                while (placed);
            }
        }
    }


    public static void AfficheInfoJoueur(int numJ, Zone z) {
        System.out.println("********Joueur " + (numJ+1) + "********");
        System.out.println("Nb d'ouvrier total dans la zone " + z.getRessource() + " : " + z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier du joueur dans la zone " + z.getRessource() + " : " + z.getNbOuvirerDuJoueur(numJ));
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + (numJ+1) + " : " + listeInventaire.get(numJ).getNbOuvrier());
        //System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbRessource());
        if (ZoneVisite.get(numJ).size()>0) {
            System.out.println("Les zones visitées : " + ZoneVisite.get(numJ));
        }
    }



    public void recuperationPhase(){
        Zone zoneCourant;
        for (int i = 0; i < listeInventaire.size() ; i++) {
            for (int j = 0; j < ZoneVisite.get(i).size(); j++) { // Je parcoure la taille de la sous-liste et non plus de la liste afin d'eviter Out-Bound
                zoneCourant = ZoneVisite.get(i).get(j); // Ici a changer afin de recuperer dans une zone aleatoire.
                zoneCourant.gainZone(listeInventaire.get(i),i); // J'ajoute le num du joueur.
                AfficheInfoJoueur(i,zoneCourant);
            }
            ZoneVisite.get(i).clear();
        }
        ZonesPleines.clear();
        ZonesDispo.clear();
        resetZoneDispo();
    }

    private void resetZoneDispo() {
        for (Zone z: Zone.values()) {
            ZonesDispo.add(z);
        }
    }

    public void phaseNourrir(){
        for (int i = 0 ; i < listeInventaire.size(); i++) {
            Joueur.nourrir(listeInventaire.get(i));
        }
    }


    public void updateStatutZone(){
        for (Zone z : Zone.values()) {
            if (z.getNbOuvrierSurZone() >= z.getNbOuvrierMaxSurZone()){
                ZonesPleines.add(z);
                ZonesDispo.remove(z);
            }
        }
    }

    private boolean verifierDisponibiliteZone(Zone choixZone, int choixNbOuvrier) {
        if ((ZonesPleines.contains(choixZone)) && (choixNbOuvrier >choixZone.getNbOuvrierMaxSurZone()-choixZone.getNbOuvrierSurZone()) ){
            return false;
        }
        if ((choixZone == Zone.HUTTE) && (choixNbOuvrier!=2)){
            return false;
        }
        return true;
    }

    protected int nbOuvrierDispoTotal() {
        int n = 0;
        for (int i = 0; i<listeInventaire.size(); i++){
            n += listeInventaire.get(i).getNbOuvrier(); //On reste que sur nbOuvriers et on ne travaille plus avec nbOuvriersDispo
        }
        return n;
    }
}
