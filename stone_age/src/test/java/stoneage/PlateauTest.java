package stoneage;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void nbOuvrierDispoTotal() {
        Plateau plateau = new Plateau(2);

        assertEquals(10,plateau.nbOuvrierDispoTotal());
    }

    @Test
    void placementPhase() {
        Plateau plateau = new Plateau(2);

        plateau.placementPhase(false);

        assertTrue(plateau.getListeInventaire().get(0).getNbOuvrier()==0);
        assertTrue(plateau.nbOuvrierDispoTotal()==0);
    }

    @Test
    void recuperationPhase() {
        Plateau plateau = new Plateau(2);

        plateau.placementPhase(false);
        plateau.recuperationPhase(false);

        assertTrue(plateau.getListeInventaire().get(0).getNbOuvrier()>=5);

    }

    @Test
    void phaseNourrir() {
        Plateau plateau = new Plateau(2);

        plateau.phaseNourrir();

        assertEquals(7, plateau.getListeInventaire().get(0).getNbNourriture());
        assertEquals(7, plateau.getListeInventaire().get(1).getNbNourriture());

        plateau.getListeInventaire().get(0).setNbNourriture(0);
        plateau.phaseNourrir();

        assertEquals(-10, plateau.getListeInventaire().get(0).getNbPointTotal());

    }

    @Test
    void resetOutils() {
        Plateau plateau = new Plateau(2);
        for (int i = 0; i < 4; i++) {
            if (plateau.getListeInventaire().get(0).getOutilsDispo().size()<3) {
                plateau.getListeInventaire().get(0).getOutilsDispo().add(1);
            }
            else {
                plateau.getListeInventaire().get(0).getOutilsDispo().set(0,plateau.getListeInventaire().get(0).getOutilsDispo().get(0)+1);
            }
        }

        assertEquals(2, plateau.getListeInventaire().get(0).getOutilsDispo().get(0));
        assertEquals(3, plateau.getListeInventaire().get(0).getOutilsDispo().size());

        plateau.resetOutils(0);
        assertEquals(0, plateau.getListeInventaire().get(0).getOutilsDispo().size());



    }

    @Test
    void resetZone() {
        Plateau plateau = new Plateau(2);

        plateau.getZonesDispo().get(0).placeOuvrierSurZone(7,0);

        plateau.updateStatutZone();
        plateau.resetZone();

        assertEquals(0, plateau.getZonesPleines().size());
        assertEquals(5, plateau.getZonesDispo().size());
    }

    @Test
    void updateStatutZone() {
        Plateau plateau = new Plateau(2);

        plateau.getZonesDispo().get(0).placeOuvrierSurZone(7,0);

        plateau.updateStatutZone();

        assertEquals(1, plateau.getZonesPleines().size());
        assertEquals(4, plateau.getZonesDispo().size());
    }

    @Test
    void verifierDisponibiliteZone() {
        Plateau plateau = new Plateau(2);
        Zone zone = new Zone(Ressource.NOURRITURE, 12, 2, 0, Integer.MAX_VALUE);
        int choixOuvriers = 2;


        boolean result = plateau.verifierDisponibiliteZone(zone,choixOuvriers,0);

        assertEquals(true, result);

    }

    @Test
    void swap() {

        Plateau plateau = new Plateau(2);
        ArrayList<Integer> tab = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tab.add(i);
        }

        plateau.swap(tab);
        assertEquals(1,tab.get(0));
        assertEquals(2,tab.get(1));
        assertEquals(3,tab.get(2));
        assertEquals(4,tab.get(3));
        assertEquals(0,tab.get(4));
    }
}