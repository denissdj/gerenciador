package br.com.javagyn.bo;

import javax.ejb.EJB;

import br.com.javagyn.bo.base.AppBO;
import br.com.javagyn.dao.ConfiguracoesDAO;
import br.com.javagyn.model.Configuracoes;

/**
 * <p>
 * <b>Title:</b> ConfiguracoesBO
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfiguracoesBO
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
public class ConfiguracoesBO extends AppBO<Configuracoes> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo dao. */
	@EJB
	private ConfiguracoesDAO dao;

	/**
	 * @see br.com.javagyn.bo.base.AppBO#getDao()
	 */
	@Override
	public ConfiguracoesDAO getDao() {

		return this.dao;
	}

}
