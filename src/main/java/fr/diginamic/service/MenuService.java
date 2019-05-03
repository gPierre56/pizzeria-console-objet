package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.exception.StockageException;

public abstract class MenuService {

	/**
	 * @param sc  : le scanner avec lequel interagit l'utilisateur
	 * @param dao : la dao vers laquelle va pointer le service
	 */
	public abstract void executeUC(Scanner sc, PizzaMemDao dao) throws StockageException;

}
