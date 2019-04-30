package fr.pizzeria.main;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choix = 0;

		afficherMenu();
		choix = sc.nextInt();

		do {
			switch (choix) {
			case 1:
				System.out.println("Liste des pizzas");
				afficherMenu();
				choix = sc.nextInt();
				break;
			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				afficherMenu();
				choix = sc.nextInt();
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
				afficherMenu();
				choix = sc.nextInt();
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				afficherMenu();
				choix = sc.nextInt();
				break;

			case 99:
				System.out.println("Au revoir \u2639");
				break;

			default:
				System.out.println("Choix invalide");
				choix = sc.nextInt();
				break;
			}

		} while (choix != 99);

	}

	static void afficherMenu() {
		System.out.println("***** Pizzeria administration *****");
		System.out.println("1 - Lister les pizzas");
		System.out.println("2 - Ajouter une nouvelle pizza");
		System.out.println("3 - Mettre à jour une pizza");
		System.out.println("4 - Supprimer une pizza");
		System.out.println("99 - Sortir");
	}

}
