package stoneage ;

/**
 * Classe qui represente la Zone Champ qui permet de multiplier la quantite� de nourriture gagn� par un niveauAgriculture
 */
public class ZoneChamp extends ZoneVillage implements ZoneInterface {

    /**
     * Le nombre d'ouvrier present sur la zone
     */
    private static int nbOuvrierSurZone = 0;

    /**
     * La liste du nombre d'ouvrier qu'un joueur ait placé sur la zone
     */
    private int nbOuvrierDuJoueurI[] = new int[Joueur.getNbJoueur()];

    /**
     * Boolean, verifie si la zone Hutte est pleine (renvoie true) ou non (renvoie false).
     *
     */
    public static boolean verifeZonePlein(){
        if (ZoneChamp.nbOuvrierSurZone == 1){
            return true;
        }
        return false;
    }

    /**
     * Placer les ouvriers sur la zone
     * @param nbOuvrierAplacer un nombre d'ouvrier
     * @param id le num du joueur
     */
    public void placeOuvrier(int nbOuvrierAplacer, int id) {
        if (ZoneChamp.verifeZonePlein()){
            throw new java.lang.Error("La Zone Champ est pleine !");
        }
        if (nbOuvrierAplacer != 1){
            throw new java.lang.Error("Il doit y avoir une personne dans le Champ !");
        }
        else {
            nbOuvrierSurZone += nbOuvrierAplacer;
            nbOuvrierDuJoueurI[id-1] = nbOuvrierAplacer;
        }
    }

    /**
     * retirer un nombre d'ouvrier de la zone
     * @param nbOuvrierRetirer un nombre d'ouvrier
     * @param id le num du joueur
     */
    public void retirerOuvrier(int nbOuvrierRetirer,int id) {
        nbOuvrierSurZone -= nbOuvrierRetirer;
        nbOuvrierDuJoueurI[id-1] -= nbOuvrierRetirer;
    }

    /**
     * Recuperer le nombre d'ouvrier sur la zone
     * @return le nombre d'ouvrier
     */
    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    /**
     * Recuperer le nombre d'ouvrier du joueur i sur la zone
     * @param i le num du joueur
     * @return le nombre d'ouvriers
     */
    public int getNbOuvrierDuJoueurI(int i) {
        return nbOuvrierDuJoueurI[i-1];
    }

    /**
     * Fait gagner un gain au joueur
     * @param j le joueur
     */
    public void gainZone(Joueur j){
        j.getInventaireJoueur().addNiveauAgriculture();
    }
}

