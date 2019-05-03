package fr.pizzeria.model;

/**
 * Enumeration qui gère les catégories de pizza
 * 
 * @author Guillaume
 *
 */
public enum CategoriePizza {

	/** VIANDE : CategoriePizza */
	VIANDE(1, "Viande"),
	/** POISSON : CategoriePizza */
	POISSON(2, "Poisson"),
	/** SANS_VIANDE : CategoriePizza */
	SANS_VIANDE(3, "Sans viande");

	/** categorie : String */
	private int numCategorie;
	private String nomCategorie;

	/**
	 * @param categorie
	 * @return true si la categorie renseignée match l'un des attributs de la
	 *         catégorie, sinon false
	 */
	public static boolean categorieExists(int numCategorie) {
		for (int i = 0; i < CategoriePizza.values().length; i++) {
			if (numCategorie == (CategoriePizza.values()[i].numCategorie)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param numCategorie
	 * @return Une catégorie si match avec le numero en parametre, sinon null
	 */
	public static CategoriePizza findCategorieByNum(int numCategorie) {
		for (int i = 0; i < CategoriePizza.values().length; i++) {
			if (numCategorie == CategoriePizza.values()[i].numCategorie) {
				return CategoriePizza.values()[i];
			}

		}
		return null;
	}

	private CategoriePizza(int numCategorie, String nomCategorie) {
		this.nomCategorie = nomCategorie;
		this.numCategorie = numCategorie;
	}

	/**
	 * Getter
	 * 
	 * @return the nomCategorie
	 */
	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * Setter
	 * 
	 * @param nomCategorie the nomCategorie to set
	 */
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	/**
	 * Getter
	 * 
	 * @return the numCategorie
	 */
	public int getNumCategorie() {
		return numCategorie;
	}

	/**
	 * Setter
	 * 
	 * @param numCategorie the numCategorie to set
	 */
	public void setNumCategorie(int numCategorie) {
		this.numCategorie = numCategorie;
	}

}
