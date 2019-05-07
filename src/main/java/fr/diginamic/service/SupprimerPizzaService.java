package fr.diginamic.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * Gère les interactions utilisateurs dans le but de supprimer une pizza
 * 
 * @author Guillaume
 *
 */
public class SupprimerPizzaService extends MenuService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SupprimerPizzaService.class);

	@Override
	public void executeUC(Scanner sc, PizzaMemDao dao) throws DeletePizzaException {
		System.out.println("Suppression d'une pizza");
		System.out.println("Renseignez le code de la pizza à modifier");
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza);
		}
		String codePizza = sc.nextLine();
		// recherche de la pizza avec ce code
		if (dao.findPizzaByCode(codePizza) == null) {
			LOGGER.error("Erreur - Pizza entrée non trouvée");
			throw new DeletePizzaException("Cette pizza n'existe pas.");
		}
		LOGGER.info("Pizza supprimée : ".concat(dao.findPizzaByCode(codePizza).toString()));
		dao.deletePizza(codePizza);

	}

}
