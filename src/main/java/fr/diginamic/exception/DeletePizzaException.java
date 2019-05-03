package fr.diginamic.exception;

/**
 * Classe qui gère les exceptions liées à la suppression d'une pizza
 * 
 * @author Guillaume
 *
 */
public class DeletePizzaException extends StockageException {

	/** serialVersionUID : long */
	private static final long serialVersionUID = 7141108307466119025L;

	/**
	 * Constructor
	 * 
	 * @param message : message de retour en cas de déclenchement de l'exception
	 */
	public DeletePizzaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
