package stoneage.joueur;

import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.zones.Zone;

import java.util.Random;

public class IA {


    Random rand = new Random();


    /**
     * Choisit le nombre d'ouvrier à placer
     * @param inventaire L'inventaire du joueur
     * @param choixZone La zone choisit
     * @return Un nombre d'ouvriers
     */
    public int choixNbOuvrier(Inventaire inventaire, Zone choixZone) {
        int alea=0;

        if (choixZone instanceof Zone) {
            alea = rand.nextInt(inventaire.getNbOuvrier()) + 1; //le +1 a l'exterieur de rand sinon ca peut retourner 0.
        }
        else {
            if (choixZone.getClass().getSimpleName().equals("Champ") | choixZone.getClass().getSimpleName().equals("Fabrique")){
                alea = 1;
            }
            if (choixZone.getClass().getSimpleName().equals("Hutte")) {
                alea = 2;
            }
        }

        return alea;
    }




}
