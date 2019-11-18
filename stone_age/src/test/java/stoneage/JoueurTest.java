package stoneage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void getNbJoueur() {
    }

    @Test
    void getNum() {
    }

    @Test
    void placement() {
        ZoneChamp champ = new ZoneChamp();
        ZoneChasse chasse = new ZoneChasse();
        ZoneHutte hutte = new ZoneHutte();
        ZoneForet foret = new ZoneForet();

        Joueur j = new Joueur();

        j.placement(chasse,2);
        Assert.assertEquals(3, j.getInventaireJoueur().getNbOuvrier());
        //Assert.assertEquals(2, chasse.getNbOuvrierSurZone());

       /* j.placement(hutte,2);
        Assert.assertEquals(3, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(2, hutte.getNbOuvrierSurZone());

        j.placement(foret,6);
        Assert.assertEquals(0, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(5, foret.getNbOuvrierSurZone());

        j.placement(champ,1);
        Assert.assertEquals(3, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(2, champ.getNbOuvrierSurZone());*/

    }

    @Test
    void recupere() {
        ZoneInterface zoneR = new ZoneRessource();
        ZoneInterface zoneV = new ZoneVillage();
        Joueur j = new Joueur();
        j.placement(zoneR,3);
        j.placement(zoneV, 4);

        j.recupere(zoneR);
        j.recupere(zoneV);

        Assert.assertEquals(6, j.getInventaireJoueur().getNbOuvrier());
        Assert.assertEquals(0, zoneR.getNbOuvrierSurZone());
        Assert.assertEquals(0, zoneV.getNbOuvrierSurZone());

        Assert.assertEquals(1, j.getInventaireJoueur().getNbRessource());


    }

    @Test
    void nourrir() {

        Joueur j = new Joueur();
        j.nourrir(j.getInventaireJoueur());
        j.nourrir(j.getInventaireJoueur());
        j.nourrir(j.getInventaireJoueur());
        Assert.assertEquals(0,j.getInventaireJoueur().getNbNourriture());
    }

    @Test
    void dée() {
    }

}