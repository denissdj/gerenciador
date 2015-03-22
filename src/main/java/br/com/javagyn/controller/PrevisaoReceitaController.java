package br.com.javagyn.controller;

import java.util.Arrays;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.javagyn.enuns.EnumSituacaoPrevisaoReceita;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.form.PrevisaoReceitaForm;
import br.com.javagyn.model.ConfirmarReceita;
import br.com.javagyn.model.PrevisaoReceita;
import br.com.javagyn.service.PrevisaoReceitaService;

/**
 * <p>
 * <b>Title:</b> PrevisaoReceitaController
 * </p>
 * 
 * <p>
 * <b>Description:</b> PrevisaoReceitaController
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
@Named
@RequestScoped
public class PrevisaoReceitaController extends AppController {

	/** Atributo ESTORNADA_COM_SUCESSO. */
	private static final String ESTORNADA_COM_SUCESSO = "Previsão de Receita Estornada com Sucesso!";

	/** Atributo EXCLUIDA_COM_SUCESSO. */
	private static final String EXCLUIDA_COM_SUCESSO = "Previsão de Receita Excluida com Sucesso!";

	/** Atributo CONFIRMADA_COM_SUCESSO. */
	private static final String CONFIRMADA_COM_SUCESSO = "Previsão de Receita confirmada com Sucesso!";

	/** Atributo SALVO_COM_SUCESSO. */
	private static final String SALVO_COM_SUCESSO = "Previsão de Receita salva com sucesso!";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo service. */
	@Inject
	private PrevisaoReceitaService service;

	/** Atributo formulario. */
	@Inject
	private PrevisaoReceitaForm formulario;

	/**
	 * @see br.com.javagyn.controller.AppController#iniciarDados()
	 */
	@Override
	public void iniciarDados() {

		this.getFormulario().setListaSituacao(Arrays.asList(EnumSituacaoPrevisaoReceita.values()));

		this.getFormulario().setSituacaoPrevisaoSelecionada(EnumSituacaoPrevisaoReceita.NAO_CONFIRMADA);

		this.getFormulario().getListagemPrevisaoReceita().getConsulta().setSituacao(EnumSituacaoPrevisaoReceita.NAO_CONFIRMADA);

		this.getFormulario().setEntidade(new PrevisaoReceita());

		this.getFormulario().setConfirmarReceita(new ConfirmarReceita());

		this.getFormulario().setListaContasFinanceiras(this.getService().obterListaContasFinanceiras(this.getUsuarioLogado()));

		this.getFormulario().getListagemPrevisaoReceita().getConsulta().setUsuario(this.getUsuarioLogado());
	}

	/**
	 * Método responsável por prepara cadastro
	 * 
	 * @author Denis
	 * 
	 */
	public void prepararCadastro() {

		if (this.getFormulario().getEntidade().getId() == null) {

			this.getFormulario().setEntidade(new PrevisaoReceita());
		}
	}

	/**
	 * Método responsável por pesquisar
	 * 
	 * @author Denis
	 * 
	 */
	public void pesquisar() {

		final EnumSituacaoPrevisaoReceita situacao = this.getFormulario().getSituacaoPrevisaoSelecionada();

		this.getFormulario().getListagemPrevisaoReceita().getConsulta().setSituacao(EnumSituacaoPrevisaoReceita.TODOS.equals(situacao) ? null : EnumSituacaoPrevisaoReceita.CONFIRMADA.equals(situacao) ? EnumSituacaoPrevisaoReceita.CONFIRMADA : EnumSituacaoPrevisaoReceita.NAO_CONFIRMADA);

	}

	/**
	 * Método responsável por salvar a conta financeira
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public String salvar() {

		try {

			this.getFormulario().getEntidade().setUsuario(this.getUsuarioLogado());

			this.getService().salvar(this.getFormulario().getEntidade());

			this.iniciarDados();

			AppController.messageInfo(PrevisaoReceitaController.SALVO_COM_SUCESSO);

			return "/paginas/previsao_receita/inicio";

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());

			return null;
		}
	}

	/**
	 * Método responsável por confirmar previsão selecionada
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public String confirmarPrevisaoReceita() {

		try {

			this.getFormulario().getConfirmarReceita().setPrevisaoReceita(this.getFormulario().getConsulta());

			this.getService().confirmarPrevisaoReceita(this.getFormulario().getConfirmarReceita());

			this.iniciarDados();

			AppController.messageInfo(PrevisaoReceitaController.CONFIRMADA_COM_SUCESSO);

			return "/paginas/previsao_receita/inicio";

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());

			return null;
		}

	}

	/**
	 * Método responsável por estornar previsao
	 * 
	 * @author Denis
	 * 
	 */
	public void cancelarConfirmacaoPrevisaoReceita() {

		try {

			this.getService().estornarPrevisaoReceita(this.getFormulario().getConsulta());

			this.iniciarDados();

			AppController.messageInfo(PrevisaoReceitaController.ESTORNADA_COM_SUCESSO);

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());

		}

	}

	/**
	 * Método responsável por excluir previsão
	 * 
	 * @author Denis
	 * 
	 */
	public void desativarPrevisao() {

		try {

			this.getService().desativarPrevisaoReceita(this.getFormulario().getConsulta());

			this.iniciarDados();

			AppController.messageInfo(PrevisaoReceitaController.EXCLUIDA_COM_SUCESSO);

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());

		}
	}

	/**
	 * Retorna o valor do atributo <code>service</code>
	 * 
	 * @return <code>PrevisaoReceitaService</code>
	 */
	public PrevisaoReceitaService getService() {

		return this.service;
	}

	/**
	 * Retorna o valor do atributo <code>formulario</code>
	 * 
	 * @return <code>PrevisaoReceitaForm</code>
	 */
	public PrevisaoReceitaForm getFormulario() {

		return this.formulario;
	}

}
