package stoneage;

import org.jetbrains.annotations.NotNull;
import java.util.Random;


import java.util.ArrayList;

public class CarteCivilisation {
	
    static Random rand = new Random();


	public enum Couleur {
		VERTE, JAUNE;
	}
	
	

	

	private Ressource ressourceCarte;
	private int nbRessourceCarte;
	private Couleur couleur;
	private boolean PlaceReserver = false;

	CarteCivilisation(int nbRessourceCarte, Couleur couleur, Ressource ressourceCarte) {
		this.nbRessourceCarte = nbRessourceCarte;
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver=false;
	}

	//setter
	public void setNbRessourceCarte(int nbRessourceCarte) {
		this.nbRessourceCarte = nbRessourceCarte;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void setPlaceReservee(boolean placeReservee) {
		this.PlaceReserver = placeReservee;
	}

	public void setressourceCarte(Ressource ressourceCarte) {
		this.ressourceCarte = ressourceCarte;
	}

	//getter

	public int getNbRessourceCarte() {
		return this.nbRessourceCarte;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public Ressource getressourceCarte() {
		return this.ressourceCarte;
	}
	public boolean isPlaceReservee() {
		return this.PlaceReserver;
	}

	//methode de classe :

	/**
	 *
	 * @param inventaireJoueur
	 * @param nbOuvrierAplacer
	 */
	public void placeOuvrierSurCarte(Inventaire inventaireJoueur, int nbOuvrierAplacer) {
		if (nbOuvrierAplacer == 1) {
			inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() - 1);
			setPlaceReservee(true);
		} 

	}


	/**
	 *
	 * @param inventaireJoueur
	 */
	public void retirerOuvrierSurCarte(@NotNull Inventaire inventaireJoueur) {
		inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
		this.PlaceReserver = false;

	}

	public String toString() {

		return " ressourceCarte " + this.ressourceCarte + " couleur " + this.couleur + "nbressource " + this.nbRessourceCarte;
	}


	/**
	 * méthode qui permet au Joueur  de payer la carte si celui ci posséde les ressources suffisantes .
	 * @param inventaireJoueur
	 */
	public boolean payement(Inventaire inventaireJoueur, int positionCards) {
		int somme = inventaireJoueur.getNbRessourceTotal();
		int prix = positionCards + 1; // le tableau commence de 0 donc le prix est tjrs egale position de la carte + 1
		int[] tab = new int[4];
		tab[0] = inventaireJoueur.getNbBois();
		tab[1] = inventaireJoueur.getNbArgile();
		tab[2] = inventaireJoueur.getNbPierre();
		tab[3] = inventaireJoueur.getNbOr();

		

		if (somme<prix) {
			return false;
		}

		if (somme == prix) {
			for (int i = 0; i<tab.length; i++) {
				tab[i] = 0;
			}

			inventaireJoueur.setNbBois(tab[0]);
			inventaireJoueur.setNbArgile(tab[1]);
			inventaireJoueur.setNbPierre(tab[2]);
			inventaireJoueur.setNbOr(tab[3]);
			return true;
		}

		if (somme > prix) {
			int i = 0;
			int difference = somme - prix;

			while (somme > difference) {
				if (tab[i] > 0) {
					tab[i] -= 1;
					somme -= 1;

				} else {
					i = i + 1;

				}

			}

			inventaireJoueur.setNbBois(tab[0]);
			inventaireJoueur.setNbArgile(tab[1]);
			inventaireJoueur.setNbPierre(tab[2]);
			inventaireJoueur.setNbOr(tab[3]);
			return true;
		}
		return true;

	}

	public void recupererCarte(Inventaire i, int positionCards) {

		if (payement(i, positionCards) == true)

		{
			retirerOuvrierSurCarte(i);
			i.stockCards.add(this);
			
			gainCarte(i);
			
			
			
			Plateau.cards.remove(positionCards);

		} else {

			retirerOuvrierSurCarte(i);

		}
	}
	
	
	private void gainCarte(Inventaire i ) {

		Ressource r = this.getressourceCarte();
		
		switch(r) {
		  case OR:
			  
			  i.setNbOr(this.nbRessourceCarte);
			  
		    break;
		  case NOURRITURE:
			  i.setNbNourriture(this.nbRessourceCarte);
			  break;
		  case ARGILE:
			  i.setNbArgile(this.nbRessourceCarte);
			  break;
		  case BOIS:
			  i.setNbBois(this.nbRessourceCarte);
			  break;
		  case PIERRE:
			  i.setNbPierre(this.nbRessourceCarte);
		    break;
		    // code block
			  
			  /*  OR,
			    NOURRITURE,
			    BOIS,
			    ARGILE,
			    PIERRE,
			    POINT,
			    OUTIL,
			    AGRICULTURE;
			    */
		}
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args)
	{
		CarteCivilisation.de();
		
		
	}
	
	public static void de()
	{	
		
		int nbJoueur = Partie.getNbJoueur();
		int resultat =0 ; 
		
		for (int i=0;i<nbJoueur;i++)
		{
			resultat+=rand.nextInt(6)+1;
		}
		
		
		
		
        
        
        
        
        
        
        
        
        
        
        
        
		
	}

	public static ArrayList<CarteCivilisation> CreationCarte() {

		ArrayList<CarteCivilisation> cards = new ArrayList<CarteCivilisation> ();
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(5, Couleur.VERTE, Ressource.PIERRE));
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(2, Couleur.VERTE, Ressource.PIERRE));
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.ARGILE));
		cards.add(new CarteCivilisation(4, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(7, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(2, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.OR));
		cards.add(new CarteCivilisation(5, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.PIERRE));
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.POINT));
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.POINT));
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.POINT));
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.OUTIL));
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.AGRICULTURE));
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.AGRICULTURE));
		
		
		

		return cards;
	}
}