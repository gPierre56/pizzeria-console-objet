package fr.pizzeria.main;

import java.util.Scanner;

import fr.diginamic.dao.GestionMenu;
import fr.diginamic.service.AfficherMenuService;

/**
 * Point d'entrée de l'application
 * 
 * @author Guillaume
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * @param méthode main
	 */
	public static void main(String[] args) {

		GestionMenu gestionMenu = new GestionMenu();
		AfficherMenuService aff = new AfficherMenuService();

		// scanner et variable pour gérer les choix utilisateur
		Scanner sc = new Scanner(System.in);
		String choix = "";

		do {
			aff.afficherMenu();
			choix = sc.nextLine();
			gestionMenu.reponseMenu(choix, sc);
		} while (!choix.equals("99"));
		sc.close();

	}

}
