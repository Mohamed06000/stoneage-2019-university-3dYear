package stoneage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneVillageTest {

    @Test
    void gainZone() {
        ZoneVillage hutte = new ZoneVillage(0,1,2);
        Inventaire inventaire = new Inventaire();
        Joueur IA = new Joueur();
        for (int i = 0; i < 6; i++) {
            hutte.gainZone(inventaire,0,IA);
        }
        assertEquals(10, inventaire.getNbOuvrierTotal());
    }
}