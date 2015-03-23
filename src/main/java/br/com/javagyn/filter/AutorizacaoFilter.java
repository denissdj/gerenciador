package br.com.javagyn.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.javagyn.controller.EfetuarLoginController;

/**
 * <p>
 * <b>Title:</b> AutorizacaoFilter
 * </p>
 * 
 * <p>
 * <b>Description:</b> AutorizacaoFilter
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
@WebFilter(filterName = "AutorizacaoFilter", urlPatterns = "/paginas/*", servletNames = { "Faces Servlet" }, dispatcherTypes = {
		DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR })
public class AutorizacaoFilter implements Filter {

	/** Atributo usuarioLogin. */
	@Inject
	private EfetuarLoginController usuarioLogin;

	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res,
			final FilterChain chain) throws IOException, ServletException {

		final HttpServletResponse response = (HttpServletResponse) res;

		final HttpServletRequest request = (HttpServletRequest) req;

		if (!this.getUsuarioLogin().getLoginForm().isLogado()
				&& !request.getRequestURI().contains("javax.faces.resource")
				&& !request.getRequestURI().endsWith(".css")
				&& !request.getRequestURI().endsWith(".js")
				&& !request.getRequestURI().endsWith(".jpg")
				&& !request.getRequestURI().endsWith(".gif")
				&& !request.getRequestURI().contains(".png")
				&& !request.getRequestURI().contains("home")

		) {

			response.sendRedirect(request.getContextPath() + "/index.jsp");

		} else {

			final HttpSession session = request.getSession();
			
			if(this.getUsuarioLogin().getLoginForm().isLogado()){
				session.setMaxInactiveInterval(this.getUsuarioLogin().getLoginForm().getTempoSessao());
			}else{
				session.setMaxInactiveInterval(86400);
			}

			

			chain.doFilter(req, res);
		}
	}

	/**
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(final FilterConfig config) throws ServletException {

	}

	/**
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

	/**
	 * Retorna o valor do atributo <code>usuarioLogin</code>
	 * 
	 * @return <code>EfetuarLoginController</code>
	 */
	public EfetuarLoginController getUsuarioLogin() {

		return this.usuarioLogin;
	}

}
