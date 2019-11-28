package stoneage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void nourrir() {
        Inventaire inventaire = new Inventaire();
        Joueur IA = new Joueur();

        IA.nourrir(inventaire);
        //inventaire.setNbOuvrier(-1);
        assertEquals(7, inventaire.getNbNourriture());

    }
}