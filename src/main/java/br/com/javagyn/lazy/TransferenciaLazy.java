package br.com.javagyn.lazy;

import javax.inject.Inject;

import br.com.javagyn.bo.TransferenciaBO;
import br.com.javagyn.model.Transferencia;

/**
 * <p>
 * <b>Title:</b> TransferenciaLazy
 * </p>
 * 
 * <p>
 * <b>Description:</b> TransferenciaLazy
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
public class TransferenciaLazy extends AppLazy<Transferencia> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private TransferenciaBO bo;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public TransferenciaLazy() {

		this.setConsulta(new Transferencia());
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#getDtoClass()
	 */
	@Override
	protected Class<Transferencia> getDtoClass() {

		return Transferencia.class;
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#getBo()
	 */
	@Override
	public TransferenciaBO getBo() {

		return this.bo;
	}

}
