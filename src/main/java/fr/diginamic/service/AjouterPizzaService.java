package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) {

		System.out.println("***** Ajout d'une nouvelle pizza *****");
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String libelle = sc.nextLine();
		System.out.println("Veuillez saisir le code :");

		String code = sc.nextLine();

		System.out.println("Veuillez saisir le prix :");
		Double prix = Double.parseDouble(sc.nextLine());

		dao.saveNewPizza(new Pizza(code, libelle, prix));

	}

}
