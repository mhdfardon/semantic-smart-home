package fr.liris.cci.bean;

import java.util.Map;

public interface WebSessionManager {
	
	/**
	 * default session value
	 */
	static String sessionDefaultValue = "userSession";

	/**
	 * 
	 * @param sessionMap
	 * @return
	 */
	public WebSession getWebSessionObject(Map<String, Object> sessionMap);

	/**
	 * 
	 * @param session
	 * @param valueKey
	 * @return
	 */
	public WebSession getWebSessionObject(Map<String, Object> sessionMap, String keyValue);

	/**
	 * 
	 * @param webSession
	 * @param sessionMap
	 */
	public void setWebSessionObject(WebSession webSession, Map<String, Object> sessionMap);

	/**
	 * 
	 * @param webSession
	 * @param sessionMap
	 * @param keyValue
	 */
	public void setWebSessionObject(WebSession webSession, Map<String, Object> sessionMap, String keyValue);
}