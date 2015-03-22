package br.com.javagyn.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.javagyn.bo.UsuarioBO;
import br.com.javagyn.model.Usuario;
import br.com.javagyn.util.CriptografiaSHA;

/**
 * <p>
 * <b>Title:</b> EfetuarLoginService
 * </p>
 * 
 * <p>
 * <b>Description:</b> EfetuarLoginService
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
public class EfetuarLoginService implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo usuarioBO. */
	@Inject
	private UsuarioBO usuarioBO;

	/**
	 * Método responsável por verificar login do usuario
	 * 
	 * @author Denis
	 * 
	 * @param nomeUsuario
	 * @param senha
	 * @return
	 */
	public Usuario verificarLogin(final String nomeUsuario, final String senha) {

		return this.getUsuarioBO().verificarLogin(nomeUsuario, this.criptografarSenha(senha));
	}

	/**
	 * Método responsável por criptografar a senha do usuario
	 * 
	 * @author Denis
	 * 
	 * @param senha
	 * @return
	 */
	public String criptografarSenha(final String senha) {

		return CriptografiaSHA.senhaCriptografada(senha);
	}

	/**
	 * Retorna o valor do atributo <code>usuarioBO</code>
	 * 
	 * @return <code>UsuarioBO</code>
	 */
	public UsuarioBO getUsuarioBO() {

		return this.usuarioBO;
	}

}
