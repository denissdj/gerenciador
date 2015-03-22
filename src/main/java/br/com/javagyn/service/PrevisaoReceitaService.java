package br.com.javagyn.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.javagyn.bo.PrevisaoReceitaBO;
import br.com.javagyn.enuns.EnumSituacaoPrevisaoReceita;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.model.ConfirmarReceita;
import br.com.javagyn.model.ContaFinanceira;
import br.com.javagyn.model.PrevisaoReceita;
import br.com.javagyn.model.Usuario;
import br.com.javagyn.service.base.AppService;

/**
 * <p>
 * <b>Title:</b> PrevisaoReceitaService
 * </p>
 * 
 * <p>
 * <b>Description:</b> PrevisaoReceitaService
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
public class PrevisaoReceitaService extends AppService<PrevisaoReceita, PrevisaoReceitaBO> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private PrevisaoReceitaBO bo;

	/** Atributo contaFinanceiraService. */
	@Inject
	private ContaFinanceiraService contaFinanceiraService;

	/** Atributo contaFinanceiraService. */
	@Inject
	private ConfirmarReceitaService confirmarReceitaService;

	/**
	 * @see br.com.javagyn.service.base.Service#salvar(br.com.javagyn.model.base.Entidade)
	 */
	@Override
	public void salvar(final PrevisaoReceita entidade) throws NegocioException {

		if (entidade.isNew()) {

			entidade.setSituacao(EnumSituacaoPrevisaoReceita.NAO_CONFIRMADA);
		}

		super.salvar(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.javagyn.service.Service#getBo()
	 */
	@Override
	public PrevisaoReceitaBO getBo() {

		return this.bo;
	}

	/**
	 * Método responsável por confirmar previsão de receita
	 * 
	 * @author Denis
	 * 
	 * @param confirmarReceita
	 * @throws NegocioException
	 */
	public void confirmarPrevisaoReceita(final ConfirmarReceita confirmarReceita) throws NegocioException {

		final PrevisaoReceita previsaoReceita = confirmarReceita.getPrevisaoReceita();

		previsaoReceita.setSituacao(EnumSituacaoPrevisaoReceita.CONFIRMADA);

		this.getBo().mesclar(previsaoReceita);

		final ContaFinanceira contaFinanceira = confirmarReceita.getContaDeposito();

		contaFinanceira.setSaldo(contaFinanceira.getSaldo().add(confirmarReceita.getPrevisaoReceita().getValor()));

		this.getContaFinanceiraService().mesclar(contaFinanceira);

		this.getConfirmarReceitaService().salvar(confirmarReceita);
	}

	/**
	 * Método responsável por estornar previsão de receita
	 * 
	 * @author Denis
	 * 
	 * @param previsaoReceita
	 * @throws NegocioException
	 */
	public void estornarPrevisaoReceita(final PrevisaoReceita previsaoReceita) throws NegocioException {

		final ConfirmarReceita confirmarReceita = this.getConfirmarReceitaService().obterReceitaConfirmada(previsaoReceita.getId());

		previsaoReceita.setSituacao(EnumSituacaoPrevisaoReceita.NAO_CONFIRMADA);

		this.getBo().mesclar(previsaoReceita);

		final ContaFinanceira contaFinanceira = confirmarReceita.getContaDeposito();

		contaFinanceira.setSaldo(contaFinanceira.getSaldo().subtract(confirmarReceita.getPrevisaoReceita().getValor()));

		this.getContaFinanceiraService().mesclar(contaFinanceira);

		this.getConfirmarReceitaService().desativar(confirmarReceita);
	}

	/**
	 * Método responsável por desativar previsão receita
	 * 
	 * @author Denis
	 * 
	 * @param consulta
	 * @throws NegocioException
	 */
	public void desativarPrevisaoReceita(final PrevisaoReceita consulta) throws NegocioException {

		this.desativar(consulta);
	}

	/**
	 * Método responsável por obter lista de contas financeiras por usuário
	 * 
	 * @author Denis
	 * 
	 * @param usuarioLogado
	 * @return
	 */
	public Collection<ContaFinanceira> obterListaContasFinanceiras(final Usuario usuarioLogado) {

		return this.getContaFinanceiraService().listarPorUsuario(usuarioLogado);
	}

	/**
	 * Retorna o valor do atributo <code>contaFinanceiraService</code>
	 * 
	 * @return <code>ContaFinanceiraService</code>
	 */
	public ContaFinanceiraService getContaFinanceiraService() {

		return this.contaFinanceiraService;
	}

	/**
	 * Retorna o valor do atributo <code>confirmarReceitaService</code>
	 * 
	 * @return <code>ConfirmarReceitaService</code>
	 */
	public ConfirmarReceitaService getConfirmarReceitaService() {

		return this.confirmarReceitaService;
	}

}
