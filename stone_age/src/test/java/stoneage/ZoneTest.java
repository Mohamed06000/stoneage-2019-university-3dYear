package stoneage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneTest {

    @Test
    void placeOuvrierSurZone() {
        int actual;
        int nbOuvrierInitial;
        int nbOuvrierAplacer = 5;

        Zone zone = new Zone(Ressource.OR,6,2,0,10);
        zone.placeOuvrierSurZone(nbOuvrierAplacer, 0);

        assertEquals(5, zone.getNbOuvirerDuJoueur(0));
        assertEquals(5,zone.getNbOuvrierSurZone());

        zone = new Zone(Ressource.OR,6,2,2,10);
        zone.placeOuvrierSurZone(nbOuvrierAplacer, 0);

        assertEquals(5, zone.getNbOuvirerDuJoueur(0));
        assertEquals(7,zone.getNbOuvrierSurZone());

        zone = new Zone(Ressource.OR,6,2,2,15);
        nbOuvrierInitial =  zone.getNbOuvrierSurZone();
        zone.placeOuvrierSurZone(nbOuvrierAplacer, 0);
        zone.placeOuvrierSurZone(nbOuvrierAplacer, 1);

        actual = zone.getNbOuvirerDuJoueur(0) + zone.getNbOuvirerDuJoueur(1) + nbOuvrierInitial;
        assertEquals(12, actual);
        assertEquals(5, zone.getNbOuvirerDuJoueur(1));
        assertEquals(5,zone.getNbOuvirerDuJoueur(0));


    }

    @Test
    void retirerOuvrierSurZone() {

    }

    @Test
    void de() {
    }

    @Test
    void gainZone() {
    }
}