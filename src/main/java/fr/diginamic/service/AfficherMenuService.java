package fr.diginamic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * classe qui gère l'affichage du menu
 * 
 * @author Guillaume
 *
 */
public class AfficherMenuService {

	/** LOGGER : Logger classe de traçage */
	private static final Logger LOGGER = LoggerFactory.getLogger(AfficherMenuService.class);

	/**
	 * affiche le menu admin de la pizzeria
	 */
	public void afficherMenu() {
		LOGGER.info("Affichage du menu");
		System.out.println("\n***** Pizzeria administration *****");
		System.out.println("1 - Lister les pizzas");
		System.out.println("2 - Ajouter une nouvelle pizza");
		System.out.println("3 - Mettre à jour une pizza");
		System.out.println("4 - Supprimer une pizza");
		System.out.println("99 - Sortir");
	}

}
