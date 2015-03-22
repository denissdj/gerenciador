package br.com.javagyn.service.base;

import java.io.Serializable;
import java.util.Collection;

import br.com.javagyn.bo.base.BO;
import br.com.javagyn.enuns.EnumStatusEntidade;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> Service
 * </p>
 * 
 * <p>
 * <b>Description:</b> Service
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * @param <E>
 * @param <B>
 * 
 * @version 1.0.0
 */
public abstract class Service<E extends Entidade, B extends BO<E>> {

	/**
	 * @return O BO que será utilizado nas operações de manutenção
	 */
	protected abstract B getBo();

	/**
	 * Insere a entidade passada por parâmetro.
	 * 
	 * @param entidade
	 *            Entidade inserida.
	 * 
	 * @return chave da mensagem de sucesso da operação.
	 */
	public void inserir(final E entidade) {

		this.getBo().inserir(entidade);

	}

	/**
	 * Altera a entidade solicitada.
	 * 
	 * @param entidade
	 *            Entidade alterada.
	 * 
	 * @return chave da mensagem de sucesso da operação.
	 */
	public void alterar(final E entidade) {

		this.getBo().alterar(entidade);

	}

	/**
	 * Salva a entidade passada por parâmetro.
	 * 
	 * @param entidade
	 *            Entidade a ser salva.
	 * 
	 * @return chave da mensagem de sucesso da operação.
	 * @throws NegocioException
	 */
	public void salvar(final E entidade) throws NegocioException {

		this.getBo().salvar(entidade);

	}

	/**
	 * Método responsável por ativar o status da entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @throws NegocioException
	 */
	public void ativar(final E entidade) throws NegocioException {

		entidade.setStatusEntidade(EnumStatusEntidade.ATIVO);

		this.salvar(entidade);

	}

	/**
	 * Método responsável por desativar o status da entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @throws NegocioException
	 */
	public void desativar(final E entidade) throws NegocioException {

		entidade.setStatusEntidade(EnumStatusEntidade.INATIVO);

		this.salvar(entidade);

	}

	/**
	 * Altera a entidade passada por parâmetro fazendo um "merge" com a entidade existente.
	 * 
	 * @param entidade
	 *            Entidade a ser salva.
	 * 
	 * @return chave da mensagem de sucesso da operação.
	 */
	public void mesclar(final E entidade) {

		this.getBo().mesclar(entidade);

	}

	/**
	 * Remove a entidade passada por parâmetro.
	 * 
	 * @param entidade
	 *            Entidade que será removida.
	 * 
	 * @return chave da mensagem de sucesso da operação.
	 */
	public void remover(final E entidade) {

		this.getBo().remover(entidade);

	}

	/**
	 * Remove todas as entidades da coleção.
	 * 
	 * @param entidades
	 *            Coleção de entidade
	 * 
	 * @return chave da mensagem de sucesso da operação.
	 */
	public void removerTodos(final Collection<E> entidades) {

		this.getBo().removerTodos(entidades);

	}

	/**
	 * Retorna a entidade solicitada.
	 * 
	 * @param identificador
	 *            Identificador da entidade.
	 * @return entidade
	 */
	public E obter(final Serializable identificador) {

		return this.getBo().obter(identificador);
	}

	/**
	 * Consulta as entidades que satisfaçam os parâmetros enviados.
	 * 
	 * @param entidade
	 *            Entidade contendo os parâmetros que servirão de critério de consulta.
	 * @return coleção de entidades
	 */
	public Collection<E> consultar(final E entidade) {

		return this.getBo().consultar(entidade);
	}

	/**
	 * Lista todas as entidades.
	 * 
	 * @return coleção de entidades
	 */
	public Collection<E> listar() {

		return this.getBo().listar();
	}

	/**
	 * Sincroniza entidade com a base de dados.
	 * 
	 * @param entidade
	 *            Entidade que será atualizada.
	 */
	public void refresh(final E entidade) {

		this.getBo().refresh(entidade);
	}

}
