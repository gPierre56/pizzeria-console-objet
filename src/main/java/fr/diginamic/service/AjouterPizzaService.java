package fr.diginamic.service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) throws SavePizzaException {

		System.out.println("***** Ajout d'une nouvelle pizza *****");

		System.out.println("Veuillez saisir le nom (sans espace) :");
		String libelle = sc.nextLine();
		if (libelle.contains(" ")) {
			throw new SavePizzaException("Le nom ne doit pas contenir d'espace.");
		}
		System.out.println("Veuillez saisir le code :");

		String code = sc.nextLine();
		if (code.length() != 3) {
			throw new SavePizzaException("Le code doit contenir 3 caractères.");
		}

		System.out.println("Veuillez saisir le prix :");

		String prixString = sc.nextLine();
		if (!NumberUtils.isCreatable(prixString)) {
			throw new SavePizzaException("Ce chiffre est invalide");
		}
		Double prix = Double.parseDouble(prixString);

		dao.saveNewPizza(new Pizza(code, libelle, prix));

	}

}
