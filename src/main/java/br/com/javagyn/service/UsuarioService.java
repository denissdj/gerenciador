package br.com.javagyn.service;

import java.util.List;

import javax.inject.Inject;

import br.com.javagyn.bo.UsuarioBO;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.model.Usuario;
import br.com.javagyn.service.base.AppService;
import br.com.javagyn.util.CriptografiaSHA;

/**
 * <p>
 * <b>Title:</b> UsuarioService
 * </p>
 * 
 * <p>
 * <b>Description:</b> UsuarioService
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
public class UsuarioService extends AppService<Usuario, UsuarioBO> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private UsuarioBO bo;

	/**
	 * Método responsável por obter lista de usuarios
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public List<Usuario> listagemUsuarios() {

		return this.getBo().listagemUsuarios();
	}

	/**
	 * Método responsável por criptografar senha do usuario
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
	 * @see br.com.javagyn.service.base.Service#salvar(br.com.javagyn.model.base.Entidade)
	 */
	@Override
	public void salvar(final Usuario usuario) throws NegocioException {

		if (this.validar(usuario)) {

			throw new NegocioException("Registro Já Existe!");
		}

		usuario.setSenha(this.criptografarSenha(usuario.getSenha()));

		this.getBo().salvar(usuario);
	}

	/**
	 * Método responsável por verificar se usuario já existe
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @return
	 */
	private Boolean validar(final Usuario usuario) {

		return this.getBo().verificarSeRegistroJaExiste(usuario);
	}

	/**
	 * Método responsável por desativar entidade
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @throws NegocioException
	 */
	public void desativarUsuario(Usuario usuario) throws NegocioException {

		usuario = this.getBo().getDao().obter(usuario.getId());

		this.desativar(usuario);
	}

	/**
	 * Método responsável por ativar entidade
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @throws NegocioException
	 */
	public void ativarUsuario(Usuario usuario) throws NegocioException {

		usuario = this.getBo().getDao().obter(usuario.getId());

		this.ativar(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.javagyn.service.Service#getBo()
	 */
	@Override
	public UsuarioBO getBo() {

		return this.bo;
	}

}
