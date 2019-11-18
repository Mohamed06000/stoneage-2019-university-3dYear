package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneChampTest {

    @Test
    void verifeZonePlein() {
        Joueur j = new Joueur();
        ZoneChamp champ = new ZoneChamp();

        champ.placeOuvrier(1, j.getNum());

        Assert.assertEquals(true, ZoneChamp.verifeZonePlein());

    }

    @Test
    void placeOuvrier() {
        Joueur j = new Joueur();
        ZoneChamp champ = new ZoneChamp();

        champ.placeOuvrier(1, j.getNum());

        Assert.assertEquals(1, champ.getNbOuvrierSurZone());
        Assert.assertEquals(1, champ.getNbOuvrierDuJoueurI(j.getNum()));
    }

    @Test
    void retirerOuvrier() {
        Joueur j = new Joueur();
        ZoneChamp champ = new ZoneChamp();

        champ.placeOuvrier(1, j.getNum());
        champ.retirerOuvrier(1, j.getNum());

        Assert.assertEquals(0, champ.getNbOuvrierSurZone());
        Assert.assertEquals(0, champ.getNbOuvrierDuJoueurI(j.getNum()));
    }

    @Test
    void getNbOuvrierSurZone() {
    }

    @Test
    void getNbOuvrierDuJoueurI() {
    }

    @Test
    void gainZone() {
        Joueur j = new Joueur();
        ZoneChamp champ = new ZoneChamp();

        champ.placeOuvrier(1, j.getNum());
        champ.gainZone(j);
        Assert.assertEquals(1, j.getInventaireJoueur().getNiveauAgriculture());
    }
}