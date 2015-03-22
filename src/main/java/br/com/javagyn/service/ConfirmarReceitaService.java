package br.com.javagyn.service;

import javax.inject.Inject;

import br.com.javagyn.bo.ConfirmarReceitaBO;
import br.com.javagyn.model.ConfirmarReceita;
import br.com.javagyn.service.base.AppService;

/**
 * <p>
 * <b>Title:</b> ConfirmarReceitaService
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfirmarReceitaService
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
public class ConfirmarReceitaService extends AppService<ConfirmarReceita, ConfirmarReceitaBO> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private ConfirmarReceitaBO bo;

	/**
	 * Método responsável por obter receita confirmada por id previsão receita
	 * 
	 * @author Denis
	 * 
	 * @param idPrevisaoReceita
	 * @return
	 */
	public ConfirmarReceita obterReceitaConfirmada(final Long idPrevisaoReceita) {

		return this.getBo().obterReceitaConfirmada(idPrevisaoReceita);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.javagyn.service.Service#getBo()
	 */
	@Override
	public ConfirmarReceitaBO getBo() {

		return this.bo;
	}

}
