package br.com.javagyn.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.javagyn.model.Usuario;

/**
 * <p>
 * <b>Title:</b> AppController
 * </p>
 * 
 * <p>
 * <b>Description:</b> AppController
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
public abstract class AppController implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo usuarioLogin. */
	@Inject
	private EfetuarLoginController usuarioLogin;

	/** Atributo dataAtual. */
	private Date dataAtual = new Date();

	/** Atributo formatoData. */
	private final String formatoData = "dd/MM/yyyy";

	/** Atributo timeZone. */
	private final String timeZone = "America/Sao_Paulo";

	/** Atributo formatoValorReal. */
	private final String formatoValorReal = "R$ ###,##0.00";

	/**
	 * Método responsável por iniciar os dados do controlador
	 * 
	 * @author Denis
	 * 
	 */
	public abstract void iniciarDados();

	/**
	 * Método responsável por retornar o usuario logado
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public Usuario getUsuarioLogado() {

		return this.getUsuarioLogin().getLoginForm().getUsuarioLogado();
	}
	
	/**
	 * Método responsável por definir uma messagem informativa
	 * 
	 * @author Denis
	 * 
	 * @param detalhe
	 */
	public static void messageInfo(final String detalhe) {

		AppController.addMessage(FacesMessage.SEVERITY_INFO, "Informação!", detalhe);
	}

	/**
	 * Método responsável por definir uma messagem de atenção
	 * 
	 * @author Denis
	 * 
	 * @param detalhe
	 */
	public static void messageWarn(final String detalhe) {

		AppController.addMessage(FacesMessage.SEVERITY_WARN, "Atenção!", detalhe);
	}

	/**
	 * Método responsável por definir uma messagem de erro
	 * 
	 * @author Denis
	 * 
	 * @param detalhe
	 */
	public static void messageError(final String detalhe) {

		AppController.addMessage(FacesMessage.SEVERITY_ERROR, "Erro!", detalhe);
	}

	/**
	 * Método responsável por definir uma messagem de erro fatal
	 * 
	 * @author Denis
	 * 
	 * @param detalhe
	 */
	public static void messageErrorFatal(final String detalhe) {

		AppController.addMessage(FacesMessage.SEVERITY_FATAL, "Erro Fatal!", detalhe);
	}

	/**
	 * Método responsável por definir uma mensagem
	 * 
	 * @author Denis
	 * 
	 * @param severity
	 * @param summary
	 * @param detalhe
	 */
	public static void addMessage(final FacesMessage.Severity severity, final String summary, final String detalhe) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detalhe));
	}

	/**
	 * Retorna o valor do atributo <code>dataAtual</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getDataAtual() {

		return this.dataAtual;
	}

	/**
	 * Define o valor do atributo <code>dataAtual</code>.
	 * 
	 * @param dataAtual
	 */
	public void setDataAtual(final Date dataAtual) {

		this.dataAtual = dataAtual;
	}

	/**
	 * Retorna o valor do atributo <code>formatoData</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getFormatoData() {

		return this.formatoData;
	}

	/**
	 * Retorna o valor do atributo <code>timeZone</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getTimeZone() {

		return this.timeZone;
	}

	/**
	 * Retorna o valor do atributo <code>usuarioLogin</code>
	 * 
	 * @return <code>EfetuarLoginController</code>
	 */
	public EfetuarLoginController getUsuarioLogin() {

		return this.usuarioLogin;
	}

	/**
	 * Retorna o valor do atributo <code>formatoValorReal</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getFormatoValorReal() {

		return this.formatoValorReal;
	}

}
