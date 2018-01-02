package fr.liris.smarthome.bean;

import java.util.Map;

import org.slf4j.MDC;
import org.springframework.stereotype.Service;

/**
 * @author fardon
 */
@Service("webSessionManager")
public class WebSessionManagerImpl implements WebSessionManager {
	
	/*
	 * (non-Javadoc)
	 * @see fr.cps.vafc.core.WebSessionManager#getWebSessionObject(java.util.Map)
	 */
	public WebSession getWebSessionObject(Map<String, Object> sessionMap) {
		WebSession webSession = null;
		try {
			if(sessionMap.containsKey(sessionDefaultValue)) {
				webSession = (WebSession)sessionMap.get(sessionDefaultValue);
			}
			else {
				webSession = new WebSession();
			}
			return webSession;
		}
		catch(Exception e) {
			webSession = new WebSession();
			//e.printStackTrace();
			return webSession;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.cps.vafc.core.WebSessionManager#getWebSessionObject(java.util.Map, java.lang.String)
	 */
	public WebSession getWebSessionObject(Map<String, Object> sessionMap, String keyValue) {
		WebSession webSession = null;
		try {
			if(sessionMap.containsKey(keyValue)) {
				webSession = (WebSession)sessionMap.get(keyValue);
			}
			else {
				webSession = new WebSession();
			}
			return webSession;
		}
		catch(Exception e) {
			webSession = new WebSession();
			//e.printStackTrace();
			return webSession;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.cps.vafc.core.WebSessionManager#setWebSessionObject(fr.cps.vafc.bean.WebSession, java.util.Map)
	 */
	public void setWebSessionObject(WebSession webSession, Map<String, Object> sessionMap) {
		try {
			sessionMap.put(sessionDefaultValue, webSession);		
			if(webSession.getUserName() != null ) {
				MDC.put("username", webSession.getUserName());
			}
			else {
				MDC.put("username", "UNKNOWN");
			}		
		}
		catch (Exception e) {
			MDC.put("username", "UNKNOWN");
			//e.printStackTrace();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.cps.vafc.core.WebSessionManager#setWebSessionObject(fr.cps.vafc.bean.WebSession, java.util.Map, java.lang.String)
	 */
	public void setWebSessionObject(WebSession webSession, Map<String, Object> sessionMap, String keyValue) {
		try {
			sessionMap.put(keyValue, webSession);		
			if(webSession.getUserName() != null ){
				MDC.put("username", webSession.getUserName());
			}
			else {
				MDC.put("username", "UNKNOWN");
			}	
		}
		catch (Exception e) {
			MDC.put("username", "UNKNOWN");
			//e.printStackTrace();
		}
	}
}