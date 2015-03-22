package br.com.javagyn.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.javagyn.enuns.EnumStatusEntidade;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.form.UsuarioForm;
import br.com.javagyn.model.Usuario;
import br.com.javagyn.service.UsuarioService;

/**
 * <p>
 * <b>Title:</b> UsuarioController
 * </p>
 * 
 * <p>
 * <b>Description:</b> UsuarioController
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
@RequestScoped
public class UsuarioController extends AppController {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/** Atributo ATIVADO_COM_SUCESSO. */
	private static final String ATIVADO_COM_SUCESSO = "Usuário ativado com sucesso!";

	/** Atributo SALVO_COM_SUCESSO. */
	private static final String SALVO_COM_SUCESSO = "Usuário salvo com sucesso!";

	/** Atributo DESATIVADO_COM_SUCESSO. */
	private static final String DESATIVADO_COM_SUCESSO = "Usuário desativado com sucesso!";

	/** Atributo service. */
	@Inject
	private UsuarioService service;

	/** Atributo formulario. */
	@Inject
	private UsuarioForm formulario;

	/**
	 * @see br.com.javagyn.controller.AppController#iniciarDados()
	 */
	@Override
	public void iniciarDados() {

		this.getFormulario().setEntidade(new Usuario());

		this.getFormulario().getListagemUsuario().getConsulta().setStatusEntidade(EnumStatusEntidade.ATIVO);

		this.getFormulario().setSituacaoSelecionada("ATIVO");

	}

	/**
	 * Método responsável por preparar cadastro
	 * 
	 * @author Denis
	 * 
	 */
	public void prepararCadastro() {

		if (this.getFormulario().getEntidade().getId() == null) {

			this.getFormulario().setEntidade(new Usuario());
		}
	}

	/**
	 * Método responsável por abrir tela editar dados pessoais
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public String editarDadosPessoais() {

		this.getFormulario().setEntidade(this.getUsuarioLogado());

		final String tela = "/paginas/usuario/inserir?faces-redirect=true";

		return tela;
	}

	/**
	 * Método responsável por pesquisar
	 * 
	 * @author Denis
	 * 
	 */
	public void pesquisar() {

		final String status = this.getFormulario().getSituacaoSelecionada();

		this.getFormulario().getListagemUsuario().getConsulta().setStatusEntidade(status.equals("NULL") ? null : status.equals("ATIVO") ? EnumStatusEntidade.ATIVO : EnumStatusEntidade.INATIVO);

	}

	/**
	 * Método responsável por salvar o usuario
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public String salvar() {

		try {

			this.getService().salvar(this.getFormulario().getEntidade());

			this.getFormulario().setEntidade(new Usuario());

			AppController.messageInfo(UsuarioController.SALVO_COM_SUCESSO);

			if (this.getUsuarioLogado().isUserAdmin()) {

				return "/paginas/usuario/inicio";

			} else {

				this.getFormulario().setEntidade(this.getUsuarioLogado());

				return "/paginas/usuario/inserir2";
			}

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());

			return null;
		}
	}

	/**
	 * Método responsável por desativar o usuario
	 * 
	 * @author Denis
	 * 
	 */
	public void desativarUsuario() {

		try {

			this.getService().desativarUsuario(this.getFormulario().getConsulta());

			AppController.messageInfo(UsuarioController.DESATIVADO_COM_SUCESSO);

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());
		}

	}

	/**
	 * Método responsável por ativar o usuario
	 * 
	 * @author Denis
	 * 
	 */
	public void ativarUsuario() {

		try {

			this.getService().ativarUsuario(this.getFormulario().getConsulta());

			AppController.messageInfo(UsuarioController.ATIVADO_COM_SUCESSO);

		} catch (final NegocioException e) {

			AppController.messageError(e.getMessage());
		}

	}

	/**
	 * Retorna o valor do atributo <code>service</code>
	 * 
	 * @return <code>UsuarioService</code>
	 */
	public UsuarioService getService() {

		return this.service;
	}

	/**
	 * Retorna o valor do atributo <code>formulario</code>
	 * 
	 * @return <code>UsuarioForm</code>
	 */
	public UsuarioForm getFormulario() {

		return this.formulario;
	}

}
