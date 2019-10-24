package stoneage;

public class Inventaire {
    private int nbOuvrier;
    private int nbRessource;

    public int getNbOuvrier() {
        return nbOuvrier;
    }

    public void setNbOuvrier(int nbOuvrier) {
        this.nbOuvrier = nbOuvrier;
    }

    public int getNbRessource() {
        return nbRessource;
    }

    public void setNbRessource(int nbRessource) {
        this.nbRessource = nbRessource;
    }

    public Inventaire(){
        setNbOuvrier(1);
    }

    public Inventaire(int nOuvrier, int nRessource){
        setNbRessource(nRessource);
        setNbOuvrier(nOuvrier);
    }
}
