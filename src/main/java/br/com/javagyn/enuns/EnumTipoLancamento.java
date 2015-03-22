package br.com.javagyn.enuns;

/**
 * <p>
 * <b>Title:</b> EnumTipoLancamento
 * </p>
 * 
 * <p>
 * <b>Description:</b> EnumTipoLancamento
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
public enum EnumTipoLancamento {

	/** Atributo RECEITA. */
	RECEITA("Receita"),

	/** Atributo DESPESA. */
	DESPESA("Despesa");

	/** Atributo descricao. */
	private String descricao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param descricao
	 */
	EnumTipoLancamento( final String descricao ) {

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
