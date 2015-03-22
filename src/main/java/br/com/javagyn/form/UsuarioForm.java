package br.com.javagyn.form;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.javagyn.form.base.Formulario;
import br.com.javagyn.lazy.UsuarioLazy;
import br.com.javagyn.model.Usuario;

/**
 * <p>
 * <b>Title:</b> UsuarioForm
 * </p>
 * 
 * <p>
 * <b>Description:</b> UsuarioForm
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
public class UsuarioForm extends Formulario<Usuario> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo listagemUsuario. */
	@Inject
	private UsuarioLazy listagemUsuario;

	/**
	 * Retorna o valor do atributo <code>listagemUsuario</code>
	 * 
	 * @return <code>UsuarioLazy</code>
	 */
	public UsuarioLazy getListagemUsuario() {

		return this.listagemUsuario;
	}

}
