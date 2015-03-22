package br.com.javagyn.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.javagyn.model.base.EntidadeImpl;

/**
 * <p>
 * <b>Title:</b> PrevisaoReceita
 * </p>
 * 
 * <p>
 * <b>Description:</b> PrevisaoReceita
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
/**
 * <p>
 * <b>Title:</b> ConfirmarReceita
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfirmarReceita
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
@Entity
@Table(name = "tbl_confirmar_receita")
@SequenceGenerator(name = EntidadeImpl.SEQUENCE_GENERATOR, sequenceName = "seq_tbl_confirmar_receita", allocationSize = 1, initialValue = 1)
public class ConfirmarReceita extends EntidadeImpl {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6564179456290824492L;

	/** Atributo dataReceita. */
	@Column(insertable = true, unique = false, updatable = true, nullable = false, name = "DT_CONFIRMACAO")
	@Temporal(TemporalType.DATE)
	private Date dataConfirmacao;

	/** Atributo contaDeposito. */
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH }, optional = false, targetEntity = ContaFinanceira.class)
	@JoinColumn(insertable = true, unique = false, name = "id_conta_deposito", updatable = true, nullable = false)
	private ContaFinanceira contaDeposito;

	/** Atributo previsaoReceita. */
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH }, optional = false, targetEntity = PrevisaoReceita.class)
	@JoinColumn(insertable = true, unique = false, name = "id_previsao_receita", updatable = true, nullable = false)
	private PrevisaoReceita previsaoReceita;

	/**
	 * Retorna o valor do atributo <code>dataConfirmacao</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getDataConfirmacao() {

		if (this.dataConfirmacao == null) {

			this.dataConfirmacao = new Date();
		}

		return this.dataConfirmacao;
	}

	/**
	 * Define o valor do atributo <code>dataConfirmacao</code>.
	 * 
	 * @param dataConfirmacao
	 */
	public void setDataConfirmacao(final Date dataConfirmacao) {

		this.dataConfirmacao = dataConfirmacao;
	}

	/**
	 * Retorna o valor do atributo <code>contaDeposito</code>
	 * 
	 * @return <code>ContaFinanceira</code>
	 */
	public ContaFinanceira getContaDeposito() {

		return this.contaDeposito;
	}

	/**
	 * Define o valor do atributo <code>contaDeposito</code>.
	 * 
	 * @param contaDeposito
	 */
	public void setContaDeposito(final ContaFinanceira contaDeposito) {

		this.contaDeposito = contaDeposito;
	}

	/**
	 * Retorna o valor do atributo <code>previsaoReceita</code>
	 * 
	 * @return <code>PrevisaoReceita</code>
	 */
	public PrevisaoReceita getPrevisaoReceita() {

		return this.previsaoReceita;
	}

	/**
	 * Define o valor do atributo <code>previsaoReceita</code>.
	 * 
	 * @param previsaoReceita
	 */
	public void setPrevisaoReceita(final PrevisaoReceita previsaoReceita) {

		this.previsaoReceita = previsaoReceita;
	}

}
