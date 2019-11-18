package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneVillageTest {

    @Test
    void getNbOuvrierSurZone() {
    }

    @Test
    void setNbOuvrierSurZone() {
    }

    @Test
    void placeOuvrier() {
        Joueur j = new Joueur();
        ZoneVillage zv = new ZoneVillage();
        j.placement(zv,5);

        Assert.assertEquals(5,zv.getNbOuvrierSurZone());
    }

    @Test
    void retirerOuvrier() {
        Joueur j = new Joueur();
        ZoneVillage zv = new ZoneVillage();

        j.placement(zv,3);
        j.recupere(zv);

        Assert.assertEquals(0,zv.getNbOuvrierSurZone());

    }

}