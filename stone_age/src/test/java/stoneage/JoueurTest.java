<<<<<<< HEAD
=======
<<<<<<< HEAD
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
        j.placement(j.getInventaireJoueur(), zoneR);

        Assert.assertEquals(4, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(1, zoneR.getNbOuvrierSurZone());

        j.placement(j.getInventaireJoueur(), zoneR);

        Assert.assertEquals(3, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(2, zoneR.getNbOuvrierSurZone());



    }

    @Test
    void recupere() {
        ZoneInterface zoneR = new ZoneRessource();
        ZoneInterface zoneV = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(j.getInventaireJoueur(), zoneR);
        j.placement(j.getInventaireJoueur(), zoneV);

        j.recupere(j.getInventaireJoueur(), zoneR);
        j.recupere(j.getInventaireJoueur(), zoneV);

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
=======
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
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
<<<<<<< HEAD
        ZoneInterface zoneV = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(j.getInventaireJoueur(), zoneR);
=======
        ZoneInterface zoneV = new ZoneHutte();
        Joueur j = new Joueur();
<<<<<<< HEAD
        j.placement(zoneR);
=======
//        j.placement(j.getInventaireJoueur(), zoneR);
>>>>>>> origin/mazy
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71

        Assert.assertEquals(4, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(1, zoneR.getNbOuvrierSurZone());

<<<<<<< HEAD
        j.placement(j.getInventaireJoueur(), zoneR);
=======
<<<<<<< HEAD
        j.placement(zoneR);
=======
//        j.placement(j.getInventaireJoueur(), zoneR);
>>>>>>> origin/mazy
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71

        Assert.assertEquals(3, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(2, zoneR.getNbOuvrierSurZone());



    }

    @Test
    void recupere() {
        ZoneInterface zoneR = new ZoneRessource();
<<<<<<< HEAD
        ZoneInterface zoneV = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(j.getInventaireJoueur(), zoneR);
        j.placement(j.getInventaireJoueur(), zoneV);

        j.recupere(j.getInventaireJoueur(), zoneR);
        j.recupere(j.getInventaireJoueur(), zoneV);
=======
        ZoneInterface zoneV = new ZoneHutte();
        Joueur j = new Joueur();
<<<<<<< HEAD
        j.placement(zoneR);
        j.placement(zoneV);

        j.recupere(zoneR);
        j.recupere(zoneV);
=======
//        j.placement(j.getInventaireJoueur(), zoneR);
//        j.placement(j.getInventaireJoueur(), zoneV);

//        j.recupere(j.getInventaireJoueur(), zoneR);
//        j.recupere(j.getInventaireJoueur(), zoneV);
>>>>>>> origin/mazy
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71

        Assert.assertEquals(6, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(0, zoneR.getNbOuvrierSurZone());
        Assert.assertEquals(0, zoneV.getNbOuvrierSurZone());

        Assert.assertEquals(1, j.getInventaireJoueur().getNbRessource());


    }

    @Test
    void nourrir() {

        Joueur j = new Joueur();
<<<<<<< HEAD
        j.nourrir(j.getInventaireJoueur());
        j.nourrir(j.getInventaireJoueur());
        j.nourrir(j.getInventaireJoueur());
=======
//        j.nourrir(j.getInventaireJoueur());
//        j.nourrir(j.getInventaireJoueur());
//        j.nourrir(j.getInventaireJoueur());
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
        Assert.assertEquals(0,j.getInventaireJoueur().getNbNourriture());
    }

    @Test
    void action() {
    }

    @Test
    void dée() {
    }
<<<<<<< HEAD
=======
>>>>>>> Baroudi
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
}