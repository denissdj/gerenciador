package br.com.javagyn.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.javagyn.model.Usuario;
import br.com.javagyn.util.UtilMensagem;

public abstract class AppController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EfetuarLoginController usuarioLogin;

	private Date dataAtual = new Date();

	private final String formatoData = "dd/MM/yyyy";

	private final String timeZone = "America/Sao_Paulo";

	private final String formatoValorReal = "R$ ###,##0.00";

	public abstract void iniciarDados();

	public Usuario getUsuarioLogado() {
		return this.getUsuarioLogin().getLoginForm().getUsuarioLogado();
	}
	
	public static void messageInfo(final String detalhe) {
		AppController.addMessage(FacesMessage.SEVERITY_INFO, "Informação!", detalhe);
	}

	public static void messageWarn(final String detalhe) {
		AppController.addMessage(FacesMessage.SEVERITY_WARN, "Atenção!", detalhe);
	}

	public static void messageError(final String detalhe) {
		AppController.addMessage(FacesMessage.SEVERITY_ERROR, "Erro!", detalhe);
	}

	public static void messageErrorFatal(final String detalhe) {
		AppController.addMessage(FacesMessage.SEVERITY_FATAL, "Erro Fatal!", detalhe);
	}

	public static void addMessage(final FacesMessage.Severity severity, final String summary, final String detalhe) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detalhe));
	}
	
	public void abrirModalMensagemInfo(final String mensagem) {
		UtilMensagem.abrirModalMensagemInfo(mensagem);
	}

	public void abrirModalMensagemErro(final String mensagem) {
		UtilMensagem.abrirModalMensagemErro(mensagem);
	}

	public void abrirModalMensagemSuccess(final String mensagem) {
		UtilMensagem.abrirModalMensagemSuccess(mensagem);
	}
	
	public void abrirModalMensagemWarning(final String mensagem) {
		UtilMensagem.abrirModalMensagemWarning(mensagem);
	}

	public Date getDataAtual() {
		return this.dataAtual;
	}

	public String getFormatoData() {
		return this.formatoData;
	}

	public String getTimeZone() {
		return this.timeZone;
	}

	public EfetuarLoginController getUsuarioLogin() {
		return this.usuarioLogin;
	}

	public String getFormatoValorReal() {
		return this.formatoValorReal;
	}
}
