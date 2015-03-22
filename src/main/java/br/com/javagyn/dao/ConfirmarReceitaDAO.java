package br.com.javagyn.dao;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.javagyn.dao.base.AppDAO;
import br.com.javagyn.enuns.EnumStatusEntidade;
import br.com.javagyn.model.ConfirmarReceita;

/**
 * <p>
 * <b>Title:</b> ConfirmarReceitaDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfirmarReceitaDAO
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
public class ConfirmarReceitaDAO extends AppDAO<ConfirmarReceita> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Método responsável por obter receita confirmada por id previsão receita
	 * 
	 * @author Denis
	 * 
	 * @param idPrevisaoReceita
	 * @return
	 */
	public ConfirmarReceita obterReceitaConfirmada(final Long idPrevisaoReceita) {

		final Criteria criteria = this.novaCriteria();

		criteria.createAlias("previsaoReceita", "previsaoReceita");

		criteria.add(Restrictions.eq("statusEntidade", EnumStatusEntidade.ATIVO));

		criteria.add(Restrictions.eq("previsaoReceita.id", idPrevisaoReceita));

		return (ConfirmarReceita) criteria.uniqueResult();
	}

}
