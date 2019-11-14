package stoneage;

/**
 * Classe generalisee Village de "zone"
 */
public class ZoneHutte implements ZoneInterface {

    /**
     * Le nombre d'ouvrier present sur la zone Hutte
     */
    private static int nbOuvrierSurZone = 0;

    /**
     * Recupérer le  nombre d'ouvrier sur la zone Hutte
     *
     * @return Nombre d'ouvrier sur la Zone Hutte
     */
    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    /**
     * Assigner un nombre d'ouvier sur la zone
     *
     * @param nbOuvrierSurZone
     */
    public void setNbOuvrierSurZone(int nbOuvrierSurZone) {
        if ((nbOuvrierSurZone > 2) || (nbOuvrierSurZone < 0)){
            throw new java.lang.Error("Il ne peut pas y avoir plus de 2 personne dans la Hutte !");
        }
        else {
            this.nbOuvrierSurZone = nbOuvrierSurZone;
        }
    }

    /**
     * Placer un nombre d'ouvrier sur la zone, etant dans la hutte seule la valeur 2 sera accepté.
     *
     * @param nbOuvrierAplacer
     */
    public void placeOuvrier(int nbOuvrierAplacer) {
        if (ZoneHutte.verifeZonePlein()){
            throw new java.lang.Error("La Zone Hutte est pleine !");
        }
        if (nbOuvrierAplacer != 2){
            throw new java.lang.Error("Il doit y avoir deux personnes dans la Hutte !");
        }
        else {
            this.nbOuvrierSurZone = nbOuvrierAplacer;
        }
    }

    /**
     * Boolean, verifie si la zone Hutte est pleine (renvoie true) ou non (renvoie false).
     *
     */
    public static boolean verifeZonePlein(){
        if (ZoneHutte.nbOuvrierSurZone == 2){
            return true;
        }
        return false;
    }

    /**
     * retirer un nombre d'ouvrier de la zone
     *
     * @param nbOuvrierRetirer
     */
    public void retirerOuvrier(int nbOuvrierRetirer) {
        nbOuvrierSurZone -= nbOuvrierRetirer;
    }

    /**
     * Ajoute un ouvrier au joueur j
     * @param j
     *
     */

    public void gainZone(Joueur j){
        j.getInventaireJoueur().setNbOuvrier(j.getInventaireJoueur().getNbOuvrier()+1);
    }


}
