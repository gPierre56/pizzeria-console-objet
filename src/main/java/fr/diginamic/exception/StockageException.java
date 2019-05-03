package fr.diginamic.exception;

/**
 * Classe mère de la gestion des exceptions
 * 
 * @author Guillaume
 *
 */
public class StockageException extends Exception {

	/** serialVersionUID : long */
	private static final long serialVersionUID = -6093417616112486681L;

	/**
	 * Constructor
	 * 
	 * @param message utilisé par les classes filles pour la description d'erreurs
	 */
	public StockageException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
