package fr.liris.smarthome.bean;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class WebSession extends Session implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2393615409936226192L;
	
	/**
	 * User ID
	 */
	private String userId;
	
	/**
	 * User Name
	 */
	private String userName;

	/**
	 * Password
	 */
	private String password;
	
	/**
	 * Buisiness ID
	 */
	private String businessId;
	
	/**
	 * User Group
	 */
	private UserGroup userGroup;
	
	/**
	 * User Groups : Profiles
	 */
	public static enum UserGroup {
		AA02((String) "AA02"),
		VA01((String) "VA01"),
		B02((String) "B02"),
		UNKNOWN((String) "Unknown");
		private final String userGroup;
		private UserGroup(String userGroup) {
			this.userGroup = userGroup;
		}
		public String getValue() {
			return this.userGroup;
		}
	};
	
	/**
	 * Constructeur par defaut
	 */
	public WebSession() {
		super();
	}

	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param username the username to set
	 */
	public void setUserName(String userName) {
		this.userName= userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the businessId
	 */
	public String getBusinessId() {
		return businessId;
	}

	/**
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	/**
	 * @return the userGroup
	 */
	public UserGroup getUserGroup() {
		return userGroup;
	}

	/**
	 * @param userGroup the userGroup to set
	 */
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("userId", this.userId)
			.append("userName", this.userName)
			.append("password", this.password)
			.append("businessId", this.businessId)
			.append("userGroup", this.userGroup)
			.toString();
	}
}