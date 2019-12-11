package stoneage.joueur;

import org.junit.jupiter.api.Test;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;
import stoneage.plateaudejeu.zones.Zone;
import stoneage.plateaudejeu.zones.ZoneVillage;

import static org.junit.jupiter.api.Assertions.*;

class IaAleaTest {
    Inventaire inventaire = new Inventaire();
    ZoneVillage z = new ZoneVillage(0,1,0);
    IaAlea ia = new IaAlea();
    ZoneVillage z1 = new ZoneVillage(0,2,2);
    ZoneVillage z2 = new ZoneVillage(0,2,1);



    @Test
    void choixNbOuvrier() {
        int res = ia.choixNbOuvrier(inventaire ,z);
        assertEquals(1,res);

        int res1 = ia.choixNbOuvrier(inventaire,z1);
        assertEquals(2,res1);

        int res2 = ia.choixNbOuvrier(inventaire,z1);
        assertEquals(2,res2);

    }

    @Test
    void choixCarteOuZone() {
    }

    @Test
    void choixCartePlacement() {
    }

    @Test
    void choixCarteRecuperation() {
    }

    @Test
    void choixZone() {
    }

    @Test
    void choixOutils() {
    }

    @Test
    void choixNbRessource() {
    }

    @Test
    void choixNbOutils() {
    }
}