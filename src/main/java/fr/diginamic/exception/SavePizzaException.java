package fr.diginamic.exception;

/**
 * Classe qui gère les exceptions liées à l'ajout d'une pizza
 * 
 * @author Guillaume
 *
 */
public class SavePizzaException extends StockageException {

	/** serialVersionUID : long */
	private static final long serialVersionUID = 925224653219408062L;

	/**
	 * Constructor
	 * 
	 * @param message diffusé en cas de problème lors de l'ajout d'une pizza
	 */
	public SavePizzaException(String message) {
		super(message);
	}

}
