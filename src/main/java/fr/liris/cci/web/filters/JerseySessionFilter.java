package fr.liris.cci.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.liris.cci.bean.WebSession;
import fr.liris.cci.bean.WebSessionManager;

/**
 * 
 * @author fardon
 *
 */
@Component
public class JerseySessionFilter implements Filter {
	/**
	 * logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(JerseySessionFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("FILTERING");
		try {
			HttpSession session= ((HttpServletRequest)request).getSession(true);
			WebSession webSession = (WebSession)session.getAttribute(WebSessionManager.sessionDefaultValue);
			if(webSession == null) {
//				logger.error("HTTP session expired");
//				((HttpServletResponse)response).sendError(500, "Session expir\351e");
			}
			else {
				chain.doFilter(request, response);
			}
//				chain.doFilter(request, response);
			logger.debug("FILTERING OK");
		}
		catch (ClassCastException e) {
			logger.debug("ERROR");
			((HttpServletResponse)response).sendError(500, "Session expir\351e");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}