package fr.pizzeria.main;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		PizzaMemDao pizzaDao = new PizzaMemDao();

		// Variables utilisées pour les crud
		String libelle = "";
		String code = "";
		Double prix = 0.0D;
		String codePizza = "";

		List<Pizza> listePizzas = pizzaDao.findAllPizzas();

		// scanner et variable pour gérer les choix utilisateur
		Scanner sc = new Scanner(System.in);
		String choix = "";

		afficherMenu();
		choix = sc.nextLine();

		do {
			switch (choix) {

			/*
			 * affichage de la liste des pizzas
			 */
			case "1":
				System.out.println("Liste des pizzas");
				System.out.println(listePizzas.size());
				System.out.println(listePizzas);
				afficherMenu();
				choix = sc.nextLine();
				break;
			/*
			 * Ajout d'une pizza
			 */
			case "2":
				System.out.println("***** Ajout d'une nouvelle pizza *****");

				System.out.println("Veuillez saisir le nom (sans espace) :");
				libelle = sc.nextLine();

				System.out.println("Veuillez saisir le code :");

				code = sc.nextLine();

				System.out.println("Veuillez saisir le prix :");
				prix = Double.parseDouble(sc.nextLine());

				pizzaDao.saveNewPizza(new Pizza(code, libelle, prix));
				afficherMenu();

				choix = sc.nextLine();
				break;
			/*
			 * Modif d'une pizza existante
			 */
			case "3":
				System.out.println("***** Mise à jour d'une pizza *****");
				System.out.println("Renseignez le code de la pizza à modifier");
				for (Pizza pizza : listePizzas) {
					System.out.println(pizza);
				}
				codePizza = sc.nextLine();
				// recherche de la pizza avec ce code
				if (pizzaDao.pizzaExists(codePizza)) {
					System.out.println("Entrez le nouveau code");
					code = sc.nextLine();
					System.out.println("Entrez le nouveau libellé");
					libelle = sc.nextLine();
					System.out.println("Entrez le nouveau prix");
					prix = Double.parseDouble(sc.nextLine());
					Pizza pizzaModif = new Pizza(code, libelle, prix);
					pizzaDao.updatePizza(codePizza, pizzaModif);
				} else {
					System.out.println("Pizza introuvable");
				}

				afficherMenu();
				choix = sc.nextLine();
				break;
			/*
			 * Suppression d'une pizza existante
			 * 
			 */
			case "4":
				System.out.println("Suppression d'une pizza");
				System.out.println("Renseignez le code de la pizza à modifier");
				for (Pizza pizza : listePizzas) {
					System.out.println(pizza);
				}
				codePizza = sc.nextLine();
				// recherche de la pizza avec ce code
				pizzaDao.deletePizza(codePizza);

				afficherMenu();
				choix = sc.nextLine();
				break;
			/*
			 * Quitter
			 */

			case "99":
				System.out.println("Au revoir \u2639");
				break;
			/*
			 * Si erreur de saisie
			 */
			default:
				System.out.println("Choix invalide");
				choix = sc.nextLine();
				break;
			}

		} while (choix != "99");
		sc.close();

	}

	/**
	 * Affichage du menu admin
	 */
	static void afficherMenu() {
		System.out.println("\n***** Pizzeria administration *****");
		System.out.println("1 - Lister les pizzas");
		System.out.println("2 - Ajouter une nouvelle pizza");
		System.out.println("3 - Mettre à jour une pizza");
		System.out.println("4 - Supprimer une pizza");
		System.out.println("99 - Sortir");
	}

}
