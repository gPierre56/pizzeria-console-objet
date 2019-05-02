package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) {
		System.out.println("Suppression d'une pizza");
		System.out.println("Renseignez le code de la pizza à modifier");
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza);
		}
		String codePizza = sc.nextLine();
		// recherche de la pizza avec ce code
		dao.deletePizza(codePizza);

	}

}
