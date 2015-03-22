package br.com.javagyn.lazy;

import javax.inject.Inject;

import br.com.javagyn.bo.ContaFinanceiraBO;
import br.com.javagyn.model.ContaFinanceira;

/**
 * <p>
 * <b>Title:</b> ContaFinanceiraLazy
 * </p>
 * 
 * <p>
 * <b>Description:</b> ContaFinanceiraLazy
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
public class ContaFinanceiraLazy extends AppLazy<ContaFinanceira> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private ContaFinanceiraBO bo;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ContaFinanceiraLazy() {

		this.setConsulta(new ContaFinanceira());
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#getDtoClass()
	 */
	@Override
	protected Class<ContaFinanceira> getDtoClass() {

		return ContaFinanceira.class;
	}

	/**
	 * @see br.com.javagyn.lazy.AppLazy#getBo()
	 */
	@Override
	public ContaFinanceiraBO getBo() {

		return this.bo;
	}

}
