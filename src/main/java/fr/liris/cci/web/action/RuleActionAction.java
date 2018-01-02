package fr.liris.cci.web.action;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.cci.model.Actuator;
import fr.liris.cci.model.RuleAction;
import fr.liris.cci.service.ActionManager;

public class RuleActionAction extends GenericAction implements Serializable {

	private static final long serialVersionUID = -1301128888702373969L;
	
	private static final Logger logger = LoggerFactory.getLogger(RuleActionAction.class);

	@Autowired
	public ActionManager actionManager;
	
	private List<RuleAction> ruleActions;

	private Long ruleId;
	
	private String label;
	
	private String status;
	
	private Actuator actuator ;
	
	private double value;
	
	public List<RuleAction> getRuleActions() {
		return ruleActions;
	}

	public void setStudents(List<RuleAction> actions) {
		this.ruleActions = actions;
	}
	
	public Long getRuleId() {
		return ruleId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Actuator getActuator() {
		return actuator;
	}

	public void setActuator(Actuator actuator) {
		this.actuator = actuator;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String execute() {
		logger.debug("START execute");
		try {
			ruleActions = actionManager.getRuleActions(getRuleId());
			return Action.SUCCESS;
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.SUCCESS;
		}
	}

	public String load() {
		try {
			logger.debug("START LOAD");
			ruleActions = actionManager.getRuleActions(getRuleId());
			return Action.SUCCESS;
		} catch(Exception e) {
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.ERROR;
		}
	}
	
	public String createNewRuleAction() {
		try {
			logger.debug("START LOAD");
			ruleActions = actionManager.getRuleActions(getRuleId());
			return Action.SUCCESS;
		} catch(Exception e) {
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.ERROR;
		}
	}
}
