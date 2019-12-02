package stoneage;

import jdk.internal.loader.Resource;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CarteCivilisation {

	public enum Couleur {
		VERTE, JAUNE;
	}

	private Ressource ressourceCarte;
	private int nbRessourceCarte;
	private Couleur couleur;
	private boolean placeReservee = false;

	CarteCivilisation(int nbRessourceCarte, Couleur couleur, Ressource ressourceCarte) {
		this.nbRessourceCarte = nbRessourceCarte;
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
	}

	//setter
	public void setNbRessourceCarte(int nbRessourceCarte) {
		this.nbRessourceCarte = nbRessourceCarte;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void setPlaceReservee(boolean placeReservee) {
		this.placeReservee = placeReservee;
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
		return this.placeReservee;
	}

	//methode de classe :

	/**
	 *
	 * @param inventaireJoueur
	 * @param nbOuvrierAplacer
	 * @param id
	 */
	public void placeOuvrierSurCarte(Inventaire inventaireJoueur, int nbOuvrierAplacer) {
		if ((isPlaceReservee() == false) && (nbOuvrierAplacer == 1)) {
			inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() - 1);
			setPlaceReservee(true);
		} else {
			if (isPlaceReservee() == true) {
				throw new java.lang.Error("la carte est deja reservée !");
			} else {
				throw new java.lang.Error("on peut pas placer plus qu'un ouvrier sur une carte");

			}
		}
	}

	/**
	 *
	 * @param inventaireJoueur
	 */
	public void retirerOuvrierSurCarte(@NotNull Inventaire inventaireJoueur) {
		inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
		this.placeReservee = false;

	}

	public String toString() {

		return " ressourceCarte " + this.ressourceCarte + " couleur " + this.couleur + "nbressource " + this.nbRessourceCarte;
	}
}