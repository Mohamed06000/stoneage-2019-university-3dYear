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
        ZoneRessource zr = new ZoneRessource();
        ZoneVillage zv = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(zr);
        j.placement(zv);

        Assert.assertEquals(1,zr.getNbOuvrierSurZone());
        Assert.assertEquals(1,zv.getNbOuvrierSurZone());
    }

    @Test
    void retirerOuvrier() {
        ZoneRessource zr = new ZoneRessource();
        ZoneVillage zv = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(zr);
        j.placement(zv);
        j.recupere(zr);
        j.recupere(zv);

        Assert.assertEquals(0,zr.getNbOuvrierSurZone());
        Assert.assertEquals(0,zv.getNbOuvrierSurZone());

    }

    @Test
    void diminuerRessource() {
        ZoneRessource zr = new ZoneRessource();
        Joueur j = new Joueur();
        for (int i=0;i<11;i++){
            j.placement(zr);
            j.recupere(zr);
        }

        Assert.assertEquals(0,zr.getNbRessourceZone());
    }



}