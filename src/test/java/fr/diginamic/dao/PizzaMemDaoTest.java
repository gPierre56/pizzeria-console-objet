package fr.diginamic.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {

	public List<Pizza> listeTest = new ArrayList<Pizza>();

	@Test
	public void testSaveNewPizza() {
		PizzaMemDao dao = new PizzaMemDao();
		try {
			dao.saveNewPizza(new Pizza("PPP", "Plooko", 14.05, CategoriePizza.POISSON));
			assertNotNull(dao.findPizzaByCode("PPP"));
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testSaveNewPizzaNonNominal() {
		PizzaMemDao dao = new PizzaMemDao();
		try {
			dao.saveNewPizza(null);
			assertNotNull(dao.findPizzaByCode("PEP"));
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testUpdatePizza() {
		PizzaMemDao dao = new PizzaMemDao();
		try {
			dao.updatePizza("PEP", new Pizza("PPP", "Plooko", 14.05, CategoriePizza.POISSON));
			assertNotNull(dao.findPizzaByCode("PPP"));
			assertNull(dao.findPizzaByCode("PEP"));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdatePizzaNonNominal() {
		PizzaMemDao dao = new PizzaMemDao();
		dao.updatePizza("1651", null);
		assertNull(dao.findPizzaByCode("1651"));

	}

	@Test
	public void testDeletePizza() {
		PizzaMemDao dao = new PizzaMemDao();
		try {
			dao.deletePizza("PEP");
			assertNull(dao.findPizzaByCode("PEP"));
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testFindPizzaByCode() {
		PizzaMemDao dao = new PizzaMemDao();
		assertNotNull(dao.findPizzaByCode("PEP"));
		assertNull(dao.findPizzaByCode("gjbhuebgb"));
		assertNull(dao.findPizzaByCode(null));

	}

}
