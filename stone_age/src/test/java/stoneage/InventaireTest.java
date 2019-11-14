package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.*;

class InventaireTest {

    @Test
    void getNbOuvrier() {
    }

    @Test
    void setNbOuvrier() {
    }

    @Test
    void subOuvrier() {
        Inventaire i = new Inventaire();
        i.setNbOuvrier(0);
        i.subOuvrier(1);
        Assert.assertEquals(0, i.getNbOuvrier());
    }

    @Test
    void getNbRessource() {
    }

    @Test
    void setNbRessource() {
    }

    @Test
    void addRessource() {
        Inventaire i = new Inventaire();
        ZoneRessource z = new ZoneRessource();
        i.setNbRessource(1);
        i.addRessource(z);
        Assert.assertEquals(2, i.getNbRessource());
    }
}