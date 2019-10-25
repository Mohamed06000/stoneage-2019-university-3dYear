package stoneage;

public class Joueur {
    public void placement(Inventaire i){
        i.setNbOuvrier(i.getNbOuvrier() - 1);
        i.setNbRessource(i.getNbRessource());
    }

    public void recupere(Inventaire i, Zone z){
        i.setNbOuvrier(i.getNbOuvrier() + 1);
        i.setNbRessource(i.getNbRessource() + 1 ) ;
    }
}
