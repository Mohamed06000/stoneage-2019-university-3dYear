package stoneage.joueur;

import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.cartes.Cartebatiment;
import stoneage.plateaudejeu.zones.Zone;
import stoneage.plateaudejeu.zones.ZoneVillage;

import java.util.ArrayList;
import java.util.Random;

public class IaAlea {


    Random rand = new Random();


    /**
     * Choisit le nombre d'ouvrier à placer
     * @param inventaire L'inventaire du joueur
     * @param choixZone La zone choisit
     * @return Un nombre d'ouvriers
     */
    public int choixNbOuvrier(Inventaire inventaire, Zone choixZone) {
        int alea = 0;
        //&& (((ZoneVillage) choixZone).getType_zone()== 0 ||
        //                ((ZoneVillage) choixZone).getType_zone()==1)

        if ((choixZone instanceof ZoneVillage )) {
            if ( ((ZoneVillage) choixZone).getType_zone()==2){
            alea = 2;}
            else alea=1;
        }
        else {
            alea = rand.nextInt(inventaire.getNbOuvrier()) + 1; //le +1 a l'exterieur de rand sinon ca peut retourner 0.

        }
        return alea;
    }



    public int choixCarteOuZone() {
        return rand.nextInt(2)+1;
    }

    public Cartebatiment choixCartePlacement(ArrayList<ArrayList<Cartebatiment>> listeCarteTotale) {
        int alea = rand.nextInt(listeCarteTotale.size()); // Sans +1 a l'interieur de rand sinon ca peut retourner alea=8 alors qu'on a index max = 7.
        return listeCarteTotale.get(alea).get(0);
    }

    public Cartebatiment choixCarteRecuperation(ArrayList<Cartebatiment> CarteVisitees) {
        int alea = rand.nextInt(CarteVisitees.size());
        return CarteVisitees.get(alea);
    }

    /**
     * Choisit la zone de placement
     * @param zonesDispo Les zones disponibles au placement
     * @return Une zone
     */
    public Zone choixZone(ArrayList<Zone> zonesDispo) {
        int alea = rand.nextInt(zonesDispo.size()); // Sans +1 a l'interieur de rand sinon ca peut retourner alea=8 alors qu'on a index max = 7.
        return zonesDispo.get(alea);
    }




    /**
     * Choisit s'il utiliser ses outils
     * @param inventaire Inventaire du joueur
     * @return Un boolean
     */
    public boolean choixOutils(Inventaire inventaire) {
        if (inventaire.getOutilsDispo().size()>0) {
            return rand.nextBoolean();
        }
        else {
            return false;
        }
    }

    public int choixNbRessource(){
        return rand.nextInt(7)+1;
    }

    /**
     * Récupère la somme des outils utilisés
     * @param inventaire L'inventaire du joueur
     * @return La somme des outils
     */
    public int choixNbOutils(Inventaire inventaire) {
        int sommeOutils =0;
        int nbOutilsUtilise = rand.nextInt(inventaire.getOutilsDispo().size())+1;

        for (int i = 0; i < nbOutilsUtilise ; i++) {
            int indice = rand.nextInt(inventaire.getOutilsDispo().size());
            sommeOutils += inventaire.getOutilsDispo().get(indice);
            inventaire.getOutilsNonDispo().add(inventaire.getOutilsDispo().get(indice));
            inventaire.getOutilsDispo().remove(indice);
        }

        return sommeOutils;
    }

    /**
     * Choisit s'il utilise ses ouvriers
     * @return Un boolean
     */
    public boolean choixUtiliser() {
        return true;
    }



}
