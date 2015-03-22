package br.com.javagyn.dao;

import java.util.Collection;
import java.util.Map;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.javagyn.dao.base.AppDAO;
import br.com.javagyn.enuns.EnumStatusEntidade;
import br.com.javagyn.model.ContaFinanceira;
import br.com.javagyn.model.Usuario;

/**
 * <p>
 * <b>Title:</b> ContaFinanceiraDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> ContaFinanceiraDAO
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
public class ContaFinanceiraDAO extends AppDAO<ContaFinanceira> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Método responsável por listar conta financeira por usuario
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection<ContaFinanceira> listarPorUsuario(final Usuario usuario) {

		final Criteria criteria = this.novaCriteria();

		criteria.createAlias("usuario", "usuario");

		criteria.add(Restrictions.eq("usuario.id", usuario.getId()));

		criteria.add(Restrictions.eq("statusEntidade", EnumStatusEntidade.ATIVO));

		criteria.addOrder(Order.asc("nomeContaFinanceira"));

		return criteria.list();
	}

	/**
	 * @see br.com.javagyn.dao.base.HibernateDAO#criarCriteriaParaConsulta(br.com.javagyn.model.base.Entidade, java.util.Map)
	 */
	@Override
	protected Criteria criarCriteriaParaConsulta(final ContaFinanceira consulta, final Map<String, Object> filters) {

		final Criteria criteria = super.criarCriteriaParaConsulta(consulta, filters);

		criteria.createAlias("usuario", "usuario");

		if (consulta != null && consulta.getUsuario() != null) {

			criteria.add(Restrictions.eq("usuario.id", consulta.getUsuario().getId()));
		}

		return criteria;
	}

}
