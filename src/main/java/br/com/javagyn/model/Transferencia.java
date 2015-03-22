package br.com.javagyn.model;

import java.math.BigDecimal;
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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.javagyn.model.base.EntidadeImpl;

/**
 * <p>
 * <b>Title:</b> Transferencia
 * </p>
 * 
 * <p>
 * <b>Description:</b> Transferencia
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
@Table(name = "tbl_transferencia")
@SequenceGenerator(name = EntidadeImpl.SEQUENCE_GENERATOR, sequenceName = "seq_tbl_transferencia", allocationSize = 1, initialValue = 1)
public class Transferencia extends EntidadeImpl {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 2896641165887551513L;

	/** Atributo contaOrigem. */
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH }, optional = false, targetEntity = ContaFinanceira.class)
	@JoinColumn(insertable = true, unique = false, name = "id_conta_financeira_origem", updatable = true, nullable = false)
	private ContaFinanceira contaOrigem;

	/** Atributo contaDestino. */
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH }, optional = false, targetEntity = ContaFinanceira.class)
	@JoinColumn(insertable = true, unique = false, name = "id_conta_financeira_destino", updatable = true, nullable = false)
	private ContaFinanceira contaDestino;

	/** Atributo valor. */
	@NotNull
	@DecimalMin("0")
	@Column(name = "vl_saldo", precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;

	/** Atributo observacao. */
	@Size(max = 60)
	@Column(name = "ds_observacao", nullable = true)
	private String observacao;

	@Column(insertable = true, unique = false, updatable = true, nullable = true, name = "DT_TRANSFERENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTransferencia;

	/**
	 * Retorna o valor do atributo <code>contaOrigem</code>
	 * 
	 * @return <code>ContaFinanceira</code>
	 */
	public ContaFinanceira getContaOrigem() {

		return this.contaOrigem;
	}

	/**
	 * Define o valor do atributo <code>contaOrigem</code>.
	 * 
	 * @param contaOrigem
	 */
	public void setContaOrigem(final ContaFinanceira contaOrigem) {

		this.contaOrigem = contaOrigem;
	}

	/**
	 * Retorna o valor do atributo <code>contaDestino</code>
	 * 
	 * @return <code>ContaFinanceira</code>
	 */
	public ContaFinanceira getContaDestino() {

		return this.contaDestino;
	}

	/**
	 * Define o valor do atributo <code>contaDestino</code>.
	 * 
	 * @param contaDestino
	 */
	public void setContaDestino(final ContaFinanceira contaDestino) {

		this.contaDestino = contaDestino;
	}

	/**
	 * Retorna o valor do atributo <code>valor</code>
	 * 
	 * @return <code>BigDecimal</code>
	 */
	public BigDecimal getValor() {

		return this.valor;
	}

	/**
	 * Define o valor do atributo <code>valor</code>.
	 * 
	 * @param valor
	 */
	public void setValor(final BigDecimal valor) {

		this.valor = valor;
	}

	/**
	 * Retorna o valor do atributo <code>observacao</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getObservacao() {

		return this.observacao;
	}

	/**
	 * Define o valor do atributo <code>observacao</code>.
	 * 
	 * @param observacao
	 */
	public void setObservacao(final String observacao) {

		this.observacao = observacao;
	}

	/**
	 * Retorna o valor do atributo <code>dataTransferencia</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getDataTransferencia() {

		if (this.dataTransferencia == null) {

			this.dataTransferencia = new Date();
		}

		return this.dataTransferencia;
	}

	/**
	 * Define o valor do atributo <code>dataTransferencia</code>.
	 * 
	 * @param dataTransferencia
	 */
	public void setDataTransferencia(final Date dataTransferencia) {

		this.dataTransferencia = dataTransferencia;
	}

}
