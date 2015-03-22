package br.com.javagyn.form;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.javagyn.model.Usuario;
import br.com.javagyn.service.ConfiguracoesService;

/**
 * <p>
 * <b>Title:</b> EfetuarLoginForm
 * </p>
 * 
 * <p>
 * <b>Description:</b> EfetuarLoginForm
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
public class EfetuarLoginForm implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo logado. */
	private boolean logado = false;

	/** Atributo usuarioLogado. */
	private static Usuario usuarioLogado;

	/** Atributo nomeUsuario. */
	private String nomeUsuario;

	/** Atributo senha. */
	private String senha;

	/** Atributo tempoSessao. */
	private static Integer tempoSessao;

	/** Atributo configuracoesService. */
	@Inject
	private ConfiguracoesService configuracoesService;

	/**
	 * Método responsável por retornar o tempo da sessão do usuario
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public int getTempoSessao() {

		if (EfetuarLoginForm.tempoSessao == null) {

			this.obterTempoSessao();
		}

		return EfetuarLoginForm.tempoSessao;
	}

	/**
	 * Método responsável por obter o tempo da sessão do usuario
	 * 
	 * @author Denis
	 * 
	 */
	public void obterTempoSessao() {

		EfetuarLoginForm.setTempoSessao(this.getConfiguracoesService().getBo().getDao().obter(1L).getTempoSessao());
	}

	/**
	 * Retorna o valor do atributo <code>logado</code>
	 * 
	 * @return <code>boolean</code>
	 */
	public boolean isLogado() {

		return this.logado;
	}

	/**
	 * Define o valor do atributo <code>logado</code>.
	 * 
	 * @param logado
	 */
	public void setLogado(final boolean logado) {

		this.logado = logado;
	}

	/**
	 * Retorna o valor do atributo <code>usuarioLogado</code>
	 * 
	 * @return <code>Usuario</code>
	 */
	public Usuario getUsuarioLogado() {

		return EfetuarLoginForm.usuarioLogado;
	}

	/**
	 * Define o valor do atributo <code>usuarioLogado</code>.
	 * 
	 * @param usuarioLogado
	 */
	public void setUsuarioLogado(final Usuario usuarioLogado) {

		EfetuarLoginForm.usuarioLogado = usuarioLogado;
	}

	/**
	 * Retorna o valor do atributo <code>nomeUsuario</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getNomeUsuario() {

		return this.nomeUsuario;
	}

	/**
	 * Define o valor do atributo <code>nomeUsuario</code>.
	 * 
	 * @param nomeUsuario
	 */
	public void setNomeUsuario(final String nomeUsuario) {

		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * Retorna o valor do atributo <code>senha</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getSenha() {

		return this.senha;
	}

	/**
	 * Define o valor do atributo <code>senha</code>.
	 * 
	 * @param senha
	 */
	public void setSenha(final String senha) {

		this.senha = senha;
	}

	/**
	 * Define o valor do atributo <code>tempoSessao</code>.
	 * 
	 * @param tempoSessao
	 */
	public static void setTempoSessao(final Integer tempoSessao) {

		EfetuarLoginForm.tempoSessao = tempoSessao;
	}

	/**
	 * Retorna o valor do atributo <code>configuracoesService</code>
	 * 
	 * @return <code>ConfiguracoesService</code>
	 */
	public ConfiguracoesService getConfiguracoesService() {

		return this.configuracoesService;
	}

}
