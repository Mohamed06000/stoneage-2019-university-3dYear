package stoneage;

public class ZoneForet extends ZoneRessource implements ZoneInterface {

    // Le Nombre de Ressource disponible dans la zone Foret.

    //int nbBois=30 ; pour l'instant pas utilisé .

    private static int nbOuvrierSurZone = 0;
    private int nbOuvrierDuJoueurI[] = new int[Joueur.getNbJoueur()];
    int somme = 0 ;


    // @return Nombre d'ouvrier sur la Zone Foret .

    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    public int getNbOuvrierDuJoueurI(int i) {
        return nbOuvrierDuJoueurI[i-1];
    }

    // Assigner un nombre d'ouvrier sur la zone

    public void setNbOuvrierSurZone(int nbOuvrierSurZone) {
        if ((nbOuvrierSurZone > 7) || (nbOuvrierSurZone < 0)){
            throw new java.lang.Error("Il ne peut pas y avoir plus de 7 personne dans la Foret !");
        }
        else {
            this.nbOuvrierSurZone = nbOuvrierSurZone;
        }
    }

    public void placeOuvrier(int nbOuvrierAplacer, int id) {
        if (ZoneForet.verifeZonePlein()){
            throw new java.lang.Error("La Zone Hutte est pleine !");
        }
        else {
            nbOuvrierSurZone += nbOuvrierAplacer;
            nbOuvrierDuJoueurI[id-1] = nbOuvrierAplacer;
        }
    }

    public void retirerOuvrier(int nbOuvrierRetirer,int id) {
        nbOuvrierSurZone -= nbOuvrierRetirer;
        nbOuvrierDuJoueurI[id-1] -= nbOuvrierRetirer;
    }

    public static boolean verifeZonePlein(){
        if (ZoneForet.nbOuvrierSurZone == 7){
            return true;
        }
        return false;
    }

    // Méthode qui calcule le nombre de Ressource récupérer par le joueur dans la zone.

    public  int  addnbRessourceBois(Joueur j) {

            for (int k = 0 ; k < getNbOuvrierDuJoueurI(j.getNum());k++){
                somme = somme + j.de();
            }
            if (somme > 6) {
                return  somme / 3 ;
            } else {
                return 0;
            }

    }
    // ajoute NbRessourceBois au joueur J.

    public void  gainZone(Joueur j){
        int i = j.getInventaireJoueur().getNbRessourceBois()+addnbRessourceBois(j);
        j.getInventaireJoueur().setNbRessourceBois(i);
    }

}
