package br.com.javagyn.bo;

import java.util.List;

import javax.ejb.EJB;

import br.com.javagyn.bo.base.AppBO;
import br.com.javagyn.dao.UsuarioDAO;
import br.com.javagyn.model.Usuario;

/**
 * <p>
 * <b>Title:</b> UsuarioBO
 * </p>
 * 
 * <p>
 * <b>Description:</b> UsuarioBO
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
public class UsuarioBO extends AppBO<Usuario> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo dao. */
	@EJB
	private UsuarioDAO dao;

	/**
	 * @see br.com.javagyn.bo.base.AppBO#getDao()
	 */
	@Override
	public UsuarioDAO getDao() {

		return this.dao;
	}

	/**
	 * Método responsável por verificar se registro já existe
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @return
	 */
	public Boolean verificarSeRegistroJaExiste(final Usuario usuario) {

		return this.getDao().verificarSeRegistroJaExiste(usuario);

	}

	/**
	 * Método responsável por verificar login so usuario
	 *
	 * @author Denis
	 *
	 * @param nomeUsuario
	 * @param senha
	 * @return
	 */
	public Usuario verificarLogin(String nomeUsuario, String senha) {

		return this.getDao().verificarLogin(nomeUsuario, senha);
	}

	/**
	 * Método responsável por obter lista de usuario
	 *
	 * @author Denis
	 *
	 * @return
	 */
	public List<Usuario> listagemUsuarios() {

		return this.getDao().listar();
	}

}
