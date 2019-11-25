
package stoneage;


import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Classe du lancement du  jeu
 */
public class Main {
    public static final void main(String[] args) {
        Partie partie = new Partie(4);
        partie.jouer();
    }
}
