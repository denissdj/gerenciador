package br.com.javagyn.exception;

/**
 * <p>
 * <b>Title:</b> ValidaçãoException
 * </p>
 * 
 * <p>
 * <b>Description:</b> ValidaçãoException
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * 
 * @version 1.0.0
 */
public class ValidaçãoException extends Exception {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param msg
	 */
	public ValidaçãoException( final String msg ) {

		super(msg);
	}

}
