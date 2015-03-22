package br.com.javagyn.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.javagyn.enuns.EnumSituacaoPrevisaoReceita;
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
@Entity
@Table(name = "tbl_previsao_receita")
@SequenceGenerator(name = EntidadeImpl.SEQUENCE_GENERATOR, sequenceName = "seq_tb_previsao_receita", allocationSize = 1, initialValue = 1)
public class PrevisaoReceita extends EntidadeImpl {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 8946916788251903703L;

	/** Atributo usuario. */
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH }, optional = false, targetEntity = Usuario.class)
	@JoinColumn(insertable = true, unique = false, name = "id_usuario", updatable = true, nullable = false)
	private Usuario usuario;

	/** Atributo descricaoReceita. */
	@NotEmpty
	@Size(max = 60)
	@Column(name = "ds_receita", nullable = false)
	private String descricaoReceita;

	/** Atributo observacao. */
	@Size(max = 60)
	@Column(name = "ds_observacao", nullable = true)
	private String observacao;

	/** Atributo valor. */
	@NotNull
	@Column(name = "valor_previsao", precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;

	/** Atributo dataReceita. */
	@Column(insertable = true, unique = false, updatable = true, nullable = false, name = "DT_RECEITA")
	@Temporal(TemporalType.DATE)
	private Date dataReceita;

	/** Atributo situacao. */
	@Column(insertable = true, length = 14, unique = false, updatable = true, nullable = false, name = "SITUACAO")
	@Enumerated(EnumType.STRING)
	private EnumSituacaoPrevisaoReceita situacao;

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
	 * Retorna o valor do atributo <code>descricaoReceita</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getDescricaoReceita() {

		return this.descricaoReceita;
	}

	/**
	 * Define o valor do atributo <code>descricaoReceita</code>.
	 * 
	 * @param descricaoReceita
	 */
	public void setDescricaoReceita(final String descricaoReceita) {

		this.descricaoReceita = descricaoReceita;
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
	 * Retorna o valor do atributo <code>dataReceita</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getDataReceita() {

		if (this.dataReceita == null) {

			this.dataReceita = new Date();
		}

		return this.dataReceita;
	}

	/**
	 * Define o valor do atributo <code>dataReceita</code>.
	 * 
	 * @param dataReceita
	 */
	public void setDataReceita(final Date dataReceita) {

		this.dataReceita = dataReceita;
	}

	/**
	 * Retorna o valor do atributo <code>situacao</code>
	 * 
	 * @return <code>EnumSituacaoPrevisaoReceita</code>
	 */
	public EnumSituacaoPrevisaoReceita getSituacao() {

		return this.situacao;
	}

	/**
	 * Define o valor do atributo <code>situacao</code>.
	 * 
	 * @param situacao
	 */
	public void setSituacao(final EnumSituacaoPrevisaoReceita situacao) {

		this.situacao = situacao;
	}

}
