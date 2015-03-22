package br.com.javagyn.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.javagyn.model.base.EntidadeImpl;

/**
 * <p>
 * <b>Title:</b> ContaFinanceira
 * </p>
 * 
 * <p>
 * <b>Description:</b> ContaFinanceira
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
@Table(name = "conta_financeira")
@SequenceGenerator(name = EntidadeImpl.SEQUENCE_GENERATOR, sequenceName = "seq_tb_conta_financeira", allocationSize = 1, initialValue = 1)
public class ContaFinanceira extends EntidadeImpl {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 7717801931753338830L;

	/** Atributo usuario. */
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH }, optional = false, targetEntity = Usuario.class)
	@JoinColumn(insertable = true, unique = false, name = "id_usuario", updatable = true, nullable = false)
	private Usuario usuario;

	/** Atributo contaFinanceira. */
	@NotEmpty
	@Size(max = 60)
	@Column(name = "ds_conta_financeira", nullable = false)
	private String nomeContaFinanceira;

	/** Atributo observacao. */
	@Size(max = 60)
	@Column(name = "ds_observacao", nullable = true)
	private String observacao;

	/** Atributo saldo. */
	@NotNull
	@Column(name = "vl_saldo", precision = 10, scale = 2, nullable = false)
	private BigDecimal saldo;

	/**
	 * Retorna o valor do atributo <code>usuario</code>
	 * 
	 * @return <code>Usuario</code>
	 */
	public Usuario getUsuario() {

		return this.usuario;
	}

	/**
	 * Define o valor do atributo <code>usuario</code>.
	 * 
	 * @param usuario
	 */
	public void setUsuario(final Usuario usuario) {

		this.usuario = usuario;
	}

	/**
	 * Retorna o valor do atributo <code>nomeContaFinanceira</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getNomeContaFinanceira() {

		return nomeContaFinanceira;
	}

	/**
	 * Define o valor do atributo <code>nomeContaFinanceira</code>.
	 * 
	 * @param nomeContaFinanceira
	 */
	public void setNomeContaFinanceira(String nomeContaFinanceira) {

		this.nomeContaFinanceira = nomeContaFinanceira;
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
	 * Retorna o valor do atributo <code>saldo</code>
	 * 
	 * @return <code>BigDecimal</code>
	 */
	public BigDecimal getSaldo() {

		return this.saldo;
	}

	/**
	 * Define o valor do atributo <code>saldo</code>.
	 * 
	 * @param saldo
	 */
	public void setSaldo(final BigDecimal saldo) {

		this.saldo = saldo;
	}

}
