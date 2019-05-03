package fr.diginamic.service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) throws UpdatePizzaException {

		System.out.println("***** Mise à jour d'une pizza *****");
		System.out.println("Renseignez le code de la pizza à modifier");
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza);
		}
		String codePizza = sc.nextLine();
		// recherche de la pizza avec ce code
		if (dao.pizzaExists(codePizza) == false) {
			throw new UpdatePizzaException("Cette pizza n'existe pas");
		}
		System.out.println("Entrez le nouveau code");
		String code = sc.nextLine();
		if (code.length() != 3) {
			throw new UpdatePizzaException("Le code doit contenir 3 caractères.");
		}
		System.out.println("Entrez le nouveau libellé");
		String libelle = sc.nextLine();
		if (libelle.contains(" ")) {
			throw new UpdatePizzaException("Le nom ne doit pas contenir d'espace.");
		}
		System.out.println("Entrez le nouveau prix");
		String prixString = sc.nextLine();
		if (!NumberUtils.isCreatable(prixString)) {
			throw new UpdatePizzaException("Ce chiffre est invalide");
		}
		Double prix = Double.parseDouble(prixString);
		Pizza pizzaModif = new Pizza(code, libelle, prix);
		dao.updatePizza(codePizza, pizzaModif);

	}

}
