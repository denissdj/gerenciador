package br.com.javagyn.util;

import org.primefaces.context.RequestContext;

public class UtilMensagem {

	protected UtilMensagem() {
		super();
	}
	
	public static void abrirModalMensagemInfo(final String mensagem) {
		RequestContext.getCurrentInstance().execute("showMessageInfo('" + mensagem + "')");
	}

	public static void abrirModalMensagemErro(final String mensagem) {
		RequestContext.getCurrentInstance().execute("showMessageError('" + mensagem + "')");
	}

	public static void abrirModalMensagemSuccess(final String mensagem) {
		RequestContext.getCurrentInstance().execute("showMessageSucess('" + mensagem + "')");
	}
	
	public static void abrirModalMensagemWarning(final String mensagem) {
		RequestContext.getCurrentInstance().execute("showMessageWarning('" + mensagem + "')");
	}

	public static void abrirModalConfirmacao(final String identity) {
		RequestContext.getCurrentInstance().execute("PF('" + identity + "').show()");
	}
}
