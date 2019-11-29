
package stoneage;

import java.util.* ;


/**
 * La classe qui représente les informations et actions du joueur
 */
class Joueur {


    //CHAMPS

    /**
     * Le numero du joueur
     */
    private int num = 0;

    /**
     * Le nombre de joueur de type Joueur
     */
    private static int nbJoueur;

    /**
     * Objet de type Random
     */
    Random rand = new Random();


    //CONSTRUCTEUR

    /**
     * Constructeur de la classe
     */
    Joueur(){
        nbJoueur ++;
        num = nbJoueur;
    }


    //METHODES

    /**
     * Recupere le numero du joueur
     * @return Le numero du joueur
     */
    public int getNum(){
        return num;
    }

    /**
     * Nourrir ses ouvriers (1 nourriture/ouvrier)
     * @param i L'inventaire du joueur
     */
    public void nourrir(Inventaire i) {
        i.setNbNourriture(i.getNbNourriture()+i.getNiveauAgriculture());
        for (int j = 0; j < i.getNbOuvrier(); j++) {
            if (i.getNbNourriture()==0) { //Si le joueur doit nourrir encore des ouvriers mais n'a plus de nourriture
                boolean choixChange = rand.nextBoolean(); // Aleatoirement il choisit ou non d'echanger des ressources pour nourrir ses ouvriers
                if (choixChange && i.getNbRessourceTotal()>0) { //Si il choisit d'echanger et qu'il a de quoi echanger
                    for (int k = 0; k < i.getNbOuvrier()-j ; k++) { // On boucle sur le nombre d'ouvriers pas nourrir
                        if (i.getNbBois()>0) { //On commencer par changer avec la ressource la moins prestigieuse
                            i.setNbBois(i.getNbBois()-1);
                            continue;
                        }
                        else if (i.getNbArgile()>0) {
                            i.setNbArgile(i.getNbArgile()-1);
                            continue;
                        }
                        else if (i.getNbPierre()>0) {
                            i.setNbPierre(i.getNbPierre()-1);
                            continue;
                        }
                        else if (i.getNbOr()>0) {
                            i.setNbOr(i.getNbOr()-1);
                            continue;
                        }
                    }
                }
                else { // S'il choisit de pas changer
                    i.setNbPointTotal(i.getNbPointTotal()-10);
                }
            }
            if(i.getNbNourriture()>0)
                i.setNbNourriture(i.getNbNourriture()-1);

        }
    }

    /**
     * Lancer un de
     * @return Valeur du de
     */
    public int de(){
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
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
     * Choisit le nombre d'ouvrier à placer
     * @param inventaire L'inventaire du joueur
     * @param choixZone La zone choisit
     * @return Un nombre d'ouvriers
     */
    public int choixNbOuvrier(Inventaire inventaire, Zone choixZone) {
        int alea;
        alea = rand.nextInt(inventaire.getNbOuvrier()) + 1; //le +1 a l'exterieur de rand sinon ca peut retourner 0.
        return alea;
    }

    public boolean choixOutils() {
        return rand.nextBoolean();
    }

    public int choixNbOutils(Inventaire inventaire) {
        int sommeOutils =0;
        int nbOutilsUtilisé = rand.nextInt(inventaire.getOutilsDispo().size())+1;

        for (int i = 0; i < nbOutilsUtilisé ; i++) {
            int indice = rand.nextInt(inventaire.getOutilsDispo().size());
            sommeOutils += inventaire.getOutilsDispo().get(indice);
            inventaire.getOutilsNonDispo().set(indice,inventaire.getOutilsDispo().get(indice));
            inventaire.getOutilsDispo().remove(indice);
        }

        return sommeOutils;
    }

}

