package fr.pizzeria.main;

import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.service.AfficherMenuService;
import fr.diginamic.service.AjouterPizzaService;
import fr.diginamic.service.ListerPizzaService;
import fr.diginamic.service.ModifierPizzaService;
import fr.diginamic.service.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		PizzaMemDao pizzaDao = new PizzaMemDao();
		AfficherMenuService aff = new AfficherMenuService();
		ListerPizzaService listerPizzas = new ListerPizzaService();
		AjouterPizzaService ajouterPizza = new AjouterPizzaService();
		ModifierPizzaService modifierPizza = new ModifierPizzaService();
		SupprimerPizzaService supprimerPizza = new SupprimerPizzaService();

		// scanner et variable pour gérer les choix utilisateur
		Scanner sc = new Scanner(System.in);
		String choix = "";

		aff.afficherMenu();
		choix = sc.nextLine();

		do {
			switch (choix) {

			/*
			 * affichage de la liste des pizzas
			 */
			case "1":
				listerPizzas.executeUC(sc, pizzaDao);
				aff.afficherMenu();
				choix = sc.nextLine();
				break;
			/**
			 * Ajout d'une pizza
			 */
			case "2":
				ajouterPizza.executeUC(sc, pizzaDao);
				aff.afficherMenu();
				choix = sc.nextLine();
				break;
			/**
			 * Modif d'une pizza existante
			 */
			case "3":
				modifierPizza.executeUC(sc, pizzaDao);
				aff.afficherMenu();
				choix = sc.nextLine();
				break;
			/**
			 * Suppression d'une pizza existante
			 * 
			 */
			case "4":
				supprimerPizza.executeUC(sc, pizzaDao);
				aff.afficherMenu();
				choix = sc.nextLine();
				break;
			/**
			 * Quitter
			 */

			case "99":
				System.out.println("Au revoir \u2639");
				break;
			/**
			 * Si erreur de saisie
			 */
			default:
				System.out.println("Choix invalide");
				choix = sc.nextLine();
				break;
			}

		} while (!choix.equals("99"));
		sc.close();

	}

}
