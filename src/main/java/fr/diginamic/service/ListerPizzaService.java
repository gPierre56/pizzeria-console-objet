package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;

/**
 * classe qui gère l'affichage des pizzas dans le menu
 * 
 * @author Guillaume
 *
 */
public class ListerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) {

		System.out.println("Liste des pizzas");
		for (int i = 0; i < dao.findAllPizzas().size(); i++) {
			System.out.println(dao.findAllPizzas().get(i));
		}
	}

}
