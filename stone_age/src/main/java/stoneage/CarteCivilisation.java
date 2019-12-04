package stoneage;

import org.jetbrains.annotations.NotNull;
import java.util.Random;

import java.util.ArrayList;

public class CarteCivilisation {

	static Random rand = new Random();

	public enum Couleur {
		VERTE, SABLE;
	}

	/*public static void main(String[] args) {
		CarteCivilisation carte1 = new CarteCivilisation(5, Couleur.VERTE, Ressource.BOIS);
		Inventaire i = new Inventaire();

		carte1.ressource_au_choix(i);
	}
	 */

	private Ressource ressourceCarte;
	private int nbRessourceCarte;
	private Couleur couleur;
	private boolean PlaceReserver = false;
	private boolean avec_jet_de = false;

	CarteCivilisation(int nbRessourceCarte, Couleur couleur, Ressource ressourceCarte) {
		this.nbRessourceCarte = nbRessourceCarte;
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver = false;
	}
	CarteCivilisation(Couleur couleur, Ressource ressourceCarte, boolean jetDe) {
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver = false;
		this.avec_jet_de = jetDe;
	}
	CarteCivilisation(Couleur couleur, Ressource ressourceCarte) {
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver = false;
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
	public void placeOuvrierSurCarte(Inventaire inventaireJoueur) {

		inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() - 1);
		setPlaceReservee(true);

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

	public void recupererCarte(Inventaire i, int positionCards, Plateau p) {

		if (payement(i, positionCards) == true)

		{
			retirerOuvrierSurCarte(i);
			i.stockCards.add(this);

			gainCarte(i, p);

			Plateau.cards.remove(positionCards);

		} else {

			retirerOuvrierSurCarte(i);

		}
	}

	private void gainCarte(Inventaire i, Plateau p) {

		Ressource r = this.getressourceCarte();

		switch (r) {
			case OR:
				if (this.avec_jet_de) {
					this.ressource_avec_jet_de(i, r);
				} else {
					i.setNbOr(this.nbRessourceCarte);
				}
				break;
			case NOURRITURE:
				i.setNbNourriture(this.nbRessourceCarte);
				break;
			case ARGILE:
				i.setNbArgile(this.nbRessourceCarte);
				break;
			case BOIS:
				if (this.avec_jet_de) {
					this.ressource_avec_jet_de(i, r);
				} else {
					i.setNbBois(this.nbRessourceCarte);
				}

				break;
			case PIERRE:
				if (this.avec_jet_de) {
					this.ressource_avec_jet_de(i, r);
				} else {
					i.setNbPierre(this.nbRessourceCarte);

				}
				break;
			case POINT:
				i.setNbPointTotal(this.nbRessourceCarte);
				break;
			case OUTIL:
				i.setNbOutils(this.nbRessourceCarte);
				break;
			case MULTI:

				this.multiRessource(i, p);

				break;
			case AGRICULTURE:
				i.setNiveauAgriculture(this.nbRessourceCarte);
				break;
			case RESSOURCE_AU_CHOIX:
				
				this.ressource_au_choix(i);
				break;
			/*case OUTIL_USAGE_UNIQUE:

				i.outilUsageUnique.add(this);
				break;
				*/
			case AUCUNE:

				break;

		}

	}

	private void multiRessource(Inventaire i, Plateau p) {
		ArrayList<Inventaire> listeInventaire = p.getListeInventaire();

		int size = listeInventaire.size();

		int indexOfInventaire = listeInventaire.indexOf(i);

		for (int k = 0; k<size; k++) {

			int a = rand.nextInt(6) + 1;

			int[] tab = new int[6];
			tab[0] = listeInventaire.get(indexOfInventaire).getNbBois();
			tab[1] = listeInventaire.get(indexOfInventaire).getNbArgile();
			tab[2] = listeInventaire.get(indexOfInventaire).getNbPierre();
			tab[3] = listeInventaire.get(indexOfInventaire).getNbOr();
			tab[4] = listeInventaire.get(indexOfInventaire).getNbOutils();
			tab[5] = listeInventaire.get(indexOfInventaire).getNiveauAgriculture();

			tab[a] += 1; //on ajoute plus 1  a la ressource choisi par le joueur . on suppose que chaque joueur faire le jet de de et choisir directement la ressource

			listeInventaire.get(indexOfInventaire).setNbBois(tab[0]);
			listeInventaire.get(indexOfInventaire).setNbArgile(tab[1]);
			listeInventaire.get(indexOfInventaire).setNbPierre(tab[2]);
			listeInventaire.get(indexOfInventaire).setNbOr(tab[3]);
			listeInventaire.get(indexOfInventaire).setNbOutils(tab[4]);
			listeInventaire.get(indexOfInventaire).setNiveauAgriculture(tab[5]);

			//le tour pass a le joueur suivant 

			indexOfInventaire = (indexOfInventaire + 1) % size;

		}

	}
	private void ressource_avec_jet_de(Inventaire i, Ressource r) {
		/*
		 * cette méthode utilisée dans la méthode gain Carte .elle permet le joueur  de gagner des ressources selon le jet de et le type de ressource fournie par la carte		 * on a supposé que  le joueur va gagner immediatement ces deux ressources pour simplifier le travail.
		 * 
		 * */

		int resultat = rand.nextInt(12) + 1;

		if (r == Ressource.OR) {
			i.setNbOr(resultat / 6);
		} else if (r == Ressource.PIERRE) {
			i.setNbOr(resultat / 5);
		} else if (r == Ressource.BOIS) {
			i.setNbOr(resultat / 3);
		}

	}

	public void ressource_au_choix(Inventaire i) {
		/*
		 * cette methode utilisée dans la methode gainCarte .elle permet le joueur  de gagner ,immédiatement ou plus tard ,deux ressources au choix (identiques ou differentes)
		 * on a supposé que  le joueur va gagner immediatement ces deux ressources pour simplifier le travail.
		 * on a récupéré les ressources de l'inventaire dans un tableau . et à chaque fois on joute 1 à une ressource choisi par hasard 
		 * */

		int[] tab = new int[4];
		tab[0] = i.getNbBois();
		tab[1] = i.getNbArgile();
		tab[2] = i.getNbPierre();
		tab[3] = i.getNbOr();

		int index = rand.nextInt(4);

		tab[index] += 1;
		index = rand.nextInt(4);
		tab[index] += 1;

		i.setNbBois(tab[0]);
		i.setNbArgile(tab[1]);
		i.setNbPierre(tab[2]);
		i.setNbOr(tab[3]);

	}

	public static void de() {

		int nbJoueur = Partie.getNbJoueur();
		int resultat = 0;

		for (int i = 0; i<nbJoueur; i++) {
			resultat += rand.nextInt(6) + 1;
		}

	}

	public static ArrayList<CarteCivilisation> CreationCarte() {

		ArrayList<CarteCivilisation> cards = new ArrayList<CarteCivilisation> ();

		//5 cartes ressources 
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.PIERRE));
		cards.add(new CarteCivilisation(2, Couleur.VERTE, Ressource.PIERRE));
		cards.add(new CarteCivilisation(1, Couleur.SABLE, Ressource.ARGILE));
		cards.add(new CarteCivilisation(1, Couleur.SABLE, Ressource.PIERRE));
		cards.add(new CarteCivilisation(1, Couleur.SABLE, Ressource.OR));

		// 7 cartes nourritures 
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(4, Couleur.SABLE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(3, Couleur.SABLE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(7, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(2, Couleur.SABLE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(5, Couleur.VERTE, Ressource.NOURRITURE));
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.NOURRITURE));

		//3 cartes point de victoire 
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.POINT));
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.POINT));
		cards.add(new CarteCivilisation(3, Couleur.SABLE, Ressource.POINT));

		//2 cartes agriculture 
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.AGRICULTURE));
		cards.add(new CarteCivilisation(1, Couleur.SABLE, Ressource.AGRICULTURE));

		// 1 carte tuile outil 
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.OUTIL));

		// 1 carte ressource au choix
		cards.add(new CarteCivilisation(2, Couleur.VERTE, Ressource.RESSOURCE_AU_CHOIX));

		// 1 carte pour le calcul  du score 
		cards.add(new CarteCivilisation(0, Couleur.VERTE, Ressource.AGRICULTURE)); //cette carte pour le calcul de score final donc lapartie superieure n' a pas d'effet (voir description cartes de civilisations )

		//3 cartes Ressources avec jet de dés 
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.OR, true));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.PIERRE, true));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.BOIS, true));

		// 10 cartes  jet de dés
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true));
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true));
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true));
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true));
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true));
        cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true));
		
		// 3 cartes   "outils a usage unique "
		cards.add(new CarteCivilisation(4, Couleur.SABLE, Ressource.OUTIL_USAGE_UNIQUE));
		cards.add(new CarteCivilisation(3, Couleur.SABLE, Ressource.OUTIL_USAGE_UNIQUE));
		cards.add(new CarteCivilisation(2, Couleur.SABLE, Ressource.OUTIL_USAGE_UNIQUE));

		return cards;
	}
}