package br.com.javagyn.dao.base;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> DAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> DAO
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * @param <E>
 * 
 * @version 1.0.0
 */
public interface DAO<E extends Entidade> {

	/**
	 * Método responsável por obter entidade pelo identificador
	 * 
	 * @author Denis
	 * 
	 * @param identificador
	 * @return
	 */
	E obter(final Serializable identificador);

	/**
	 * Método responsável por retornar o manager
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	EntityManager getManager();

	/**
	 * Método responsável por retornar a sessão
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	Session getSession();

	/**
	 * Método responsável por inserir a entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @return
	 */
	Serializable inserir(final E entidade);

	/**
	 * Método responsável por alterar a entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 */
	void alterar(final E entidade);

	/**
	 * Método responsável por salvar a entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 */
	void salvar(final E entidade);

	/**
	 * Método responsável por mesclar a entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 */
	void mesclar(final E entidade);

	/**
	 * Método responsável por remover a entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 */
	void remover(final E entidade);

	/**
	 * Método responsável por remover uma lista de entidades
	 * 
	 * @author Denis
	 * 
	 * @param entidades
	 */
	void removerTodos(final Collection<E> entidades);

	/**
	 * Método responsável por retornar uma lista de entidades por consulta
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @return
	 */
	Collection<E> consultar(final E entidade);

	/**
	 * Método responsável por retornar uma lista de entidades
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	Collection<E> listar();

	/**
	 * Método responsável por realizar um refresh na entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 */
	void refresh(final E entidade);
}
