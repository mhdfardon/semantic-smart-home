package fr.liris.smarthome.bean;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author fardon
 *
 */
public abstract class Session implements java.io.Serializable {

	private static final long serialVersionUID = -7166298495514752958L;
	
	/**
	 * Identifiant de session web ou svi
	 */
	private String sessionId;

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).
		append("sessionId", this.sessionId).
		toString();
	}	
}