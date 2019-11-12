package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void getNbJoueur() {
    }

    @Test
    void getNum() {
    }

    @Test
    void placement() {
        ZoneInterface zoneR = new ZoneRessource();
        ZoneInterface zoneV = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(zoneR);

        Assert.assertEquals(4, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(1, zoneR.getNbOuvrierSurZone());

        j.placement(zoneR);

        Assert.assertEquals(3, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(2, zoneR.getNbOuvrierSurZone());



    }

    @Test
    void recupere() {
        ZoneInterface zoneR = new ZoneRessource();
        ZoneInterface zoneV = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(zoneR);
        j.placement(zoneV);

        j.recupere(zoneR);
        j.recupere(zoneV);

        Assert.assertEquals(6, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(0, zoneR.getNbOuvrierSurZone());
        Assert.assertEquals(0, zoneV.getNbOuvrierSurZone());

        Assert.assertEquals(1, j.getInventaireJoueur().getNbRessource());


    }

    @Test
    void nourrir() {

        Joueur j = new Joueur();
        j.nourrir(j.getInventaireJoueur());
        j.nourrir(j.getInventaireJoueur());
        j.nourrir(j.getInventaireJoueur());
        Assert.assertEquals(0,j.getInventaireJoueur().getNbNourriture());
    }

    @Test
    void action() {
    }

    @Test
    void dée() {
    }
}