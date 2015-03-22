package br.com.javagyn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.javagyn.model.base.EntidadeImpl;

/**
 * <p>
 * <b>Title:</b> Configuracoes
 * </p>
 * 
 * <p>
 * <b>Description:</b> Configuracoes
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
@Table(name = "configuracoes")
@SequenceGenerator(name = EntidadeImpl.SEQUENCE_GENERATOR, sequenceName = "seq_tb_configuracoes", allocationSize = 1, initialValue = 1)
public class Configuracoes extends EntidadeImpl {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6786409058046560231L;

	/** Atributo tempoSessao. */
	@Column(length = 5, nullable = false, name = "tempo_sessao")
	private int tempoSessao;

	/**
	 * Retorna o valor do atributo <code>tempoSessao</code>
	 * 
	 * @return <code>int</code>
	 */
	public int getTempoSessao() {

		return this.tempoSessao;
	}

	/**
	 * Define o valor do atributo <code>tempoSessao</code>.
	 * 
	 * @param tempoSessao
	 */
	public void setTempoSessao(final int tempoSessao) {

		this.tempoSessao = tempoSessao;
	}

}
