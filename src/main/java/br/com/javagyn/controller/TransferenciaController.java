package br.com.javagyn.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.javagyn.enuns.EnumStatusEntidade;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.form.TransferenciaForm;
import br.com.javagyn.model.Transferencia;
import br.com.javagyn.service.TransferenciaService;

/**
 * <p>
 * <b>Title:</b> TransferenciaController
 * </p>
 * 
 * <p>
 * <b>Description:</b> TransferenciaController
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
public class TransferenciaController extends AppController {

	/** Atributo SALVO_COM_SUCESSO. */
	private static final String EFETUADA_COM_SUCESSO = "Transferência efetuada com sucesso!";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo service. */
	@Inject
	private TransferenciaService service;

	/** Atributo formulario. */
	@Inject
	private TransferenciaForm formulario;

	/**
	 * @see br.com.javagyn.controller.AppController#iniciarDados()
	 */
	@Override
	public void iniciarDados() {

		this.getFormulario().setEntidade(new Transferencia());

		this.getFormulario().setListaContasFinanceiras(this.getService().obterListaContasFinanceiras(this.getUsuarioLogado()));

	}

	/**
	 * Método responsável por pesquisar
	 * 
	 * @author Denis
	 * 
	 */
	public void pesquisar() {

		final String status = this.getFormulario().getSituacaoSelecionada();

		this.getFormulario().getListagemTransferencia().getConsulta().setStatusEntidade(status.equals("NULL") ? null : status.equals("ATIVO") ? EnumStatusEntidade.ATIVO : EnumStatusEntidade.INATIVO);

	}

	/**
	 * Método responsável por efetuar a transferencia
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public void efetuarTransferencia() {

		try {

			this.getService().efetuarTransferencia(this.getFormulario().getEntidade());

			AppController.messageInfo(TransferenciaController.EFETUADA_COM_SUCESSO);

			this.iniciarDados();

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());

		}

	}

	/**
	 * Retorna o valor do atributo <code>service</code>
	 * 
	 * @return <code>TransferenciaService</code>
	 */
	public TransferenciaService getService() {

		return this.service;
	}

	/**
	 * Retorna o valor do atributo <code>formulario</code>
	 * 
	 * @return <code>TransferenciaForm</code>
	 */
	public TransferenciaForm getFormulario() {

		return this.formulario;
	}

}
