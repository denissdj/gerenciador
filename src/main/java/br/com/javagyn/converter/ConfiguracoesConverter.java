package br.com.javagyn.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.javagyn.dao.ConfiguracoesDAO;
import br.com.javagyn.model.Configuracoes;

/**
 * <p>
 * <b>Title:</b> ConfiguracoesConverter
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfiguracoesConverter
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
@FacesConverter(forClass = Configuracoes.class)
public class ConfiguracoesConverter implements Converter {

	/** Atributo configuracoesDao. */
	@Inject
	private ConfiguracoesDAO configuracoesDao;

	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {

		Configuracoes obj = null;

		if (value != null) {

			obj = this.configuracoesDao.obter(new Long(value));
		}

		return obj;
	}

	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {

		if (value != null) {

			final Configuracoes obj = ( (Configuracoes) value );

			return obj.getId() == null ? null : obj.getId().toString();
		}

		return null;
	}

}
