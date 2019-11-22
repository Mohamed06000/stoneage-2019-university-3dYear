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
            dicoJoueurs.put(i, inventaire);
            listeInventaire.add(inventaire);
            zp = new ArrayList<Zone>();
            ZoneVisite.add(zp);
        }
        /*this.listeJoueur = new ArrayList<Joueur>();*/

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
        int nbOuvrierDispoTotal = nbOuvrierDispoTotal();
        boolean placed = true;
        boolean disponibiliteZone = true;
        Joueur IA = new Joueur();
        Inventaire inventaireIA;
        int choixNbOuvrier;
        Zone choixZone;

        while (nbOuvrierDispoTotal>0) {
            for (int i = 0; i<listeInventaire.size(); i++) {
                inventaireIA = new Inventaire(listeInventaire.get(i));
                do {
                    choixNbOuvrier = IA.choixNbOuvrier(inventaireIA);
                    choixZone = IA.choixZone(ZonesDispo);
                    disponibiliteZone = verifierDisponibiliteZone(choixZone, choixNbOuvrier);
                    if (disponibiliteZone){
                        AfficheInfoJoueur(i,choixZone);
                        updateStatutZone();
                        listeInventaire.get(i).enleveOuvrierDispo(choixNbOuvrier);
                        choixZone.placeOuvrierSurZone(listeInventaire.get(i), choixNbOuvrier);
                        ZoneVisite.get(i).add(choixZone);
                        placed = false;
                        nbOuvrierDispoTotal-=choixNbOuvrier;
                    }

                }
                while (placed);
            }
        }
    }


    public static void AfficheInfoJoueur(int numJ, Zone z) {
        System.out.println("********Joueur " + (numJ+1) + "********");
        System.out.println("Nb d'ouvrier total dans la zone " + z.getClass().getSimpleName() + " : " + z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier du joueur dans la zone " + z.getClass().getSimpleName() + " : " + (listeInventaire.get(numJ).getNbOuvrier() - listeInventaire.get(numJ).getNbOuvrierDispo()));
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + numJ + " : " + listeInventaire.get(numJ).getNbOuvrier());
        //System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbRessource());
        if (ZoneVisite.size()>0) {
            System.out.println("Les zones visitées : " + ZoneVisite.get(numJ));
        }
    }



    public void recuperationPhase(){
        Zone zoneCourant;
        for (int i = 0; i < listeInventaire.size() ; i++) {
            for (int j = 0; j < ZoneVisite.size(); j++) {
                zoneCourant = ZoneVisite.get(i).get(j);
                zoneCourant.gainZone(listeInventaire.get(i), zoneCourant);
                AfficheInfoJoueur(i,zoneCourant);
            }
            ZoneVisite.get(i).clear();
            listeInventaire.get(i).ajouteOuvrierDispo(listeInventaire.get(i).getNbOuvrier());
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
            n += listeInventaire.get(i).getNbOuvrierDispo();
        }
        return n;
    }


    public static void main(String[] args) {
        /*ZonesDispo.get(1).setNbOuvrierSurZone(4);
        ZonesPleines.add(ZonesDispo.get(1));
        ZonesDispo.remove(0);
        //ZonesPleines.get(0).setNbOuvrierSurZone(4);*/
        Plateau p = new Plateau(2);
        p.getZonesDispo();
        Zone z1 = Zone.CHASSE;
        Zone z2 = Zone.CHASSE;
        System.out.println(z1.getNbOuvrierSurZone());
        z1.setNbOuvrierSurZone(3);
        System.out.println(z1.getNbOuvrierSurZone());
        z1.setNbOuvrierSurZone(48);
        System.out.println(z1.getNbOuvrierSurZone());
        System.out.println(z2.getNbOuvrierSurZone());
        System.out.println(listeInventaire.size());

        //System.out.println(ZonesPleines.get(0).getNbOuvrierSurZone());
    }
}
