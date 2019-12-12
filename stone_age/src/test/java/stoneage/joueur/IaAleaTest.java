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
    Zone z3 = new Zone(Ressource.OR,10,6,0,7);



    @Test
    void choixNbOuvrier() {
        int res = ia.choixNbOuvrier(inventaire ,z);
        assertEquals(1,res);

        int res1 = ia.choixNbOuvrier(inventaire,z1);
        assertEquals(2,res1);

        int res2 = ia.choixNbOuvrier(inventaire,z1);
        assertEquals(2,res2);

        int res3 = ia.choixNbOuvrier((inventaire),z3);
        assertTrue(res3>0);

    }
}
