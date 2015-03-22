package br.com.javagyn.model.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <p>
 * <b>Title:</b> BaseBean
 * </p>
 * 
 * <p>
 * <b>Description:</b> BaseBean
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
public abstract class BaseBean implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1306107674735655766L;

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {

		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
