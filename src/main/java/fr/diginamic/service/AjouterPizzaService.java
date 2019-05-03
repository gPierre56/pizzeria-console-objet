package fr.diginamic.service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Gestion des interactions utilisateurs en cas d'ajout de pizza
 * 
 * @author Guillaume
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) throws SavePizzaException {

		System.out.println("***** Ajout d'une nouvelle pizza *****");

		System.out.println("Veuillez saisir le nom (sans espace) :");
		String libelle = sc.nextLine();
		// verification de l'absence d'espace
		if (libelle.contains(" ")) {
			throw new SavePizzaException("Le nom ne doit pas contenir d'espace.");
		}
		System.out.println("Veuillez saisir le code :");

		String code = sc.nextLine();
		// vérification de la taille du code
		if (code.length() != 3) {
			throw new SavePizzaException("Le code doit contenir 3 caractères.");
		}

		System.out.println("Veuillez saisir le prix :");

		String str = sc.nextLine();
		// vérification que le prix entré est bien un nombre
		if (!NumberUtils.isCreatable(str)) {
			throw new SavePizzaException("Ce chiffre est invalide");
		}
		Double prix = Double.parseDouble(str);

		System.out.println("Veuillez sélectionner un numéro de catégorie valide");
		for (int i = 0; i < CategoriePizza.values().length; i++) {
			System.out.println(
					CategoriePizza.values()[i].getNumCategorie() + "- " + CategoriePizza.values()[i].getNomCategorie());

		}
		str = sc.nextLine();
		// vérification que le prix entré est bien un nombre
		if (!NumberUtils.isCreatable(str)) {
			throw new SavePizzaException("Ce chiffre est invalide");
		}
		int numCategorie = Integer.parseInt(str);
		// vérification de l'existence de la catégorie
		if (!CategoriePizza.categorieExists(numCategorie)) {
			throw new SavePizzaException("Cette catégorie n'existe pas");
		}
		CategoriePizza categorie = CategoriePizza.findCategorieByNum(numCategorie);

		dao.saveNewPizza(new Pizza(code, libelle, prix, categorie));

	}

}
