package br.com.javagyn.model.base;

import java.io.Serializable;

import br.com.javagyn.enuns.EnumStatusEntidade;

/**
 * <p>
 * <b>Title:</b> Entidade
 * </p>
 * 
 * <p>
 * <b>Description:</b> Entidade
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
public interface Entidade extends Serializable {

	/**
	 * Método responsável por retornar o identificador da entidade
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	Serializable getIdentificador();

	/**
	 * Método responsável por retornar verdadeiro se a entidade não estivar salva no banco de dados
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	boolean isNew();

	/**
	 * Método responsável por retornar o status da entidade
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public EnumStatusEntidade getStatusEntidade();

	/**
	 * Método responsável por definir o status da entidade
	 * 
	 * @author Denis
	 * 
	 * @param statusEntidade
	 */
	public void setStatusEntidade(EnumStatusEntidade statusEntidade);

}
