package fr.liris.smarthome.web.action;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;

public class AccessAction extends GenericAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3378995156152775999L;

	/**
	 * Reference on class logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(GenericAction.class);
	
//	@Autowired
//	private UserDao userDao;
//	
//	@Autowired
//	private WebSessionManager webSessionManager;
	
	/**
	 * Identifiant de la session
	 */
	private String sessionId;
	
	/**
	 * User ID
	 */
	private String userId;
	
	/**
	 * User Name
	 */
	private String userName;

	/**
	 * 
	 */
	private String password;
	
	/**
	 * 
	 */
	private String encryptedPassword;
	
	/**
	 * 
	 */
	private String subscriberId;

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
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the encryptedPassword
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	/**
	 * @param encryptedPassword the encryptedPassword to set
	 */
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	/**
	 * @return the subscriberId
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId the subscriberId to set
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	
	/**
	 * Logging in Action
	 */
	public void validate() {
		logger.debug("BEGIN ACTION USER LOGIN");
		
		try {
			boolean emptyField = false;
			if ( (null == userId) || ("".equals(userId)) ) {
				addFieldError("userId", getText("login.userId.required"));
				emptyField = true;
			}
//			if ( (null == password) || ("".equals(password)) ) {
//				addFieldError("password", getText("login.password.required"));
//				emptyField = true;
//			}
//			if ( (null == subscriberId) || ("".equals(subscriberId)) ) {
//				addFieldError("subscriberId", getText("login.subscriberId.required"));
//				emptyField = true;
//			}
			if(!emptyField) {			
//				try {
					//	Create web session
//					WebSession webSession = webSessionManager.getWebSessionObject(getSession());
					//	Authentificate the web session
//					userDao.userAuthenfitication(webSession, userId, encryptedPassword, subscriberId);
//					boolean validSession = true;
//					if("NOK".equals(webSession.getUserId()) ) {
//						addFieldError("userId", getText("login.userId.invalid"));
//						validSession = false;
//					}
//					else {
//						if("NOK".equals(webSession.getPassword()) ) {
//							addFieldError("password", getText("login.password.invalid"));
//							validSession = false;
//						}
//						if("NOK".equals(webSession.getBusinessId()) ) {
//							addFieldError("subscriberId", getText("login.subscriberId.invalid"));
//							validSession = false;
//						}
//					}
//					//	Test if the authentification is ok				
//					if(validSession) {
//						//	Authentification is ok
//						webSession.setSessionId(this.getSessionId());
//						webSessionManager.setWebSessionObject(webSession, getSession());
//						logger.debug("Authentification is OK, login with session id = {}, userName = {} !", webSession.getSessionId(), webSession.getUserName());
//					}
//					else {
//						//	If the authentification is not ok then destroy the session
//						webSession = null;
//					}
//				}
//				catch (SQLException e) {
//					logger.info("authentication failed");
//					addFieldError("userName", getText("login.authentification.failed"));
//				}
			}
			else {
				logger.error("authentication failed");
				addFieldError("userName", getText("login.authentification.failed"));
			}
		}
		catch (Exception e) {
			logger.error("authentication failed");
			e.printStackTrace();
			addFieldError("userName", getText("login.authentification.failed"));
		}
	}
	
	public String execute() {
		return Action.SUCCESS;
	}
}
