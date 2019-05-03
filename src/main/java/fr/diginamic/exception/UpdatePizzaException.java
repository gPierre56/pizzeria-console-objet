package fr.diginamic.exception;

/**
 * Classe qui gère les exceptions liées à la mise à jour d'une pizza
 * 
 * @author Guillaume
 *
 */
public class UpdatePizzaException extends StockageException {

	/** serialVersionUID : long */
	private static final long serialVersionUID = -1052952311331730969L;

	/**
	 * Constructor
	 * 
	 * @param message affiché en cas d'erreurs liées à la mise à jour d'une pizza
	 */
	public UpdatePizzaException(String message) {
		super(message);
	}

}
