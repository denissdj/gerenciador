package br.com.javagyn.service;

import javax.inject.Inject;

import br.com.javagyn.bo.ConfiguracoesBO;
import br.com.javagyn.exception.NegocioException;
import br.com.javagyn.model.Configuracoes;
import br.com.javagyn.service.base.AppService;

/**
 * <p>
 * <b>Title:</b> ConfiguracoesService
 * </p>
 * 
 * <p>
 * <b>Description:</b> ConfiguracoesService
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
public class ConfiguracoesService extends AppService<Configuracoes, ConfiguracoesBO> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo bo. */
	@Inject
	private ConfiguracoesBO bo;

	/**
	 * @see br.com.javagyn.service.base.Service#salvar(br.com.javagyn.model.base.Entidade)
	 */
	@Override
	public void salvar(final Configuracoes configuracoes) throws NegocioException {

		this.getBo().salvar(configuracoes);
	}

	/**
	 * Método responsável por obter entidade por id
	 * 
	 * @author Denis
	 * 
	 * @return
	 */
	public Configuracoes obter() {

		return this.getBo().obter(1L);
	}

	/**
	 * @see br.com.javagyn.service.base.Service#getBo()
	 */
	@Override
	public ConfiguracoesBO getBo() {

		return this.bo;
	}

}
