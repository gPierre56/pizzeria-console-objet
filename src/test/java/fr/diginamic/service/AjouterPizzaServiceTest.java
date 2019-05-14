package fr.diginamic.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.diginamic.dao.PizzaMemDao;
import fr.diginamic.exception.SavePizzaException;

public class AjouterPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUC() {
		AjouterPizzaService pizzaService = new AjouterPizzaService();
		PizzaMemDao dao = new PizzaMemDao();

		systemInMock.provideLines("nomaupif", "LMP", "250", "1");
		try {
			pizzaService.executeUC(new Scanner(System.in), dao);
		} catch (SavePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(dao.findPizzaByCode("LMP"));

	}

	@Test(expected = SavePizzaException.class)
	public void testExecuteUCNonNominal() throws SavePizzaException {
		AjouterPizzaService pizzaService = new AjouterPizzaService();
		PizzaMemDao dao = new PizzaMemDao();

		systemInMock.provideLines("nomaupif", "LMPgtrgtg", "250", "1");

		pizzaService.executeUC(new Scanner(System.in), dao);

	}

}
