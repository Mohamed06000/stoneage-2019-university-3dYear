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
        ZoneHutte zv = new ZoneHutte();
        Joueur j = new Joueur();
<<<<<<< HEAD
        j.placement(zr);
        j.placement(zv);
=======
//        j.placement(j.getInventaireJoueur(),zr);
//        j.placement(j.getInventaireJoueur(),zv);
>>>>>>> origin/mazy

        Assert.assertEquals(1,zr.getNbOuvrierSurZone());
        Assert.assertEquals(1,zv.getNbOuvrierSurZone());
    }

    @Test
    void retirerOuvrier() {
        ZoneRessource zr = new ZoneRessource();
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

        Assert.assertEquals(0,zr.getNbOuvrierSurZone());
        Assert.assertEquals(0,zv.getNbOuvrierSurZone());

    }

    @Test
    void diminuerRessource() {
        ZoneRessource zr = new ZoneRessource();
        Joueur j = new Joueur();
        for (int i=0;i<11;i++){
<<<<<<< HEAD
            j.placement(zr);
            j.recupere(zr);
=======
//            j.placement(j.getInventaireJoueur(),zr);
//            j.recupere(j.getInventaireJoueur(),zr);
>>>>>>> origin/mazy
        }

        Assert.assertEquals(0,zr.getNbRessourceZone());
    }



>>>>>>> Baroudi
}