package fr.diginamic.service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Gère les interactions utilisateurs dans le but de modifier une pizza
 * 
 * @author Guillaume
 *
 */
public class ModifierPizzaService extends MenuService {

	Logger LOGGER = LoggerFactory.getLogger(ModifierPizzaService.class);

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) throws UpdatePizzaException {

		System.out.println("***** Mise à jour d'une pizza *****");
		System.out.println("Renseignez le code de la pizza à modifier");
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza);
		}
		String codePizza = sc.nextLine();
		// recherche de l'existence de la pizza avec ce code, sinon message d'erreur
		if (dao.pizzaExists(codePizza) == false) {
			LOGGER.error("Erreur - pizza innexistante");
			throw new UpdatePizzaException("Cette pizza n'existe pas");
		}
		System.out.println("Entrez le nouveau code");
		String code = sc.nextLine();
		// vérification que l'entrée est un nombre
		if (code.length() != 3) {
			throw new UpdatePizzaException("Le code doit contenir 3 caractères.");
		}
		System.out.println("Entrez le nouveau libellé");
		String libelle = sc.nextLine();
		// Vérification de l'absence d'espace
		if (libelle.contains(" ")) {
			throw new UpdatePizzaException("Le nom ne doit pas contenir d'espace.");
		}
		System.out.println("Entrez le nouveau prix");
		String str = sc.nextLine();
		// vérification que l'entrée est un nombre
		if (!NumberUtils.isCreatable(str)) {
			throw new UpdatePizzaException("Ce chiffre est invalide");
		}

		Double prix = Double.parseDouble(str);
		System.out.println("Veuillez sélectionner un nouveau numéro de catégorie valide");
		for (int i = 0; i < CategoriePizza.values().length; i++) {
			System.out.println(
					CategoriePizza.values()[i].getNumCategorie() + "- " + CategoriePizza.values()[i].getNomCategorie());

		}
		str = sc.nextLine();
		// vérification que le prix entré est bien un nombre
		if (!NumberUtils.isCreatable(str)) {
			throw new UpdatePizzaException("Ce chiffre est invalide");
		}
		int numCategorie = Integer.parseInt(str);
		// vérification de l'existence de la catégorie
		if (!CategoriePizza.categorieExists(numCategorie)) {
			throw new UpdatePizzaException("Cette catégorie n'existe pas");
		}
		CategoriePizza categorie = CategoriePizza.findCategorieByNum(numCategorie);
		Pizza pizzaModif = new Pizza(code, libelle, prix, categorie);
		LOGGER.info("Pizza modifiée : ".concat(dao.findPizzaByCode(codePizza).toString()));
		LOGGER.info("Nouvelle pizza : ".concat(pizzaModif.toString()));
		dao.updatePizza(codePizza, pizzaModif);

	}

}
