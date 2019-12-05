package stoneage;

import org.junit.jupiter.api.Test;
import stoneage.joueur.Joueur;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;
import stoneage.plateaudejeu.zones.Zone;

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

        Inventaire i =new Inventaire();
        Zone zone = new Zone(Ressource.OR,6,2,0,10);
        zone.placeOuvrierSurZone(3, 0);
        zone.retirerOuvrierSurZone(i,3,0);
        assertEquals(0,zone.getNbOuvirerDuJoueur(0));


        zone = new Zone(Ressource.OR,6,2,3,10);
        zone.placeOuvrierSurZone(4, 0);
        zone.retirerOuvrierSurZone(i,4,0);
        assertEquals(0,zone.getNbOuvirerDuJoueur(0));
        assertEquals(3, zone.getNbOuvrierSurZone());



        zone = new Zone(Ressource.OR,6,2,5,10);
        zone.placeOuvrierSurZone(6, 0);
        zone.retirerOuvrierSurZone(i,6,0);
        assertEquals(0,zone.getNbOuvirerDuJoueur(0));

    }




    @Test
    void gainZone() {

        Zone zone = new Zone(Ressource.OR,6,2,0,10);
        zone.placeOuvrierSurZone(6, 0);
        Inventaire i =new Inventaire();
        Joueur IA = new Joueur();
        zone.gainZone(i,0, IA);

        zone = new Zone(Ressource.PIERRE,6,2,0,10);
        zone.placeOuvrierSurZone(6, 0);
        zone.gainZone(i,0, IA);
        assertTrue(i.getNbOr()>0);
        assertTrue(i.getNbPierre()>0);


        zone = new Zone(Ressource.ARGILE,6,2,0,10);
        zone.placeOuvrierSurZone(6, 0);
        zone.gainZone(i,0, IA);
        assertTrue(i.getNbOr()>0);
        assertTrue(i.getNbPierre()>0);
        assertTrue(i.getNbArgile()>0);


        zone = new Zone(Ressource.BOIS,6,2,0,10);
        zone.placeOuvrierSurZone(6, 0);
        zone.gainZone(i,0,IA);
        assertTrue(i.getNbOr()>0);
        assertTrue(i.getNbPierre()>0);
        assertTrue(i.getNbArgile()>0);
        assertTrue(i.getNbBois()>0);

    }
}