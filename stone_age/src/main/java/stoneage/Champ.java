package stoneage ;

/**
 * Classe qui represente la Zone Champ qui permet de multiplier la quantiteé de nourriture gagné par un MultiplicateurNourriture
 */
public class Champ extends ZoneVillage implements ZoneInterface {
    public Champ(){
        super();
    }

    /**
     * methode gainZone qui incremente de 1 le NiveauAgriculture pour le Joueur j ayant mis un ouvrier sur champ
     * @param j
     */
    public void gainZone(Joueur j){
        j.getInventaireJoueur().addNiveauAgriculture();
    }
}
