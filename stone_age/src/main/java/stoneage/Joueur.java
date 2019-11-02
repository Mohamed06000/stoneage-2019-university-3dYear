package stoneage;

public class Joueur {

    private int num;
    private static int nbJoueur;

    public Joueur(){
        nbJoueur ++;
        num = nbJoueur;
    }

    public static int getNbJoueur(){
        return nbJoueur;
    }

    public int getNom(){
        return num;
    }

    public void placement(Inventaire i, Zone z){
        i.setNbOuvrier(i.getNbOuvrier() - 1);
        z.placeOuvrier(1);
    }

    public void recupere(Inventaire i, Zone z){
        i.setNbOuvrier(i.getNbOuvrier() + 1);
        i.setNbRessource(i.getNbRessource() + 1 ) ;
        z.retirerOuvrier(1);
    }
}
