package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneForetTest {

    @Test
    void getNbOuvrierSurZone() {
    }

    @Test
    void getNbOuvrierDuJoueurI() {
    }

    @Test
    void setNbOuvrierSurZone() {
    }

    @Test
    void placeOuvrier() {
        Joueur j = new Joueur();
        ZoneForet foret = new ZoneForet();

        foret.placeOuvrier(1, j.getNum());

        Assert.assertEquals(1, foret.getNbOuvrierSurZone());
        Assert.assertEquals(1, foret.getNbOuvrierDuJoueurI(j.getNum()));
    }

    @Test
    void retirerOuvrier() {
        Joueur j = new Joueur();
        ZoneForet foret = new ZoneForet();

        foret.placeOuvrier(1, j.getNum());
        foret.retirerOuvrier(1, j.getNum());

        Assert.assertEquals(0, foret.getNbOuvrierSurZone());
        Assert.assertEquals(0, foret.getNbOuvrierDuJoueurI(j.getNum()));
    }

    @Test
    void verifeZonePlein() {
        Joueur j = new Joueur();
        ZoneForet foret = new ZoneForet();

        foret.placeOuvrier(7, j.getNum());

        Assert.assertEquals(true, ZoneForet.verifeZonePlein());
    }

    @Test
    void addnbRessourceBois() {
        Joueur j = new Joueur();
        ZoneForet foret = new ZoneForet();

        foret.placeOuvrier(5, j.getNum());
        int r = foret.addnbRessourceBois(j);
        Assert.assertEquals(foret.somme/3, r);
    }

    @Test
    void gainZone() {
        Joueur j = new Joueur();
        ZoneForet foret = new ZoneForet();

        foret.placeOuvrier(5, j.getNum());
        foret.gainZone(j);
        Assert.assertEquals(foret.somme/3, j.getInventaireJoueur().getNbRessourceBois());
    }
}