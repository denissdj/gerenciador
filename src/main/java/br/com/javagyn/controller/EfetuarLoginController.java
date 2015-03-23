package br.com.javagyn.controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.com.javagyn.form.EfetuarLoginForm;
import br.com.javagyn.service.EfetuarLoginService;

/**
 * <p>
 * <b>Title:</b> EfetuarLoginController
 * </p>
 * 
 * <p>
 * <b>Description:</b> EfetuarLoginController
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
@SessionScoped
public class EfetuarLoginController extends AppController {

	private static final String USUÁRIO_SENHA_INVALIDOS = "Usuário/senha inválidos!";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(EfetuarLoginController.class);

	/** Atributo loginService. */
	@Inject
	private EfetuarLoginService loginService;

	/** Atributo loginForm. */
	@Inject
	private EfetuarLoginForm loginForm;

	/**
	 * Método responsável por efetuar login
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public String login() {

		if (this.verificarLogin()) {

			return "/paginas/principal?faces-redirect=true";

		} else {

			//AppController.messageError(EfetuarLoginController.USUÁRIO_SENHA_INVALIDOS);
			
			this.abrirModalMensagemWarning(EfetuarLoginController.USUÁRIO_SENHA_INVALIDOS);
		}

		return null;
	}

	/**
	 * Método responsável por verificar login
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public boolean verificarLogin() {

		this.getLoginForm().setUsuarioLogado(

		this.getLoginService().verificarLogin(this.getLoginForm().getNomeUsuario(), this.getLoginForm().getSenha()));

		if (this.getLoginForm().getUsuarioLogado() != null) {

			// variável támbem utilizada pelo filtro para permitir a utilização do sistema

			( (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false) ).setAttribute("logado", Boolean.TRUE);

			this.getLoginForm().setLogado(true);

			EfetuarLoginController.LOGGER.info(this.getLoginForm().getUsuarioLogado());
		}

		return this.getLoginForm().isLogado();
	}

	/**
	 * Método responsável por efetuar logout
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public String logout() {

		//this.setTempoSessao(null);
		
		this.getLoginForm().setTempoSessao(null);

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/home?faces-redirect=true";
	}

	/**
	 * @see br.com.javagyn.controller.AppController#iniciarDados()
	 */
	@Override
	public void iniciarDados() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	/**
	 * Retorna o valor do atributo <code>loginService</code>
	 * 
	 * @return <code>EfetuarLoginService</code>
	 */
	public EfetuarLoginService getLoginService() {

		return this.loginService;
	}

	/**
	 * Retorna o valor do atributo <code>loginForm</code>
	 * 
	 * @return <code>EfetuarLoginForm</code>
	 */
	public EfetuarLoginForm getLoginForm() {

		return this.loginForm;
	}

}
