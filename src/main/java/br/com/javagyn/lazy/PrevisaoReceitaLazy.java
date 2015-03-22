package br.com.javagyn.lazy;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import br.com.javagyn.bo.PrevisaoReceitaBO;
import br.com.javagyn.enuns.EnumStatusEntidade;
import br.com.javagyn.model.PrevisaoReceita;

/**
 * <p>
 * <b>Title:</b> PrevisaoReceitaLazy
 * </p>
 * 
 * <p>
 * <b>Description:</b> PrevisaoReceitaLazy
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
public class PrevisaoReceitaLazy extends AppLazy<PrevisaoReceita> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private PrevisaoReceitaBO bo;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public PrevisaoReceitaLazy() {

		this.setConsulta(new PrevisaoReceita());
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#load(int, int, java.lang.String, org.primefaces.model.SortOrder, java.util.Map)
	 */
	@Override
	public List<PrevisaoReceita> load(final int first, final int pageSize, final String sortField, final SortOrder sortOrder, final Map<String, Object> filters) {

		this.getConsulta().setStatusEntidade(EnumStatusEntidade.ATIVO);

		final Paginacao<PrevisaoReceita> page = this.getBo().listar(this.getConsulta(), pageSize, first, sortField, sortOrder, filters);

		this.setRowCount((int) page.getQuantidade());

		return page.getElementos();
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#getDtoClass()
	 */
	@Override
	protected Class<PrevisaoReceita> getDtoClass() {

		return PrevisaoReceita.class;
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#getBo()
	 */
	@Override
	public PrevisaoReceitaBO getBo() {

		return this.bo;
	}

}
