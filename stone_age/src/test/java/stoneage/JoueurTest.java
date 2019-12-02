package stoneage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void nourrir() {
        Inventaire inventaire = new Inventaire();
        Joueur IA = new Joueur();

//        IA.nourrir(inventaire);
//        inventaire.setNbOuvrier(-1);
//        assertEquals(7, inventaire.getNbNourriture());

        inventaire.setNbNourriture(4);
//        inventaire.setNbBois(1);
        IA.nourrir(inventaire);
        assertEquals(-10, inventaire.getNbPointTotal());

    }
}