package br.com.javagyn.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.javagyn.dao.ContaFinanceiraDAO;
import br.com.javagyn.model.ContaFinanceira;

/**
 * <p>
 * <b>Title:</b> ContaFinanceiraConverter
 * </p>
 * 
 * <p>
 * <b>Description:</b> ContaFinanceiraConverter
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
@FacesConverter(forClass = ContaFinanceira.class)
public class ContaFinanceiraConverter implements Converter {

	/** Atributo contaFinanceiraDAO. */
	@Inject
	private ContaFinanceiraDAO contaFinanceiraDAO;

	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {

		ContaFinanceira retorno = null;

		if (value != null) {

			retorno = this.contaFinanceiraDAO.obter(new Long(value));
		}

		return retorno;
	}

	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {

		if (value != null) {

			final ContaFinanceira retorno = ( (ContaFinanceira) value );

			return retorno.getId() == null ? null : retorno.getId().toString();
		}

		return null;
	}

}
