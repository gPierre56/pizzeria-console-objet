package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.exception.StockageException;

/**
 * Classe qui comporte la fonction mère des autres fonctions utilisées dans le
 * menu
 * 
 * @author Guillaume
 *
 */
public abstract class MenuService {

	/**
	 * @param sc  : le scanner avec lequel interagit l'utilisateur
	 * @param dao : la dao vers laquelle va pointer le service
	 */
	public abstract void executeUC(Scanner sc, PizzaMemDao dao) throws StockageException;

}
