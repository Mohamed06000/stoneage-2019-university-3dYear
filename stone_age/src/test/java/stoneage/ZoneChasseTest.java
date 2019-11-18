package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneChasseTest {

    @Test
    void getNbRessourceZone() {
    }

    @Test
    void getNbOuvrierSurZone() {
    }

    @Test
    void getNbOuvrierDuJoueurI() {
    }

    @Test
    void diminuerRessource() {
        Joueur j = new Joueur();
        ZoneChasse chasse = new ZoneChasse();

        chasse.placeOuvrier(3, j.getNum());
        chasse.gainZone(j);
        chasse.diminuerRessource();

        Assert.assertEquals(12-(chasse.resultat_De), chasse.getNbRessourceZone());
    }

    @Test
    void placeOuvrier() {

        Joueur j = new Joueur();
        ZoneChasse chasse = new ZoneChasse();

        chasse.placeOuvrier(3, j.getNum());
        Assert.assertEquals(3, chasse.getNbOuvrierSurZone());
        Assert.assertEquals(3, chasse.getNbOuvrierDuJoueurI(j.getNum()));
    }

    @Test
    void retirerOuvrier() {

        Joueur j = new Joueur();
        ZoneChasse chasse = new ZoneChasse();

        chasse.placeOuvrier(3, j.getNum());
        chasse.placeOuvrier(3, j.getNum());
        chasse.retirerOuvrier(3, j.getNum());

        Assert.assertEquals(3, chasse.getNbOuvrierSurZone());
        Assert.assertEquals(3, chasse.getNbOuvrierDuJoueurI(j.getNum()));
    }

    @Test
    void gainZone() {
        Joueur j = new Joueur();
        ZoneChasse chasse = new ZoneChasse();

        chasse.placeOuvrier(3, j.getNum());
        chasse.gainZone(j);
        Assert.assertEquals(10+chasse.resultat_De, j.getInventaireJoueur().getNbNourriture());

    }
}