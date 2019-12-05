package stoneage;

import org.junit.jupiter.api.Test;
import stoneage.plateaudejeu.Plateau;


import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void nbOuvrierDispoTotal() {
        Plateau plateau = new Plateau(2);
        assertEquals(10,plateau.nbOuvrierDispoTotal(plateau.getListeInventaire()));
    }


}