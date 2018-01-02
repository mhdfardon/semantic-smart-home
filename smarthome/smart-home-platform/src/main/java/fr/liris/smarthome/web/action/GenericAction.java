package fr.liris.smarthome.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by IntelliJ IDEA.
 * User: fardon
 * Date: 07/10/11
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public abstract class GenericAction extends ActionSupport implements SessionAware {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -475793464574309488L;
	
	/**
	 * Session HTTP fournit par Struts2
	 */
	private Map<String, Object> session;

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return this.session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * Default constructor
	 */
	public GenericAction() {
		super();
	}
}