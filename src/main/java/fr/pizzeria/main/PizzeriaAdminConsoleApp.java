package fr.pizzeria.main;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public static void main(String[] args) {
		LOG.info("Démarrage de l'application");

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
