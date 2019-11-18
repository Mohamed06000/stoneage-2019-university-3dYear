
package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneRessourceTest {

    @Test
    void getNbOuvrierSurZone() {
    }

    @Test
    void getNbRessourceZone() {
    }

    @Test
    void setNbOuvrierSurZone() {
    }

    @Test
    void placeOuvrier() {
        Joueur j = new Joueur();
        ZoneRessource zr = new ZoneRessource();
        j.placement(zr,5);

        Assert.assertEquals(5,zr.getNbOuvrierSurZone());
    }

    @Test
    void retirerOuvrier() {
        Joueur j = new Joueur();
        ZoneRessource zr = new ZoneRessource();
        ZoneVillage zv = new ZoneVillage();

        j.placement(zr,2);
        j.placement(zv,3);
        j.recupere(zr);
        j.recupere(zv);

        Assert.assertEquals(0,zr.getNbOuvrierSurZone());
        Assert.assertEquals(0,zv.getNbOuvrierSurZone());

    }

    @Test
    void diminuerRessource() {
        Joueur j = new Joueur();
        ZoneRessource zr = new ZoneRessource();
        for (int i=0;i<12;i++){
            j.placement(zr,3);
            j.recupere(zr);
        }

        Assert.assertEquals(0,zr.getNbRessourceZone());
    }

}