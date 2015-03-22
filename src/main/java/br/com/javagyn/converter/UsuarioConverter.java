package br.com.javagyn.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.javagyn.dao.UsuarioDAO;
import br.com.javagyn.model.Usuario;

/**
 * <p>
 * <b>Title:</b> UsuarioConverter
 * </p>
 * 
 * <p>
 * <b>Description:</b> UsuarioConverter
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
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	/** Atributo usuarioDAO. */
	@Inject
	private UsuarioDAO usuarioDAO;

	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {

		Usuario retorno = null;

		if (value != null) {

			retorno = this.usuarioDAO.obter(new Long(value));
		}

		return retorno;
	}

	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {

		if (value != null) {

			final Usuario usuario = ( (Usuario) value );

			return usuario.getId() == null ? null : usuario.getId().toString();
		}

		return null;
	}

}
