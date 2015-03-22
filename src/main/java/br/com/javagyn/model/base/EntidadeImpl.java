package br.com.javagyn.model.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.javagyn.enuns.EnumStatusEntidade;

/**
 * <p>
 * <b>Title:</b> EntidadeImpl
 * </p>
 * 
 * <p>
 * <b>Description:</b> EntidadeImpl
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
@MappedSuperclass
public class EntidadeImpl extends BaseBean implements Entidade {

	/** Atributo SEQUENCE_GENERATOR. */
	public static final String SEQUENCE_GENERATOR = "seqGenerator";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 3897394833982177865L;

	/** Atributo id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntidadeImpl.SEQUENCE_GENERATOR)
	private Long id;

	/** Atributo statusEntidade. */
	@Column(insertable = true, length = 7, unique = false, updatable = true, nullable = false, name = "status_entidade")
	@Enumerated(EnumType.STRING)
	private EnumStatusEntidade statusEntidade;

	/** Atributo dataCadastro. */
	@Column(insertable = true, unique = false, updatable = true, nullable = true, name = "DT_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	/**
	 * Método responsável por validar os dados da entidade antes de serem inseridas na base de dados
	 * 
	 * @author Denis
	 * 
	 */
	@PrePersist
	public void validate() {

		this.dataCadastro = new Date();

		this.statusEntidade = EnumStatusEntidade.ATIVO;

	}

	/**
	 * @see br.com.javagyn.model.base.Entidade#getIdentificador()
	 */
	@Override
	public Serializable getIdentificador() {

		return this.id;
	}

	/**
	 * @see br.com.javagyn.model.base.Entidade#isNew()
	 */
	@Override
	public boolean isNew() {

		return this.id == null;
	}

	/**
	 * @see br.com.javagyn.model.base.Entidade#getStatusEntidade()
	 */
	@Override
	public EnumStatusEntidade getStatusEntidade() {

		return this.statusEntidade;
	}

	/**
	 * @see br.com.javagyn.model.base.Entidade#setStatusEntidade(br.com.javagyn.enuns.EnumStatusEntidade)
	 */
	@Override
	public void setStatusEntidade(final EnumStatusEntidade statusEntidade) {

		this.statusEntidade = statusEntidade;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( this.id == null ) ? 0 : this.id.hashCode() );
		return result;
	}

	/**
	 * @see br.com.javagyn.model.base.BaseBean#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final EntidadeImpl other = (EntidadeImpl) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/**
	 * Retorna o valor do atributo <code>id</code>
	 * 
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return this.id;
	}

	/**
	 * Define o valor do atributo <code>id</code>.
	 * 
	 * @param id
	 */
	public void setId(final Long id) {

		this.id = id;
	}

	/**
	 * Retorna o valor do atributo <code>dataCadastro</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getDataCadastro() {

		return this.dataCadastro;
	}

	/**
	 * Define o valor do atributo <code>dataCadastro</code>.
	 * 
	 * @param dataCadastro
	 */
	public void setDataCadastro(final Date dataCadastro) {

		this.dataCadastro = dataCadastro;
	}

}
