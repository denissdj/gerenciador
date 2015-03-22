package br.com.javagyn.bo.base;

import java.io.Serializable;
import java.util.Map;

import org.primefaces.model.SortOrder;

import br.com.javagyn.dao.base.AppDAO;
import br.com.javagyn.lazy.Paginacao;
import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> AppBO
 * </p>
 * 
 * <p>
 * <b>Description:</b> AppBO
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
public abstract class AppBO<E extends Entidade> extends BO<E> implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * @see br.com.javagyn.bo.base.BO#getDao()
	 */
	@Override
	protected abstract AppDAO<E> getDao();

	/**
	 * Método responsável por retornar lista para pagina do Datatable Primefaces
	 * 
	 * @author Denis
	 * 
	 * @param consulta
	 * @param qtd
	 * @param page
	 * @param sortField
	 * @param sortOrder
	 * @param filters
	 * @return
	 */
	public Paginacao<E> listar(final E consulta, final int qtd, final int page, final String sortField, final SortOrder sortOrder, final Map<String, Object> filters) {

		return this.getDao().listar(consulta, qtd, page, sortField, sortOrder, filters);
	}

}
