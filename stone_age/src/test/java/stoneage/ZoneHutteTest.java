package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneHutteTest {

    @Test
    void getNbOuvrierSurZone() {
    }

    @Test
    void setNbOuvrierSurZone() {
    }

    @Test
    void placeOuvrier() {
        ZoneRessource zr = new ZoneRessource();
        ZoneHutte zv = new ZoneHutte();
        Joueur j = new Joueur();
        j.placement(zr);
        j.placement(zv);

        Assert.assertEquals(1,zr.getNbOuvrierSurZone());
        Assert.assertEquals(1,zv.getNbOuvrierSurZone());
    }

    @Test
    void retirerOuvrier() {
        ZoneRessource zr = new ZoneRessource();
        ZoneHutte zv = new ZoneHutte();
        Joueur j = new Joueur();
        j.placement(zr);
        j.placement(zv);
        j.recupere(zr);
        j.recupere(zv);

        Assert.assertEquals(0,zr.getNbOuvrierSurZone());
        Assert.assertEquals(0,zv.getNbOuvrierSurZone());

    }

}