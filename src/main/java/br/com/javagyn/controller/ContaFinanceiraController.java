package br.com.javagyn.controller;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.javagyn.enuns.EnumStatusEntidade;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.form.ContaFinanceiraForm;
import br.com.javagyn.model.ContaFinanceira;
import br.com.javagyn.service.ContaFinanceiraService;

/**
 * <p>
 * <b>Title:</b> ContaFinanceiraController
 * </p>
 * 
 * <p>
 * <b>Description:</b> ContaFinanceiraController
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
public class ContaFinanceiraController extends AppController {

	/** Atributo ATIVADO_COM_SUCESSO. */
	private static final String ATIVADO_COM_SUCESSO = "Conta Financeira ativada com sucesso!";

	/** Atributo SALVO_COM_SUCESSO. */
	private static final String SALVO_COM_SUCESSO = "Conta Financeira salva com sucesso!";

	/** Atributo DESATIVADO_COM_SUCESSO. */
	private static final String DESATIVADO_COM_SUCESSO = "Conta Financeira desativada com sucesso!";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo service. */
	@Inject
	private ContaFinanceiraService service;

	/** Atributo formulario. */
	@Inject
	private ContaFinanceiraForm formulario;

	/**
	 * @see br.com.javagyn.controller.AppController#iniciarDados()
	 */
	@Override
	public void iniciarDados() {

		this.getFormulario().setEntidade(new ContaFinanceira());
		
		this.getFormulario().getListagemContaFinanceira().getConsulta().setUsuario(getUsuarioLogado());
		
		this.getFormulario().getListagemContaFinanceira().getConsulta().setStatusEntidade(EnumStatusEntidade.ATIVO);
		
		this.getFormulario().setSituacaoSelecionada("ATIVO");
	}
	
	/**
	 * Método responsável por obter lista de contas financeiras do usuario logado
	 *
	 * @author Denis
	 *
	 * @return
	 */
	public Collection<ContaFinanceira> listaContaFinanceiraUserLogado(){
		
		Collection<ContaFinanceira> listaConta = this.getService().listarPorUsuario(getUsuarioLogado());
		
		return listaConta;
	}
	
	/**
	 * Método responsável por retornar o saldo total das contas do usuario logado
	 *
	 * @author Denis
	 *
	 * @return
	 */
	public Double totalSaldoUsuarioLogado(){
		
		Collection<ContaFinanceira> listaConta = this.getService().listarPorUsuario(getUsuarioLogado());
		
		Double saldoTotal = 0.0;
		
		for (ContaFinanceira contaFinanceira : listaConta) {
			
			saldoTotal = saldoTotal + contaFinanceira.getSaldo().doubleValue();
		}

		return saldoTotal;
	}

	/**
	 * Método responsável por prepara cadastro
	 * 
	 * @author Denis
	 * 
	 */
	public void prepararCadastro() {

		if (this.getFormulario().getEntidade().getId() == null) {

			this.getFormulario().setEntidade(new ContaFinanceira());
		}
	}

	/**
	 * Método responsável por pesquisar
	 * 
	 * @author Denis
	 * 
	 */
	public void pesquisar() {

		final String status = this.getFormulario().getSituacaoSelecionada();

		this.getFormulario().getListagemContaFinanceira().getConsulta().setStatusEntidade(status.equals("NULL") ? null : status.equals("ATIVO") ? EnumStatusEntidade.ATIVO : EnumStatusEntidade.INATIVO);

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

			this.getFormulario().setEntidade(new ContaFinanceira());

			AppController.messageInfo(ContaFinanceiraController.SALVO_COM_SUCESSO);

			return "/paginas/conta_financeira/inicio";

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());

			return null;
		}
	}

	/**
	 * Método responsável por desativar a conta financeira
	 * 
	 * @author Denis
	 * 
	 */
	public void desativarContaFinanceira() {

		try {

			this.getService().desativarContaFinanceira(this.getFormulario().getConsulta());

			AppController.messageInfo(ContaFinanceiraController.DESATIVADO_COM_SUCESSO);

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());
		}
	}

	/**
	 * Método responsável por ativar a conta financeira
	 * 
	 * @author Denis
	 * 
	 */
	public void ativarContaFinanceira() {

		try {

			this.getService().ativarContaFinanceira(this.getFormulario().getConsulta());

			AppController.messageInfo(ContaFinanceiraController.ATIVADO_COM_SUCESSO);

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());
		}
	}

	/**
	 * Retorna o valor do atributo <code>service</code>
	 * 
	 * @return <code>ContaFinanceiraService</code>
	 */
	public ContaFinanceiraService getService() {

		return this.service;
	}

	/**
	 * Retorna o valor do atributo <code>formulario</code>
	 * 
	 * @return <code>ContaFinanceiraForm</code>
	 */
	public ContaFinanceiraForm getFormulario() {

		return this.formulario;
	}

}
