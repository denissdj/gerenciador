package br.com.javagyn.enuns;

/**
 * <p>
 * <b>Title:</b> EnumStatusEntidade
 * </p>
 * 
 * <p>
 * <b>Description:</b> EnumStatusEntidade
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
public enum EnumStatusEntidade {

	/** Atributo ATIVO. */
	ATIVO("Ativo", true),

	/** Atributo INATIVO. */
	INATIVO("Inativo", false);

	/** Atributo value. */
	private String value;

	/** Atributo status. */
	private boolean status;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param value
	 * @param status
	 */
	private EnumStatusEntidade( final String value, final boolean status ) {

		this.value = value;

		this.status = status;
	}

	/**
	 * Retorna o valor do atributo <code>value</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getValue() {

		return this.value;
	}

	/**
	 * Retorna o valor do atributo <code>status</code>
	 * 
	 * @return <code>boolean</code>
	 */
	public boolean isStatus() {

		return this.status;
	}

}
