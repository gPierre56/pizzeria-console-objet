
package fr.diginamic.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * @author Guillaume
 *
 */
public class PizzaMemDao implements IPizzaDao {

	public List<Pizza> listePizzas = new ArrayList<Pizza>();

	@Override
	public List<Pizza> findAllPizzas() {

		listePizzas.add(new Pizza("PEP", "Pepperoni", 12.50D));
		listePizzas.add(new Pizza("MAR", "Margherita", 14.00D));
		listePizzas.add(new Pizza("REIN", "La reine", 11.50D));
		listePizzas.add(new Pizza("FRO", "La 4 fromage", 12.00D));
		listePizzas.add(new Pizza("CAN", "La cannibale", 12.50D));
		listePizzas.add(new Pizza("SAV", "La savoyarde", 13.50D));
		listePizzas.add(new Pizza("ORI", "L'orientale", 13.50D));
		listePizzas.add(new Pizza("IND", "L'indienne", 14.00D));
		return listePizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		listePizzas.add(pizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		for (int i = 0; i < listePizzas.size(); i++) {
			if (listePizzas.get(i).getCode().equals(codePizza)) {
				listePizzas.set(i, pizza);

			}

		}
	}

	@Override
	public void deletePizza(String codePizza) {
		for (int i = 0; i < listePizzas.size(); i++) {
			if (listePizzas.get(i).getCode().equals(codePizza)) {
				listePizzas.remove(i);

			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (int i = 0; i < listePizzas.size(); i++) {
			if (listePizzas.get(i).getCode().equalsIgnoreCase(codePizza)) {
				return listePizzas.get(i);
			}

		}
		return null;
	}

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

}
