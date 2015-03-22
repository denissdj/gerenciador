package br.com.javagyn.bo;

import javax.ejb.EJB;

import br.com.javagyn.bo.base.AppBO;
import br.com.javagyn.dao.ConfirmarReceitaDAO;
import br.com.javagyn.model.ConfirmarReceita;

/**
 * <p>
 * <b>Title:</b> ConfirmarReceitaBO
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfirmarReceitaBO
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
public class ConfirmarReceitaBO extends AppBO<ConfirmarReceita> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo dao. */
	@EJB
	private ConfirmarReceitaDAO dao;

	/**
	 * @see br.com.javagyn.bo.base.AppBO#getDao()
	 */
	@Override
	public ConfirmarReceitaDAO getDao() {

		return this.dao;
	}

	/**
	 * Método responsável por obter receita confirmada por id previsão
	 * 
	 * @author Denis
	 * 
	 * @param idPrevisaoReceita
	 * @return
	 */
	public ConfirmarReceita obterReceitaConfirmada(final Long idPrevisaoReceita) {

		return this.getDao().obterReceitaConfirmada(idPrevisaoReceita);
	}

}
