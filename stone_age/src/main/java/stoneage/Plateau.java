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




    public void recuperationPhase(){
        Zone zoneCourant;
        for (int i = 0; i < listeInventaire.size() ; i++) {
            for (int j = 0; j < ZoneVisite.size(); j++) {
                zoneCourant = ZoneVisite.get(i).get(j);
                zoneCourant.gainZone(listeInventaire.get(i), zoneCourant);
            }
        ZoneVisite.get(i).clear();
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
