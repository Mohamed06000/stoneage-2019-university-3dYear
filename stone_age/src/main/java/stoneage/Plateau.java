package stoneage;


import java.util.*;

public class Plateau {
    private static ArrayList<Zone> ZonesDispo;
    private static ArrayList<Zone> ZonesPleines;
    private static ArrayList<ArrayList<Zone>> ZoneVisite;
    private Dictionary dicoJoueurs = new Hashtable();
    /*private static ArrayList<Joueur> listeJoueur;*/
    private static ArrayList<Inventaire> listeInventaire = new ArrayList<Inventaire>();

    Plateau(int nbjoueur){
        this.ZonesDispo = new ArrayList<Zone>(Arrays.asList(Zone.values()));
        this.ZonesPleines = new ArrayList<Zone>();
        for (int i = 0; i < nbjoueur ; i++) {
            Inventaire inventaire = new Inventaire();
            dicoJoueurs.put(i, inventaire);
            listeInventaire.add(inventaire);
        }
        this.listeInventaire = new ArrayList<Inventaire>();
        ZoneVisite = new ArrayList<ArrayList<Zone>>();
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
                        listeInventaire.get(i).enleveOuvrierDispo(choixNbOuvrier);
                        choixZone.placeOuvrierSurZone(listeInventaire.get(i), choixNbOuvrier);
                        ZoneVisite.get(i).add(choixZone);
                        placed = false;
                    }

                }
                while (placed);
            }
        }
    }





    public void recuperationPhase(){
        Zone zoneCourant;
        for (int i = 0; i < listeInventaire.size() ; i++) {
            for (int j = 0; j < ZoneVisite.size(); j++) {
                zoneCourant = ZoneVisite.get(i).get(j);
                zoneCourant.gainZone(listeInventaire.get(i), zoneCourant);
            }
            ZoneVisite.get(i).clear();
            listeInventaire.get(i).ajouteOuvrierDispo(listeInventaire.get(i).getNbOuvrier());
        }
        ZonesPleines.clear();
        ZonesDispo.clear();
        ZonesDispo = (ArrayList<Zone>) Arrays.asList(Zone.values());
    }

    public void phaseNourrir(){
        Joueur j;
        int i = 0;
        for (Enumeration k = dicoJoueurs.keys(); k.hasMoreElements();) {
            j = (Joueur) k.nextElement();
            j.nourrir(listeInventaire.get(i));
            i++;
        }
    }



    private boolean verifierDisponibiliteZone(Zone choixZone, int choixNbOuvrier) {
        if ((ZonesPleines.contains(choixZone)) && (choixNbOuvrier >choixZone.getNbOuvrierMaxSurZone()-choixZone.getNbOuvrierSurZone()) ){
            return false;
        }
        /*verifier et mettre les zones pleines des Dispo dans la liste des zones pleines*/
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
        //System.out.println(ZonesPleines.get(0).getNbOuvrierSurZone());
    }
}
