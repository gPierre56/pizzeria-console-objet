/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * @author Guillaume
 *
 */
public interface IPizzaDao {

	/**
	 * @return la liste de toutes les pizzas
	 */
	List<Pizza> findAllPizzas();

	/**
	 * @param pizza : la pizza a ajouter // ajoute une nouvelle pizza
	 */
	void saveNewPizza(Pizza pizza);

	/**
	 * @param codePizza : code de la pizza a modifier
	 * @param pizza     : la pizza qui va remplacer celle à modifier
	 */
	void updatePizza(String codePizza, Pizza pizza);

	/**
	 * @param codePizza : le code de la pizza a supprimer
	 */
	void deletePizza(String codePizza);

	/**
	 * @param codePizza : code de la pizza a chercher
	 * @return renvoie la pizza comportant le code, ou null si introuvable
	 */
	Pizza findPizzaByCode(String codePizza);

	/**
	 * @param codePizza : code d ela pizza a chercher
	 * @return true si la pizza existe, false si elle n'a pas été trouvée
	 */
	boolean pizzaExists(String codePizza);

}
