package br.com.javagyn.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.javagyn.bo.ContaFinanceiraBO;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.model.ContaFinanceira;
import br.com.javagyn.model.Usuario;
import br.com.javagyn.service.base.AppService;

/**
 * <p>
 * <b>Title:</b> ContaFinanceiraService
 * </p>
 * 
 * <p>
 * <b>Description:</b> ContaFinanceiraService
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
public class ContaFinanceiraService extends AppService<ContaFinanceira, ContaFinanceiraBO> {

	/** Atributo CONTA_NÃO_DESATIVADA. */
	private static final String CONTA_NÃO_DESATIVADA = "Conta não desativada! Não é possivel desativar uma conta com saldo diferente de 0.";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private ContaFinanceiraBO bo;

	/**
	 * @param ContaFinanceira
	 * @throws NegocioException
	 */
	@Override
	public void salvar(final ContaFinanceira contaFinanceira) throws NegocioException {

		this.getBo().salvar(contaFinanceira);

	}

	/**
	 * Método responsável por desativar conta financeira
	 * 
	 * @author Denis
	 * 
	 * @param contaFinanceira
	 * @throws NegocioException
	 */
	public void desativarContaFinanceira(ContaFinanceira contaFinanceira) throws NegocioException {

		if (contaFinanceira.getSaldo().doubleValue() != 0) {

			throw new NegocioException(ContaFinanceiraService.CONTA_NÃO_DESATIVADA);
		}

		contaFinanceira = this.getBo().getDao().obter(contaFinanceira.getId());

		this.desativar(contaFinanceira);

	}

	/**
	 * Método responsável por ativar conta financeira
	 * 
	 * @author Denis
	 * 
	 * @param contaFinanceira
	 * @throws NegocioException
	 */
	public void ativarContaFinanceira(ContaFinanceira contaFinanceira) throws NegocioException {

		contaFinanceira = this.getBo().getDao().obter(contaFinanceira.getId());

		this.ativar(contaFinanceira);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.javagyn.service.Service#getBo()
	 */
	@Override
	public ContaFinanceiraBO getBo() {

		return this.bo;

	}

	/**
	 * Método responsável por obter lista de conta financeira por usuario
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @return
	 */
	public Collection<ContaFinanceira> listarPorUsuario(final Usuario usuario) {

		return this.getBo().listarPorUsuario(usuario);
	}

}
