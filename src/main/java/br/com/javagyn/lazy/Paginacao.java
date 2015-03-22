package br.com.javagyn.lazy;

import java.util.List;

/**
 * <p>
 * <b>Title:</b> Paginacao
 * </p>
 * 
 * <p>
 * <b>Description:</b> Paginacao
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * @param <T>
 * 
 * @version 1.0.0
 */
public class Paginacao<T> {

	/** Atributo quantidade. */
	private final long quantidade;

	/** Atributo elementos. */
	private final List<T> elementos;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param quantidade
	 * @param elementos
	 */
	public Paginacao( final long quantidade, final List<T> elementos ) {

		this.quantidade = quantidade;

		this.elementos = elementos;
	}

	/**
	 * Retorna o valor do atributo <code>quantidade</code>
	 * 
	 * @return <code>long</code>
	 */
	public long getQuantidade() {

		return this.quantidade;
	}

	/**
	 * Retorna o valor do atributo <code>elementos</code>
	 * 
	 * @return <code>List<T></code>
	 */
	public List<T> getElementos() {

		return this.elementos;
	}

}
