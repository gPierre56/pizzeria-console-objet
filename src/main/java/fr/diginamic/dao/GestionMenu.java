package fr.diginamic.dao;

import java.util.Scanner;

import fr.diginamic.exception.DeletePizzaException;
import fr.diginamic.exception.SavePizzaException;
import fr.diginamic.exception.UpdatePizzaException;
import fr.diginamic.service.AjouterPizzaService;
import fr.diginamic.service.ListerPizzaService;
import fr.diginamic.service.ModifierPizzaService;
import fr.diginamic.service.SupprimerPizzaService;

/**
 * Classe qui gère les entrées claviers de l'utilisateur
 * 
 * @author Guillaume
 *
 */
public class GestionMenu {

	PizzaMemDao dao = new PizzaMemDao();
	ListerPizzaService listerPizzaService = new ListerPizzaService();
	AjouterPizzaService ajouterPizza = new AjouterPizzaService();
	ModifierPizzaService modifierPizza = new ModifierPizzaService();
	SupprimerPizzaService supprimerPizza = new SupprimerPizzaService();

	/**
	 * @param choix : choix utilisateur entré au scanner
	 * @param sc    : scanner avec lequel va interagir l'utilisateur
	 */
	public void reponseMenu(String choix, Scanner sc) {
		switch (choix) {
		case "1":
			listerPizzaService.executeUC(sc, dao);
			break;
		case "2":
			try {
				ajouterPizza.executeUC(sc, dao);
			} catch (SavePizzaException e) {

				System.err.println(e.getMessage());
			}
			break;
		case "3":
			try {
				modifierPizza.executeUC(sc, dao);
			} catch (UpdatePizzaException e) {

				System.err.println(e.getMessage());
			}
			break;
		case "4":
			try {
				supprimerPizza.executeUC(sc, dao);
			} catch (DeletePizzaException e) {

				System.err.println(e.getMessage());
			}
			break;
		case "99":
			System.out.println("Au revoir \u2639");
			break;
		default:
			System.out.println("Choix invalide");
			choix = sc.nextLine();
			break;
		}
	}
}
