package br.com.javagyn.lazy;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.javagyn.bo.base.AppBO;
import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> AppLazy
 * </p>
 * 
 * <p>
 * <b>Description:</b> AppLazy
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
public abstract class AppLazy<E extends Entidade> extends LazyDataModel<E> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo consulta. */
	private E consulta;

	/**
	 * Método responsável por retornar o BO
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	protected abstract AppBO<E> getBo();

	/**
	 * Método responsável por retornar a classe do dto
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	protected abstract Class<E> getDtoClass();

	/**
	 * @see org.primefaces.model.LazyDataModel#load(int, int, java.lang.String, org.primefaces.model.SortOrder, java.util.Map)
	 */
	@Override
	public List<E> load(final int first, final int pageSize, final String sortField, final SortOrder sortOrder, final Map<String, Object> filters) {

		final Paginacao<E> page = this.getBo().listar(this.getConsulta(), pageSize, first, sortField, sortOrder, filters);

		this.setRowCount((int) page.getQuantidade());

		return page.getElementos();
	}

	/**
	 * Retorna o valor do atributo <code>consulta</code>
	 * 
	 * @return <code>E</code>
	 */
	public E getConsulta() {

		return this.consulta;
	}

	/**
	 * Define o valor do atributo <code>consulta</code>.
	 * 
	 * @param consulta
	 */
	public void setConsulta(final E consulta) {

		this.consulta = consulta;
	}

}
