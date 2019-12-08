
package stoneage.joueur;

import stoneage.plateaudejeu.cartes.Cartebatiment;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.zones.Zone;

import java.util.* ;


/**
 * La classe qui représente les informations et actions du joueur
 */
public class Joueur {


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
    public Joueur(){
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
                    break;
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

}

