package fr.pizzeria.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		// Variables utilisées pour les crud
		String libelle = "";
		String code = "";
		Double prix = 0.0D;
		String codePizza = "";
		int index = 0;

		// pizza instanciées de base
		Pizza p1 = new Pizza("PEP", "Pepperoni", 12.50D);
		Pizza p2 = new Pizza("MAR", "Margherita", 14.00D);
		Pizza p3 = new Pizza("REIN", "La reine", 11.50D);
		Pizza p4 = new Pizza("FRO", "La 4 fromage", 12.00D);
		Pizza p5 = new Pizza("CAN", "La cannibale", 12.50D);
		Pizza p6 = new Pizza("SAV", "La savoyarde", 13.50D);
		Pizza p7 = new Pizza("ORI", "L'orientale", 13.50D);
		Pizza p8 = new Pizza("IND", "L'indienne", 14.00D);

		// ajout à la liste des pizzas
		List<Pizza> listePizzas = new ArrayList<Pizza>();
		listePizzas.add(p1);
		listePizzas.add(p2);
		listePizzas.add(p3);
		listePizzas.add(p4);
		listePizzas.add(p5);
		listePizzas.add(p6);
		listePizzas.add(p7);
		listePizzas.add(p8);

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
				for (Pizza pizza : listePizzas) {
					System.out.println(pizza);
				}
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

				listePizzas.add(new Pizza(code, libelle, prix));
				afficherMenu();
				code = "";
				libelle = "";
				prix = 0D;
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
				for (int i = 0; i < listePizzas.size(); i++) {
					if (codePizza.equals(listePizzas.get(i).getCode())) {
						index = i;
					}
				}
				System.out.println("Entrez le nouveau code");
				code = sc.nextLine();
				listePizzas.get(index).setCode(code);
				System.out.println("Entrez le nouveau libellé");
				libelle = sc.nextLine();
				listePizzas.get(index).setLibelle(libelle);
				System.out.println("Entrez le nouveau prix");
				prix = Double.parseDouble(sc.nextLine());
				listePizzas.get(index).setPrix(prix);
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
				for (int i = 0; i < listePizzas.size(); i++) {
					if (codePizza.equals(listePizzas.get(i).getCode())) {
						index = i;
					}
				}
				listePizzas.remove(index);

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
