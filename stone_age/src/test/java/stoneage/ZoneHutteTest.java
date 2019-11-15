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

        Joueur j = new Joueur();
        ZoneHutte hutte = new ZoneHutte();

        hutte.placeOuvrier(2, j.getNum());

        Assert.assertEquals(2, hutte.getNbOuvrierSurZone());
        Assert.assertEquals(2, hutte.getNbOuvrierDuJoueurI(j.getNum()));

    }

    @Test
    void retirerOuvrier() {

        Joueur j = new Joueur();
        ZoneHutte hutte = new ZoneHutte();

        hutte.placeOuvrier(2, j.getNum());
        hutte.retirerOuvrier(2, j.getNum());

        Assert.assertEquals(0, hutte.getNbOuvrierSurZone());
        Assert.assertEquals(0, hutte.getNbOuvrierDuJoueurI(j.getNum()));

    }


}