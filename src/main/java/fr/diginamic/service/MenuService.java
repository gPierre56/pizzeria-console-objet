package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.dao.PizzaMemDao;

public abstract class MenuService {

	public abstract void executeUC(Scanner sc, PizzaMemDao dao);

}
