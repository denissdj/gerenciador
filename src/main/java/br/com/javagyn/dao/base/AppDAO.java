package br.com.javagyn.dao.base;

import java.io.Serializable;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> AppDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> AppDAO
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * @param <T>
 * 
 * @version 1.0.0
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class AppDAO<T extends Entidade> extends HibernateDAO<T> implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo manager. */
	@PersistenceContext(unitName = "financeiro")
	private EntityManager manager;

	/**
	 * @see br.com.javagyn.dao.base.HibernateDAO#getManager()
	 */
	@Override
	public EntityManager getManager() {

		return this.manager;
	}

}
