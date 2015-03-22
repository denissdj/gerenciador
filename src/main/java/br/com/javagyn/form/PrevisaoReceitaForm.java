package br.com.javagyn.form;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.javagyn.enuns.EnumSituacaoPrevisaoReceita;
import br.com.javagyn.form.base.Formulario;
import br.com.javagyn.lazy.PrevisaoReceitaLazy;
import br.com.javagyn.model.ConfirmarReceita;
import br.com.javagyn.model.ContaFinanceira;
import br.com.javagyn.model.PrevisaoReceita;

/**
 * <p>
 * <b>Title:</b> PrevisaoReceitaForm
 * </p>
 * 
 * <p>
 * <b>Description:</b> PrevisaoReceitaForm
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
public class PrevisaoReceitaForm extends Formulario<PrevisaoReceita> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo listagemPrevisaoReceita. */
	@Inject
	private PrevisaoReceitaLazy listagemPrevisaoReceita;

	/** Atributo listaSituacao. */
	private List<EnumSituacaoPrevisaoReceita> listaSituacao;

	/** Atributo situacaoPrevisaoSelecionada. */
	private EnumSituacaoPrevisaoReceita situacaoPrevisaoSelecionada;

	/** Atributo confirmarReceita. */
	private ConfirmarReceita confirmarReceita;

	/** Atributo listaContasFinanceiras. */
	private Collection<ContaFinanceira> listaContasFinanceiras;

	/**
	 * Retorna o valor do atributo <code>listagemPrevisaoReceita</code>
	 * 
	 * @return <code>PrevisaoReceitaLazy</code>
	 */
	public PrevisaoReceitaLazy getListagemPrevisaoReceita() {

		return this.listagemPrevisaoReceita;
	}

	/**
	 * Retorna o valor do atributo <code>listaSituacao</code>
	 * 
	 * @return <code>List<EnumSituacaoPrevisaoReceita></code>
	 */
	public List<EnumSituacaoPrevisaoReceita> getListaSituacao() {

		return this.listaSituacao;
	}

	/**
	 * Define o valor do atributo <code>listaSituacao</code>.
	 * 
	 * @param listaSituacao
	 */
	public void setListaSituacao(final List<EnumSituacaoPrevisaoReceita> listaSituacao) {

		this.listaSituacao = listaSituacao;
	}

	/**
	 * Retorna o valor do atributo <code>situacaoPrevisaoSelecionada</code>
	 * 
	 * @return <code>EnumSituacaoPrevisaoReceita</code>
	 */
	public EnumSituacaoPrevisaoReceita getSituacaoPrevisaoSelecionada() {

		return this.situacaoPrevisaoSelecionada;
	}

	/**
	 * Define o valor do atributo <code>situacaoPrevisaoSelecionada</code>.
	 * 
	 * @param situacaoPrevisaoSelecionada
	 */
	public void setSituacaoPrevisaoSelecionada(final EnumSituacaoPrevisaoReceita situacaoPrevisaoSelecionada) {

		this.situacaoPrevisaoSelecionada = situacaoPrevisaoSelecionada;
	}

	/**
	 * Retorna o valor do atributo <code>confirmarReceita</code>
	 * 
	 * @return <code>ConfirmarReceita</code>
	 */
	public ConfirmarReceita getConfirmarReceita() {

		return this.confirmarReceita;
	}

	/**
	 * Define o valor do atributo <code>confirmarReceita</code>.
	 * 
	 * @param confirmarReceita
	 */
	public void setConfirmarReceita(final ConfirmarReceita confirmarReceita) {

		this.confirmarReceita = confirmarReceita;
	}

	/**
	 * Retorna o valor do atributo <code>listaContasFinanceiras</code>
	 * 
	 * @return <code>List<ContaFinanceira></code>
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
