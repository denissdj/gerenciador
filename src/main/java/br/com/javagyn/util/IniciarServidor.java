package br.com.javagyn.util;

import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IniciarServidor implements ServletContextListener {

	// Acrescentar as linhas abaixo no web.xml para ativar essa classe
	// <listener>
	// <listener-class>br.com.javagyn.util.IniciarServidor</listener-class>
	// </listener>

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// toda vez que voce startar o servidor esse metodo sera executado
		// aqui voce inicializa o que precisa
		Persistence.createEntityManagerFactory("Financeiro");
	}
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// toda vez que voce parar o servidor esse metodo sera executado
	}

}
