package br.com.javagyn.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.form.ConfiguracoesForm;
import br.com.javagyn.service.ConfiguracoesService;

/**
 * <p>
 * <b>Title:</b> ConfiguracoesController
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfiguracoesController
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
public class ConfiguracoesController extends AppController {

	private static final String CONFIGURAÇÕES_SALVAS_COM_SUCESSO = "Configurações salvas com sucesso! As alterações serão validas após novo login no sistema!";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo configuracoesService. */
	@Inject
	private ConfiguracoesService configuracoesService;

	/** Atributo configuracoesForm. */
	@Inject
	private ConfiguracoesForm configuracoesForm;

	/**
	 * @see br.com.javagyn.controller.AppController#iniciarDados()
	 */
	@Override
	public void iniciarDados() {

		this.getConfiguracoesForm().setEntidade(

		this.getConfiguracoesService().obter());
	}

	/**
	 * Método responsável por salvar as configurações
	 * 
	 * @author Denis
	 * 
	 */
	public void salvar() {

		try {

			this.getConfiguracoesService().salvar(this.getConfiguracoesForm().getEntidade());

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());
		}

		AppController.messageInfo(ConfiguracoesController.CONFIGURAÇÕES_SALVAS_COM_SUCESSO);

	}

	/**
	 * Retorna o valor do atributo <code>configuracoesService</code>
	 * 
	 * @return <code>ConfiguracoesService</code>
	 */
	public ConfiguracoesService getConfiguracoesService() {

		return this.configuracoesService;
	}

	/**
	 * Retorna o valor do atributo <code>configuracoesForm</code>
	 * 
	 * @return <code>ConfiguracoesForm</code>
	 */
	public ConfiguracoesForm getConfiguracoesForm() {

		return this.configuracoesForm;
	}

}
