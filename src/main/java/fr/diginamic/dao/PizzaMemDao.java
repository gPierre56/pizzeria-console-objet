
package fr.diginamic.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Définition des méthodes utilisées pour la gestion de la pizzeria
 * 
 * @author Guillaume
 *
 */
public class PizzaMemDao implements IPizzaDao {

	/** LOGGER : Logger / classe de traçage */
	private static final Logger LOGGER = LoggerFactory.getLogger(PizzaMemDao.class);

	/** listePizzas : List<Pizza> */
	private List<Pizza> listePizzas = new ArrayList<Pizza>();

	/**
	 * Constructor : Initialise une liste de pizza préremplie
	 * 
	 */
	public PizzaMemDao() {
		super();

		listePizzas.add(new Pizza("PEP", "Pepperoni", 12.50D, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("MAR", "Margherita", 14.00D, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("REIN", "La reine", 11.50D, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("FRO", "La 4 fromage", 12.00D, CategoriePizza.SANS_VIANDE));
		listePizzas.add(new Pizza("CAN", "La cannibale", 12.50D, CategoriePizza.POISSON));
		listePizzas.add(new Pizza("SAV", "La savoyarde", 13.50D, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("ORI", "L'orientale", 13.50D, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("IND", "L'indienne", 14.00D, CategoriePizza.SANS_VIANDE));
	}

	/**
	 * retourne la totalité des pizzas enregistrées
	 */
	@Override
	public List<Pizza> findAllPizzas() {

		return listePizzas;
	}

	/**
	 * Ajoute une pizza dans la liste
	 */
	@Override
	public void saveNewPizza(Pizza pizza) {

		listePizzas.add(pizza);

	}

	/**
	 * Modifie les 3 champs d'une pizza enregistrée
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		for (int i = 0; i < listePizzas.size(); i++) {
			if (listePizzas.get(i).getCode().equals(codePizza)) {
				listePizzas.set(i, pizza);

			}

		}
	}

	/**
	 * Supprime une pizza de la liste
	 */
	@Override
	public void deletePizza(String codePizza) {
		for (int i = 0; i < listePizzas.size(); i++) {
			if (listePizzas.get(i).getCode().equals(codePizza)) {
				listePizzas.remove(i);

			}
		}
	}

	/**
	 * Renvoie la pizza avec le code correspondant, sinon retourne null
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (int i = 0; i < listePizzas.size(); i++) {
			if (listePizzas.get(i).getCode().equalsIgnoreCase(codePizza)) {
				return listePizzas.get(i);
			}

		}
		return null;
	}

	/**
	 * renvoie true si le code en parametre correspond au code d'une pizza de la
	 * liste, sinon renvoie false
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		boolean flag = false;
		for (int i = 0; i < listePizzas.size(); i++) {
			if (listePizzas.get(i).getCode().equalsIgnoreCase(codePizza)) {
				flag = true;

			}
		}
		return flag;
	}

	/**
	 * Getter
	 * 
	 * @return the listePizzas
	 */
	public List<Pizza> getListePizzas() {
		return listePizzas;
	}

	/**
	 * Setter
	 * 
	 * @param listePizzas the listePizzas to set
	 */
	public void setListePizzas(List<Pizza> listePizzas) {
		this.listePizzas = listePizzas;
	}

}
