package br.com.javagyn.bo;

import javax.ejb.EJB;

import br.com.javagyn.bo.base.AppBO;
import br.com.javagyn.dao.TransferenciaDAO;
import br.com.javagyn.model.Transferencia;

/**
 * <p>
 * <b>Title:</b> TransferenciaBO
 * </p>
 * 
 * <p>
 * <b>Description:</b> TransferenciaBO
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
public class TransferenciaBO extends AppBO<Transferencia> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo dao. */
	@EJB
	private TransferenciaDAO dao;

	/**
	 * @see br.com.javagyn.bo.base.AppBO#getDao()
	 */
	@Override
	public TransferenciaDAO getDao() {

		return this.dao;
	}

}
