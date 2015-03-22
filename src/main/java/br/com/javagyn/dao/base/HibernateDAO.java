package br.com.javagyn.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;

import br.com.javagyn.lazy.Paginacao;
import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> HibernateDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> HibernateDAO
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * @param <T>
 * 
 * @version 1.0.0
 */
@SuppressWarnings({ "unchecked" })
public abstract class HibernateDAO<T extends Entidade> implements DAO<T> {

	/**
	 * @see br.com.javagyn.dao.base.DAO#getManager()
	 */
	@Override
	public abstract EntityManager getManager();

	/**
	 * @see br.com.javagyn.dao.base.DAO#getSession()
	 */
	@Override
	public Session getSession() {

		return (Session) this.getManager().getDelegate();
	}

	/**
	 * Método responsável por retornar a Classe persistente
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	private Class<?> getTypeClass() {

		return (Class<?>) ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
	}

	/**
	 * @see br.com.javagyn.dao.base.DAO#obter(java.io.Serializable)
	 */
	@Override
	public T obter(final Serializable id) {

		T resultado = null;
		
		if (id != null) {
			
			final Class<T> tipo = (Class<T>) this.getTypeClass();
			
			resultado = (T) this.getSession().get(tipo, id);
		}
		
		return resultado;
	}

	/**
	 * @see br.com.javagyn.dao.base.DAO#listar()
	 */
	@Override
	public List<T> listar() {

		final Criteria criteria = this.novaCriteria();
		
		criteria.addOrder(Order.asc("id"));
		
		return criteria.list();
	}
	
	/**
	 * @see br.com.javagyn.dao.base.DAO#salvar(br.com.javagyn.model.base.Entidade)
	 */
	@Override
	public void salvar(final T entidade) {

		if (entidade != null) {
			
			this.getSession().saveOrUpdate(entidade);
			
			this.getSession().flush();
		}
	}

	/**
	 * @see br.com.javagyn.dao.base.DAO#inserir(br.com.javagyn.model.base.Entidade)
	 */
	@Override
	public Serializable inserir(final T entidade) {

		Serializable resultado = null;
		
		if (entidade != null) {
			
			resultado = this.getSession().save(entidade);
			
			this.getSession().flush();
		}
		
		return resultado;
	}

	/**
	 * @see br.com.javagyn.dao.base.DAO#alterar(br.com.javagyn.model.base.Entidade)
	 */
	@Override
	public void alterar(final T entidade) {

		if (entidade != null) {
			
			this.getSession().update(entidade);
			
			this.getSession().flush();
		}
	}

	/**
	 * @see br.com.javagyn.dao.base.DAO#mesclar(br.com.javagyn.model.base.Entidade)
	 */
	@Override
	public void mesclar(final T entidade) {

		if (entidade != null) {
			
			this.getSession().merge(entidade);
			
			this.getSession().flush();
		}
	}

	/**
	 * @see br.com.javagyn.dao.base.DAO#removerTodos(java.util.Collection)
	 */
	@Override
	public void removerTodos(final Collection<T> entidades) {

		if (entidades != null) {
			
			for (final T entidade : entidades) {
				
				this.remover(entidade);
			}
		}
	}

	/**
	 * @see br.com.javagyn.dao.base.DAO#remover(br.com.javagyn.model.base.Entidade)
	 */
	@Override
	public void remover(final T entidade) {

		if (entidade != null) {
			
			this.carregarEntidadePersistente(entidade);
			
			this.getSession().delete(entidade);
			
			this.getSession().flush();
		}
	}

	/**
	 * Efetua o load da entidade caso esta não seja uma entidade persistente.
	 * 
	 * @param entidade
	 *            Entidade que será carregada como persistente.
	 */
	protected void carregarEntidadePersistente(final T entidade) {

		if (entidade != null && !this.isPersistente(entidade)) {
			
			final Serializable id = entidade.getIdentificador();
			
			this.getSession().load(entidade, id);
		}
	}

	/**
	 * Retorna true se a entidade for persistente.
	 * 
	 * @param entidade
	 *            Entidade validada.
	 * 
	 * @return true se a entidade for persistente.
	 */
	protected boolean isPersistente(final T entidade) {

		return ( this.getSession().contains(entidade) );
	}

	/**
	* @see br.com.javagyn.dao.base.DAO#consultar(br.com.javagyn.model.base.Entidade)
	*/
	@Override
	public Collection<T> consultar(final T entidade) {

		final Criteria criteria = this.novaCriteria();

		if (entidade != null) {
			
			final Example example = Example.create(entidade);
			
			example.enableLike(MatchMode.START);
			
			example.excludeZeroes();
			
			criteria.add(example);
		}
		
		return this.consultar(criteria);
	}

	/**
	 * Método responsável por retornar lista
	 *
	 * @author Denis
	 *
	 * @param criteria
	 * @return
	 */
	protected Collection<T> consultar(final Criteria criteria) {

		final Collection<T> colecao = criteria.list();
		
		return colecao;
	}

	/**
	* @see br.com.javagyn.dao.base.DAO#refresh(br.com.javagyn.model.base.Entidade)
	*/
	@Override
	public void refresh(final T entidade) {

		this.getManager().refresh(entidade);
	}

	/**
	 * Método responsável por criar nova criteria
	 *
	 * @author Denis
	 *
	 * @return
	 */
	public Criteria novaCriteria() {

		return this.getSession().createCriteria(this.getTypeClass());
	}

	/**
	 * Método responsável por criar nova Query
	 *
	 * @author Denis
	 *
	 * @param hql
	 * @return
	 */
	protected Query novaQuery(final String hql) {

		return this.getSession().createQuery(hql);
	}

	/**
	 * Método responsável por obter uma entidade por id
	 *
	 * @author Denis
	 *
	 * @param entidade
	 * @return
	 */
	protected T obter(final T entidade) {

		T resultado = null;
		
		if (entidade != null) {
			
			resultado = this.obter(entidade.getIdentificador());
		}
		
		return resultado;
	}

	/**
	 * Método responsável por remover uma entidade pelo id
	 *
	 * @author Denis
	 *
	 * @param id
	 */
	protected void remover(final Serializable id) {

		if (id != null) {
			
			final T entidade = this.obter(id);
			
			this.remover(entidade);
		}
	}

	/**
	 * Método responsável por criar criteria adicionando os filtros da consulta
	 * 
	 * @author Denis
	 * 
	 * @param consulta
	 * @param filters
	 * @return
	 */
	protected Criteria criarCriteriaParaConsulta(final T consulta, final Map<String, Object> filters) {

		final Criteria criteria = this.novaCriteria();

		for (final Entry<String, Object> filtro : filters.entrySet()) {

			final String propriedade = filtro.getKey();

			final String valor = (String) filtro.getValue();

			criteria.add(Restrictions.ilike(propriedade, valor, MatchMode.ANYWHERE));

		}

		if (consulta != null && consulta.getStatusEntidade() != null) {

			criteria.add(Restrictions.eq("statusEntidade", consulta.getStatusEntidade()));

		}

		return criteria;

	}

	/**
	 * Método responsável por retornar a quantidade de registros filtrados
	 * 
	 * @author Denis
	 * 
	 * @param consulta
	 * @param filters
	 * @return
	 */
	protected int quantidadeFiltrados(final T consulta, final Map<String, Object> filters) {

		final Criteria criteria = this.criarCriteriaParaConsulta(consulta, filters);

		criteria.setProjection(Projections.rowCount());

		return ( (Number) criteria.uniqueResult() ).intValue();

	}

	/**
	 * Método responsável por retornar a lista de registro que será exibida na paginação
	 * 
	 * @author Denis
	 * 
	 * @param consulta
	 * @param qtd
	 * @param page
	 * @param sortField
	 * @param sortOrder
	 * @param filters
	 * @return
	 */
	public Paginacao<T> listar(final T consulta, final int qtd, final int page, final String sortField, final SortOrder sortOrder, final Map<String, Object> filters) {

		final long quantidade = this.quantidadeFiltrados(consulta, filters);

		final Criteria criteria = this.criarCriteriaParaConsulta(consulta, filters);

		criteria.setMaxResults(qtd);

		criteria.setFirstResult(page);

		this.criarOrdenacao(sortField, sortOrder, criteria);

		final List<T> elementos = criteria.list();

		return new Paginacao<T>(quantidade, elementos);
	}

	/**
	 * Método responsável por definir as ordenações
	 * 
	 * @author Denis
	 * 
	 * @param sortField
	 * @param sortOrder
	 * @param criteria
	 */
	protected void criarOrdenacao(final String sortField, final SortOrder sortOrder, final Criteria criteria) {

		if (SortOrder.ASCENDING.equals(sortOrder) && sortField != null) {

			criteria.addOrder(Order.asc(sortField));

		} else if (sortField != null) {

			criteria.addOrder(Order.desc(sortField));

		} else {

			criteria.addOrder(Order.asc("id"));
		}
	}

}
