package fr.liris.smarthome.web.action;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 
 * @author fardon
 *
 */
public class AuthenticationInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 3295003252384506519L;
	
	/**
	 * Reference sur le Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		try {
//			WebSession webSession = (WebSession)session.get(WebSessionManager.sessionDefaultValue);
//			if(webSession == null) {
////				logger.debug("Authentication failed, redirect to authentication page.");
//				return "unauthenticated";
//			}
			return invocation.invoke();
		}
		catch (Exception e) {
			e.printStackTrace();
			return "unauthenticated";
		}
	}
}