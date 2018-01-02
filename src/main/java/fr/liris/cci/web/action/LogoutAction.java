package fr.liris.cci.web.action;


public class LogoutAction extends GenericAction {
	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -618413558835479021L;
//
//	/**
//	 * Reference sur le Logger
//	 */
//	private final static Logger logger = LoggerFactory.getLogger(LogoutAction.class);
//	
//	public String execute() {
//		try {
//			((SessionMap<String, Object>) getSession()).invalidate();
//			setSession(null);
//		}
//		catch (IllegalStateException ise) {
//			logger.error(ise.getMessage(), ise);
//			setSession(null);
//			return Action.SUCCESS;
//		}
//		catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			setSession(null);
//			return Action.ERROR;
//		}
//		return Action.SUCCESS;
//	}
}