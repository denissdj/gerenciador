package br.com.javagyn.dao;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.javagyn.dao.base.AppDAO;
import br.com.javagyn.model.Usuario;

/**
 * <p>
 * <b>Title:</b> UsuarioDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> UsuarioDAO
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
public class UsuarioDAO extends AppDAO<Usuario> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

	/**
	 * Método responsável por retornar usuário logado verificando senha e login informado
	 * 
	 * @author Denis
	 * 
	 * @param ds_login
	 * @param ds_senha
	 * @return
	 */
	public Usuario verificarLogin(final String ds_login, final String ds_senha) {

		final Criteria criteria = this.novaCriteria();

		criteria.add(Restrictions.eq("login", ds_login));

		criteria.add(Restrictions.eq("senha", ds_senha));

		return (Usuario) criteria.uniqueResult();

	}

	/**
	 * Método responsável por verificar se registro já existe
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @return
	 */
	public Boolean verificarSeRegistroJaExiste(final Usuario usuario) {

		if (usuario.isNew()) {

			final Criteria criteriaLogin = this.novaCriteria();

			final Criteria criteriaNome = this.novaCriteria();

			criteriaLogin.add(Restrictions.ilike("login", usuario.getLogin(), MatchMode.EXACT));

			criteriaNome.add(Restrictions.ilike("nome", usuario.getNome(), MatchMode.EXACT));

			criteriaLogin.setMaxResults(1);

			criteriaNome.setMaxResults(1);

			return ( criteriaLogin.uniqueResult() != null || criteriaNome.uniqueResult() != null ) ? Boolean.TRUE : Boolean.FALSE;

		} else {

			return Boolean.FALSE;
		}

	}

}
