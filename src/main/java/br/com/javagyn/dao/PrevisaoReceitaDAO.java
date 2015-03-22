package br.com.javagyn.dao;

import java.util.Map;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;

import br.com.javagyn.dao.base.AppDAO;
import br.com.javagyn.model.PrevisaoReceita;

/**
 * <p>
 * <b>Title:</b> PrevisaoReceitaDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> PrevisaoReceitaDAO
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
@Stateless
public class PrevisaoReceitaDAO extends AppDAO<PrevisaoReceita> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * @see br.com.javagyn.dao.base.HibernateDAO#criarCriteriaParaConsulta(br.com.javagyn.model.base.Entidade, java.util.Map)
	 */
	@Override
	protected Criteria criarCriteriaParaConsulta(final PrevisaoReceita consulta, final Map<String, Object> filters) {

		final Criteria criteria = super.criarCriteriaParaConsulta(consulta, filters);
		
		criteria.createAlias("usuario", "usuario");

		if (consulta != null && consulta.getSituacao() != null) {

			criteria.add(Restrictions.eq("situacao", consulta.getSituacao()));

		}

		if (consulta != null && consulta.getUsuario() != null) {

			criteria.add(Restrictions.eq("usuario.id", consulta.getUsuario().getId()));
		}

		return criteria;
	}

	/**
	 * @see br.com.javagyn.dao.base.HibernateDAO#criarOrdenacao(java.lang.String, org.primefaces.model.SortOrder, org.hibernate.Criteria)
	 */
	@Override
	protected void criarOrdenacao(final String sortField, final SortOrder sortOrder, final Criteria criteria) {

		if (SortOrder.ASCENDING.equals(sortOrder) && sortField != null) {

			criteria.addOrder(Order.asc(sortField));

		} else if (sortField != null) {

			criteria.addOrder(Order.desc(sortField));

		} else {

			criteria.addOrder(Order.asc("dataReceita"));
		}
	}

}
