package br.com.javagyn.form;

import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.javagyn.form.base.Formulario;
import br.com.javagyn.lazy.TransferenciaLazy;
import br.com.javagyn.model.ContaFinanceira;
import br.com.javagyn.model.Transferencia;

/**
 * <p>
 * <b>Title:</b> TransferenciaForm
 * </p>
 * 
 * <p>
 * <b>Description:</b> TransferenciaForm
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
public class TransferenciaForm extends Formulario<Transferencia> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo listagemUsuario. */
	@Inject
	private TransferenciaLazy listagemTransferencia;

	/** Atributo listaContasFinanceiras. */
	private Collection<ContaFinanceira> listaContasFinanceiras;

	/**
	 * Retorna o valor do atributo <code>listagemTransferencia</code>
	 * 
	 * @return <code>TransferenciaLazy</code>
	 */
	public TransferenciaLazy getListagemTransferencia() {

		return this.listagemTransferencia;
	}

	/**
	 * Retorna o valor do atributo <code>listaContasFinanceiras</code>
	 * 
	 * @return <code>Collection<ContaFinanceira></code>
	 */
	public Collection<ContaFinanceira> getListaContasFinanceiras() {

		return this.listaContasFinanceiras;
	}

	/**
	 * Define o valor do atributo <code>listaContasFinanceiras</code>.
	 * 
	 * @param listaContasFinanceiras
	 */
	public void setListaContasFinanceiras(final Collection<ContaFinanceira> listaContasFinanceiras) {

		this.listaContasFinanceiras = listaContasFinanceiras;
	}

}
