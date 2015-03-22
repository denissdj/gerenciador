package br.com.javagyn.bo.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import br.com.javagyn.dao.base.DAO;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> BO
 * </p>
 * 
 * <p>
 * <b>Description:</b> BO
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * @param <E>
 * 
 * @version 1.0.0
 */
public abstract class BO<E extends Entidade> {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	protected BO() {

		super();
	}

	/**
	 * Insere o objeto informado na entidade.
	 * 
	 * @param entidade
	 *            Objeto da a ser inserido.
	 * 
	 * @return Chave da entidade inserida na base de dados, podendo ser um objeto com mais de um atributo representando a chave
	 * 
	 * @throws ValidacaoException
	 */
	public Serializable inserir(final E entidade) {

		return this.getDao().inserir(entidade);
	}

	/**
	 * Atualiza o objeto informado na entidade.
	 * 
	 * @param entidade
	 *            Objeto a ser alterado.
	 * 
	 * @throws ValidacaoException
	 */
	public void alterar(final E entidade) {

		this.getDao().alterar(entidade);
	}

	/**
	 * Altera a entidade passada por parâmetro fazendo um "merge" com a entidade existente na sessão do Hibernate (caso exista).
	 * 
	 * @param entidade
	 *            Entidade a ser salva.
	 * 
	 * @throws ValidacaoException
	 */
	public void mesclar(final E entidade) {

		this.getDao().mesclar(entidade);
	}

	/**
	 * Remove as entidades informadas e retorna uma coleção de mensagens de erro das entidades que não poderem ser removidas.
	 * 
	 * @param entidades
	 *            Entidades a serem excluidas
	 * 
	 * @throws ValidacaoException
	 */
	public void removerTodos(final Collection<E> entidades) {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final Collection<E> removidas = new ArrayList();

		final Iterator<E> iterator = entidades.iterator();

		while (iterator.hasNext()) {

			final E entidade = iterator.next();

			try {

				this.remover(entidade);

				removidas.add(entidade);

			} catch (final Exception e) {

				continue;
			}
		}

		entidades.removeAll(removidas);
	}

	protected abstract DAO<E> getDao();

	/**
	 * Método responsável por obter uam entidade por id
	 * 
	 * @author Denis
	 * 
	 * @param identificador
	 * @return
	 */
	public E obter(final Serializable identificador) {

		final E entidade = this.getDao().obter(identificador);

		return entidade;

	}

	/**
	 * Método responsável por salvar uma entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @throws NegocioException
	 */
	public void salvar(final E entidade) throws NegocioException {

		this.getDao().salvar(entidade);

	}

	/**
	 * Método responsável por remover uma entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 */
	public void remover(final E entidade) {

		final E entity = this.obter(entidade.getIdentificador());

		this.getDao().remover(entity);
	}

	/**
	 * Método responsável por obter lista da entidade com filtro
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @return
	 */
	public Collection<E> consultar(final E entidade) {

		return this.getDao().consultar(entidade);
	}

	/**
	 * Método responsável por obter lista da entidade
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public Collection<E> listar() {

		return this.getDao().listar();
	}

	/**
	 * Método responsável por obter atualizações da entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 */
	public void refresh(final E entidade) {

		this.getDao().refresh(entidade);
	}

	/**
	 * Método responsável por retornar a descrição do identificado da entidade
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @return
	 */
	protected String getDescricao(final E entidade) {

		return entidade.getIdentificador().toString();
	}

}
