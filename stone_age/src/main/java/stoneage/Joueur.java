package stoneage;

public class Joueur {

    private int num;
    private int nbJoueur;

    public Joueur(){
        nbJoueur ++;
        num = nbJoueur;
    }

    public int getNbJoueur(){
        return nbJoueur;
    }

    public int getNom(){
        return num;
    }

    public void placement(Inventaire i){
        i.setNbOuvrier(i.getNbOuvrier() - 1);
    }

    public void recupere(Inventaire i, Zone z){
        i.setNbOuvrier(i.getNbOuvrier() + 1);
        i.setNbRessource(i.getNbRessource() + 1 ) ;
        z.retirerOuvrier(1);
    }
}
