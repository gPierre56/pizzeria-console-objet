package fr.diginamic.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.PizzaMemDao;

/**
 * classe qui gère l'affichage des pizzas dans le menu
 * 
 * @author Guillaume
 *
 */
public class ListerPizzaService extends MenuService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ListerPizzaService.class);

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) {

		System.out.println("Liste des pizzas");
		LOGGER.info("Affichage de la liste des pizzas");
		for (int i = 0; i < dao.findAllPizzas().size(); i++) {
			System.out.println(dao.findAllPizzas().get(i));
		}
	}

}
