package br.com.javagyn.service.base;

import java.io.Serializable;

import br.com.javagyn.bo.base.AppBO;
import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> AppService
 * </p>
 * 
 * <p>
 * <b>Description:</b> AppService
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * @param <E>
 * @param <B>
 * 
 * @version 1.0.0
 */
public abstract class AppService<E extends Entidade, B extends AppBO<E>> extends Service<E, B> implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1L;

}
