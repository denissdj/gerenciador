package br.com.javagyn.form;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.javagyn.form.base.Formulario;
import br.com.javagyn.lazy.ContaFinanceiraLazy;
import br.com.javagyn.model.ContaFinanceira;

/**
 * <p>
 * <b>Title:</b> ContaFinanceiraForm
 * </p>
 * 
 * <p>
 * <b>Description:</b> ContaFinanceiraForm
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
@SessionScoped
public class ContaFinanceiraForm extends Formulario<ContaFinanceira> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo listagemUsuario. */
	@Inject
	private ContaFinanceiraLazy listagemContaFinanceira;

	/**
	 * Retorna o valor do atributo <code>listagemContaFinanceira</code>
	 * 
	 * @return <code>ContaFinanceiraLazy</code>
	 */
	public ContaFinanceiraLazy getListagemContaFinanceira() {

		return this.listagemContaFinanceira;
	}

}
