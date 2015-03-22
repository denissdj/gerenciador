package br.com.javagyn.lazy;

import javax.inject.Inject;

import br.com.javagyn.bo.UsuarioBO;
import br.com.javagyn.model.Usuario;

/**
 * <p>
 * <b>Title:</b> UsuarioLazy
 * </p>
 * 
 * <p>
 * <b>Description:</b> UsuarioLazy
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
public class UsuarioLazy extends AppLazy<Usuario> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private UsuarioBO bo;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public UsuarioLazy() {

		this.setConsulta(new Usuario());
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#getDtoClass()
	 */
	@Override
	protected Class<Usuario> getDtoClass() {

		return Usuario.class;
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#getBo()
	 */
	@Override
	public UsuarioBO getBo() {

		return this.bo;
	}

}
