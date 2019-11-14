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
        ZoneRessource zr = new ZoneRessource();
        ZoneVillage zv = new ZoneVillage();
        Joueur j = new Joueur();
<<<<<<< HEAD
        j.placement(j.getInventaireJoueur(),zr);
        j.placement(j.getInventaireJoueur(),zv);
=======
//        j.placement(j.getInventaireJoueur(),zr);
//        j.placement(j.getInventaireJoueur(),zv);
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71

        Assert.assertEquals(1,zr.getNbOuvrierSurZone());
        Assert.assertEquals(1,zv.getNbOuvrierSurZone());
    }

    @Test
    void retirerOuvrier() {
        ZoneRessource zr = new ZoneRessource();
        ZoneVillage zv = new ZoneVillage();
        Joueur j = new Joueur();
<<<<<<< HEAD
        j.placement(j.getInventaireJoueur(),zr);
        j.placement(j.getInventaireJoueur(),zv);
        j.recupere(j.getInventaireJoueur(),zr);
        j.recupere(j.getInventaireJoueur(),zv);
=======
//        j.placement(j.getInventaireJoueur(),zr);
//        j.placement(j.getInventaireJoueur(),zv);
//        j.recupere(j.getInventaireJoueur(),zr);
//        j.recupere(j.getInventaireJoueur(),zv);
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71

        Assert.assertEquals(0,zr.getNbOuvrierSurZone());
        Assert.assertEquals(0,zv.getNbOuvrierSurZone());

    }

}