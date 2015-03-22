package br.com.javagyn.form.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.apache.log4j.Logger;

import br.com.javagyn.model.base.Entidade;

/**
 * <p>
 * <b>Title:</b> Formulario
 * </p>
 * 
 * <p>
 * <b>Description:</b> Formulario
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
@SuppressWarnings({ "unchecked" })
public class Formulario<T extends Entidade> implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 510790896686209699L;

	/** Atributo entidade. */
	private T entidade;

	/** Atributo consulta. */
	private T consulta;

	/** Atributo entidades. */
	private Collection<T> entidades;

	/** Atributo situacaoSelecionada. */
	private String situacaoSelecionada;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param clazz
	 */
	public Formulario( final Class<T> clazz ) {

		try {

			this.entidade = clazz.newInstance();

			this.consulta = clazz.newInstance();

		} catch (final Exception e) {

			Logger.getLogger(this.getClass().getName()).info("ERROR: " + e.getMessage());
		}
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	protected <F> Formulario() {

		try {

			this.entidade = this.getTipoEntidade().newInstance();

			this.consulta = this.getTipoEntidade().newInstance();

		} catch (final Exception e) {

			Logger.getLogger(this.getClass().getName()).info("ERROR: " + e.getMessage());
		}
	}

	/**
	 * Retorna o valor do atributo <code>situacaoSelecionada</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getSituacaoSelecionada() {

		return this.situacaoSelecionada;
	}

	/**
	 * Define o valor do atributo <code>situacaoSelecionada</code>.
	 * 
	 * @param situacaoSelecionada
	 */
	public void setSituacaoSelecionada(final String situacaoSelecionada) {

		this.situacaoSelecionada = situacaoSelecionada;
	}

	/**
	 * Método responsável por retorna o tipo class da entidade
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	protected Class<T> getTipoEntidade() {

		return (Class<T>) ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
	}

	/**
	 * Retorna o valor do atributo <code>entidade</code>
	 * 
	 * @return <code>T</code>
	 */
	public T getEntidade() {

		return this.entidade;
	}

	/**
	 * Define o valor do atributo <code>entidade</code>.
	 * 
	 * @param entidade
	 */
	public void setEntidade(final T entidade) {

		this.entidade = entidade;
	}

	/**
	 * Retorna o valor do atributo <code>consulta</code>
	 * 
	 * @return <code>T</code>
	 */
	public T getConsulta() {

		return this.consulta;
	}

	/**
	 * Define o valor do atributo <code>consulta</code>.
	 * 
	 * @param consulta
	 */
	public void setConsulta(final T consulta) {

		this.consulta = consulta;
	}

	/**
	 * Retorna o valor do atributo <code>entidades</code>
	 * 
	 * @return <code>Collection<T></code>
	 */
	public Collection<T> getEntidades() {

		return this.entidades;
	}

	/**
	 * Define o valor do atributo <code>entidades</code>.
	 * 
	 * @param entidades
	 */
	public void setEntidades(final Collection<T> entidades) {

		this.entidades = entidades;
	}

}
