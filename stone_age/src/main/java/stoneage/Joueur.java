package stoneage;

public class Joueur {
    public Inventaire placement(Inventaire i){
        return new Inventaire(i.getNbOuvrier() - 1, i.getNbRessource());
    }

    public Inventaire recupere(Inventaire i, Zone z){
       return new Inventaire(i.getNbOuvrier() + 1, i.getNbRessource() + 1 ) ;
    }
}
