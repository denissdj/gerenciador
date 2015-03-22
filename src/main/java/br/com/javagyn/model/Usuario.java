package br.com.javagyn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.javagyn.model.base.EntidadeImpl;

/**
 * <p>
 * <b>Title:</b> Usuario
 * </p>
 * 
 * <p>
 * <b>Description:</b> Usuario
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
@Table(name = "usuarios")
@SequenceGenerator(name = EntidadeImpl.SEQUENCE_GENERATOR, sequenceName = "seq_tb_usuario", allocationSize = 1, initialValue = 1)
public class Usuario extends EntidadeImpl {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 5886040720398125676L;

	/** Atributo nome. */
	@NotEmpty
	@Size(max = 60)
	@Column(nullable = false)
	private String nome;

	/** Atributo login. */
	@NotEmpty
	@Size(max = 60)
	@Column(nullable = false)
	private String login;

	/** Atributo dataNascimento. */
	@NotNull
	@Column(name = "dt_nascimento", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	/** Atributo cpf. */
	@NotEmpty
	@Size(max = 14)
	@Column(nullable = false)
	private String cpf;

	/** Atributo email. */
	@NotEmpty
	@Size(max = 60)
	@Column(nullable = false)
	private String email;

	/** Atributo telefone. */
	@NotEmpty
	@Size(max = 15)
	@Column(nullable = false)
	private String telefone;

	/** Atributo senha. */
	@NotEmpty
	// @Size(min = 3, max = 20)
	@Column(nullable = false, length = 100)
	private String senha;

	/** Atributo userAdmin. */
	@Column(nullable = true, name = "USER_ADMIN")
	private boolean userAdmin;

	/**
	 * Retorna o valor do atributo <code>nome</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getNome() {

		return this.nome;
	}

	/**
	 * Define o valor do atributo <code>nome</code>.
	 * 
	 * @param nome
	 */
	public void setNome(final String nome) {

		this.nome = nome;
	}

	/**
	 * Retorna o valor do atributo <code>login</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getLogin() {

		return this.login;
	}

	/**
	 * Define o valor do atributo <code>login</code>.
	 * 
	 * @param login
	 */
	public void setLogin(final String login) {

		this.login = login;
	}

	/**
	 * Retorna o valor do atributo <code>dataNascimento</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	/**
	 * Define o valor do atributo <code>dataNascimento</code>.
	 * 
	 * @param dataNascimento
	 */
	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	/**
	 * Retorna o valor do atributo <code>cpf</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getCpf() {

		return this.cpf;
	}

	/**
	 * Define o valor do atributo <code>cpf</code>.
	 * 
	 * @param cpf
	 */
	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	/**
	 * Retorna o valor do atributo <code>email</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getEmail() {

		return this.email;
	}

	/**
	 * Define o valor do atributo <code>email</code>.
	 * 
	 * @param email
	 */
	public void setEmail(final String email) {

		this.email = email;
	}

	/**
	 * Retorna o valor do atributo <code>telefone</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getTelefone() {

		return this.telefone;
	}

	/**
	 * Define o valor do atributo <code>telefone</code>.
	 * 
	 * @param telefone
	 */
	public void setTelefone(final String telefone) {

		this.telefone = telefone;
	}

	/**
	 * Retorna o valor do atributo <code>senha</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getSenha() {

		return this.senha;
	}

	/**
	 * Define o valor do atributo <code>senha</code>.
	 * 
	 * @param senha
	 */
	public void setSenha(final String senha) {

		this.senha = senha;
	}

	/**
	 * Retorna o valor do atributo <code>userAdmin</code>
	 * 
	 * @return <code>boolean</code>
	 */
	public boolean isUserAdmin() {

		return this.userAdmin;
	}

	/**
	 * Define o valor do atributo <code>userAdmin</code>.
	 * 
	 * @param userAdmin
	 */
	public void setUserAdmin(final boolean userAdmin) {

		this.userAdmin = userAdmin;
	}

}
