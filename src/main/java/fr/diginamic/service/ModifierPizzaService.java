package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) {

		System.out.println("***** Mise à jour d'une pizza *****");
		System.out.println("Renseignez le code de la pizza à modifier");
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza);
		}
		String codePizza = sc.nextLine();
		// recherche de la pizza avec ce code
		if (dao.pizzaExists(codePizza)) {
			System.out.println("Entrez le nouveau code");
			String code = sc.nextLine();
			System.out.println("Entrez le nouveau libellé");
			String libelle = sc.nextLine();
			System.out.println("Entrez le nouveau prix");
			Double prix = Double.parseDouble(sc.nextLine());
			Pizza pizzaModif = new Pizza(code, libelle, prix);
			dao.updatePizza(codePizza, pizzaModif);
		} else {
			System.out.println("Pizza introuvable");
		}

	}

}
