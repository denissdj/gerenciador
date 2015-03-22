package br.com.javagyn.bo;

import java.util.Collection;

import javax.ejb.EJB;

import br.com.javagyn.bo.base.AppBO;
import br.com.javagyn.dao.ContaFinanceiraDAO;
import br.com.javagyn.model.ContaFinanceira;
import br.com.javagyn.model.Usuario;

/**
 * <p>
 * <b>Title:</b> ContaFinanceiraBO
 * </p>
 * 
 * <p>
 * <b>Description:</b> ContaFinanceiraBO
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
public class ContaFinanceiraBO extends AppBO<ContaFinanceira> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo dao. */
	@EJB
	private ContaFinanceiraDAO dao;

	/**
	 * @see br.com.javagyn.bo.base.AppBO#getDao()
	 */
	@Override
	public ContaFinanceiraDAO getDao() {

		return this.dao;
	}

	/**
	 * Método responsável por listar Contas Financeiras por usuário
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @return
	 */
	public Collection<ContaFinanceira> listarPorUsuario(final Usuario usuario) {

		return this.getDao().listarPorUsuario(usuario);
	}

}
