package br.com.javagyn.enuns;

/**
 * <p>
 * <b>Title:</b> EnumSituacaoPrevisaoReceita
 * </p>
 * 
 * <p>
 * <b>Description:</b> EnumSituacaoPrevisaoReceita
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
public enum EnumSituacaoPrevisaoReceita {

	/** Atributo NAO_CONFIRMADA. */
	NAO_CONFIRMADA("Não Confirmada"),

	/** Atributo CONFIRMADA. */
	CONFIRMADA("Confirmada"),

	/** Atributo TODOS. */
	TODOS("Todos");

	/** Atributo descricao. */
	private String descricao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param descricao
	 */
	EnumSituacaoPrevisaoReceita( final String descricao ) {

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atributo <code>descricao</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getDescricao() {

		return this.descricao;
	}

}
