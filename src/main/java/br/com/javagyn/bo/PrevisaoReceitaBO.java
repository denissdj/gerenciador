package br.com.javagyn.bo;

import javax.ejb.EJB;

import br.com.javagyn.bo.base.AppBO;
import br.com.javagyn.dao.PrevisaoReceitaDAO;
import br.com.javagyn.model.PrevisaoReceita;

/**
 * <p>
 * <b>Title:</b> PrevisaoReceitaBO
 * </p>
 * 
 * <p>
 * <b>Description:</b> PrevisaoReceitaBO
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
public class PrevisaoReceitaBO extends AppBO<PrevisaoReceita> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo dao. */
	@EJB
	private PrevisaoReceitaDAO dao;

	/**
	 * @see br.com.javagyn.bo.base.AppBO#getDao()
	 */
	@Override
	public PrevisaoReceitaDAO getDao() {

		return this.dao;
	}

}
