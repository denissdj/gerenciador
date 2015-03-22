package br.com.javagyn.dao;

import javax.ejb.Stateless;

import br.com.javagyn.dao.base.AppDAO;
import br.com.javagyn.model.Transferencia;

/**
 * <p>
 * <b>Title:</b> TransferenciaDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> TransferenciaDAO
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
public class TransferenciaDAO extends AppDAO<Transferencia> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

}
