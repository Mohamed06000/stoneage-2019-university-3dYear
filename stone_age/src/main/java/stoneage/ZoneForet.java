package stoneage;

public class ZoneForet extends ZoneRessource implements ZoneInterface {

    // Le Nombre de Ressource disponible dans la zone Foret.

    //int nbBois=30 ; pour l'instant pas utilisé .

    // le nombre d'ouvrier présent dans la zone Foret.

    private static int nbOuvrierSurZone = 0  ;

    // @return Nombre d'ouvrier sur la Zone Foret .

    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
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

    // placer un nombre d'ouvrier dans la Zone .

    public void placeOuvrier(int nbOuvrierAplacer) {
        if (ZoneForet.verifeZonePlein()){
            throw new java.lang.Error("La Zone Foret est pleine !");
        }
        else {
            this.nbOuvrierSurZone = nbOuvrierAplacer;
        }
    }

    //Vérifie si la Zone foret est pleine.

    public static boolean verifeZonePlein(){
        if (ZoneForet.nbOuvrierSurZone == 7){
            return true;
        }
        return false;
    }

    // Méthode qui calcule le nombre de Ressource récupérer par le joueur dans la zone.

    public  int  addnbRessourceBois(Joueur j) {
        int somme = 0 ;
            for (int k = 0 ; k < j.getInventaireJoueur().getNbOuvrier();k++){
                somme = somme + j.dé();
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
