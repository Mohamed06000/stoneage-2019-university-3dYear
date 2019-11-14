<<<<<<< HEAD
=======
<<<<<<< HEAD
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
        j.placement(j.getInventaireJoueur(),zr);
        j.placement(j.getInventaireJoueur(),zv);

        Assert.assertEquals(1,zr.getNbOuvrierSurZone());
        Assert.assertEquals(1,zv.getNbOuvrierSurZone());
    }

    @Test
    void retirerOuvrier() {
        ZoneRessource zr = new ZoneRessource();
        ZoneVillage zv = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(j.getInventaireJoueur(),zr);
        j.placement(j.getInventaireJoueur(),zv);
        j.recupere(j.getInventaireJoueur(),zr);
        j.recupere(j.getInventaireJoueur(),zv);

        Assert.assertEquals(0,zr.getNbOuvrierSurZone());
        Assert.assertEquals(0,zv.getNbOuvrierSurZone());

    }

    @Test
    void diminuerRessource() {
        ZoneRessource zr = new ZoneRessource();
        Joueur j = new Joueur();
        for (int i=0;i<11;i++){
            j.placement(j.getInventaireJoueur(),zr);
            j.recupere(j.getInventaireJoueur(),zr);
        }

        Assert.assertEquals(0,zr.getNbRessourceZone());
    }



=======
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
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
<<<<<<< HEAD
        ZoneVillage zv = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(j.getInventaireJoueur(),zr);
        j.placement(j.getInventaireJoueur(),zv);
=======
        ZoneHutte zv = new ZoneHutte();
        Joueur j = new Joueur();
<<<<<<< HEAD
        j.placement(zr);
        j.placement(zv);
=======
//        j.placement(j.getInventaireJoueur(),zr);
//        j.placement(j.getInventaireJoueur(),zv);
>>>>>>> origin/mazy
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71

        Assert.assertEquals(1,zr.getNbOuvrierSurZone());
        Assert.assertEquals(1,zv.getNbOuvrierSurZone());
    }

    @Test
    void retirerOuvrier() {
        ZoneRessource zr = new ZoneRessource();
<<<<<<< HEAD
        ZoneVillage zv = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(j.getInventaireJoueur(),zr);
        j.placement(j.getInventaireJoueur(),zv);
        j.recupere(j.getInventaireJoueur(),zr);
        j.recupere(j.getInventaireJoueur(),zv);
=======
        ZoneHutte zv = new ZoneHutte();
        Joueur j = new Joueur();
<<<<<<< HEAD
        j.placement(zr);
        j.placement(zv);
        j.recupere(zr);
        j.recupere(zv);
=======
//        j.placement(j.getInventaireJoueur(),zr);
//        j.placement(j.getInventaireJoueur(),zv);
//        j.recupere(j.getInventaireJoueur(),zr);
//        j.recupere(j.getInventaireJoueur(),zv);
>>>>>>> origin/mazy
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71

        Assert.assertEquals(0,zr.getNbOuvrierSurZone());
        Assert.assertEquals(0,zv.getNbOuvrierSurZone());

    }

    @Test
    void diminuerRessource() {
        ZoneRessource zr = new ZoneRessource();
        Joueur j = new Joueur();
        for (int i=0;i<11;i++){
<<<<<<< HEAD
            j.placement(j.getInventaireJoueur(),zr);
            j.recupere(j.getInventaireJoueur(),zr);
=======
<<<<<<< HEAD
            j.placement(zr);
            j.recupere(zr);
=======
//            j.placement(j.getInventaireJoueur(),zr);
//            j.recupere(j.getInventaireJoueur(),zr);
>>>>>>> origin/mazy
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
        }

        Assert.assertEquals(0,zr.getNbRessourceZone());
    }



<<<<<<< HEAD
=======
>>>>>>> Baroudi
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
}