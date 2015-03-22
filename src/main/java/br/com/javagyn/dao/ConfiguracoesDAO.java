package br.com.javagyn.dao;

import javax.ejb.Stateless;

import br.com.javagyn.dao.base.AppDAO;
import br.com.javagyn.model.Configuracoes;

/**
 * <p>
 * <b>Title:</b> ConfiguracoesDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfiguracoesDAO
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
@Stateless
public class ConfiguracoesDAO extends AppDAO<Configuracoes> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;
	
}
