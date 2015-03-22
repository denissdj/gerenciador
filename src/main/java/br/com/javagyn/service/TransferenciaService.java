package br.com.javagyn.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.javagyn.bo.TransferenciaBO;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.model.ContaFinanceira;
import br.com.javagyn.model.Transferencia;
import br.com.javagyn.model.Usuario;
import br.com.javagyn.service.base.AppService;

/**
 * <p>
 * <b>Title:</b> TransferenciaService
 * </p>
 * 
 * <p>
 * <b>Description:</b> TransferenciaService
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
public class TransferenciaService extends AppService<Transferencia, TransferenciaBO> {

	/** Atributo CONTA_DE_ORIGEM_E_DESTINO_IGUAIS. */
	private static final String CONTA_DE_ORIGEM_E_DESTINO_IGUAIS = "Transferência não efetuada! Conta de Origem e Destino não podem ser as mesmas.";

	/** Atributo SALDO_INSUFICIENTE. */
	private static final String SALDO_INSUFICIENTE = "Saldo insuficiente para Transferência!";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private TransferenciaBO bo;

	/** Atributo contaFinanceiraService. */
	@Inject
	private ContaFinanceiraService contaFinanceiraService;

	/**
	 * @see br.com.javagyn.service.base.Service#getBo()
	 */
	@Override
	public TransferenciaBO getBo() {

		return this.bo;
	}

	/**
	 * Método responsável por obter lista de conta financeira por usuario para combobox
	 * 
	 * @author Denis
	 * 
	 * @param usuario
	 * @return
	 */
	public Collection<ContaFinanceira> obterListaContasFinanceiras(final Usuario usuario) {

		return this.getContaFinanceiraService().listarPorUsuario(usuario);
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
	 * Método responsável por realizar a transferencia entre as contas selecionadas
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @throws NegocioException
	 */
	public void efetuarTransferencia(final Transferencia entidade) throws NegocioException {

		this.validarTransferencia(entidade);

		entidade.getContaDestino().setSaldo(entidade.getContaDestino().getSaldo().add(entidade.getValor()));

		entidade.getContaOrigem().setSaldo(entidade.getContaOrigem().getSaldo().subtract(entidade.getValor()));

		this.getContaFinanceiraService().mesclar(entidade.getContaOrigem());

		this.getContaFinanceiraService().mesclar(entidade.getContaDestino());

		this.getBo().inserir(entidade);

	}

	/**
	 * Método responsável por validar a transferencia entre as contas selecionadas
	 * 
	 * @author Denis
	 * 
	 * @param entidade
	 * @throws NegocioException
	 */
	public void validarTransferencia(final Transferencia entidade) throws NegocioException {

		if (entidade.getContaOrigem().equals(entidade.getContaDestino())) {

			throw new NegocioException(TransferenciaService.CONTA_DE_ORIGEM_E_DESTINO_IGUAIS);
		}

		if (entidade.getContaOrigem().getSaldo().doubleValue() < entidade.getValor().doubleValue()) {

			throw new NegocioException(TransferenciaService.SALDO_INSUFICIENTE);
		}
	}

}
