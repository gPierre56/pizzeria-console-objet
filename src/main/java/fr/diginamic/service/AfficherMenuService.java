package fr.diginamic.service;

public class AfficherMenuService {

	/**
	 * affiche le menu admin de la pizzeria
	 */
	public void afficherMenu() {
		System.out.println("\n***** Pizzeria administration *****");
		System.out.println("1 - Lister les pizzas");
		System.out.println("2 - Ajouter une nouvelle pizza");
		System.out.println("3 - Mettre à jour une pizza");
		System.out.println("4 - Supprimer une pizza");
		System.out.println("99 - Sortir");
	}

}
