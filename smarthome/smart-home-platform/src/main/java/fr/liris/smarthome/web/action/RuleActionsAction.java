package fr.liris.smarthome.web.action;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.smarthome.model.Actuator;
import fr.liris.smarthome.model.Rule;
import fr.liris.smarthome.model.RuleAction;
import fr.liris.smarthome.service.RuleActionManager;
import fr.liris.smarthome.service.ActuatorManager;
import fr.liris.smarthome.service.RuleManager;
import fr.liris.smarthome.service.SensorManager;

public class RuleActionsAction extends GenericAction implements Serializable {

	private static final long serialVersionUID = -1301128888702373969L;
	
	private static final Logger logger = LoggerFactory.getLogger(RuleActionsAction.class);

	@Autowired
	private RuleActionManager actionManager;
	
	@Autowired
	private SensorManager sensorManager;

	@Autowired
	private RuleManager ruleManager;
	
	@Autowired
	private ActuatorManager actuatorManager;
	
	private List<RuleAction> ruleActions;

	private Rule rule;

	private Long ruleId;
	
	private Long sensorId;
	
	private String label;
	
	private String status;
	
	private Actuator actuator ;
	
	private double value;
	
	private String actionName;
	
	private String actionLabel;
	
	private String actionStatus;
	
	private Double actionValue;
	
	private Long actionActuatorId;
	
	public List<RuleAction> getRuleActions() {
		return ruleActions;
	}

	public void setRuleActions(List<RuleAction> actions) {
		this.ruleActions = actions;
	}
	
	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Long getRuleId() {
		return ruleId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public Long getSensorId() {
		return sensorId;
	}

	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
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

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public String getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}

	public Double getActionValue() {
		return actionValue;
	}

	public void setActionValue(Double actionValue) {
		this.actionValue = actionValue;
	}

	public Long getActionActuatorId() {
		return actionActuatorId;
	}

	public void setActionActuatorId(Long actionActuatorId) {
		this.actionActuatorId = actionActuatorId;
	}


	public String execute() {
		logger.debug("START execute");
		try {
			rule = ruleManager.getById(getRuleId());
			logger.info("Loaded Rule : {}", rule.toString());
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
	
	public String createRuleAction() {
		try {
			logger.debug("START LOAD");
			logger.info("Rule Id : {}", ruleId);
			Rule loadedRule = ruleManager.getById(ruleId);
			logger.info("Action Actuator ID : {}", actionActuatorId);
			Actuator affectedActuator = actuatorManager.getById(actionActuatorId);
			logger.info("Action Label : {}", actionLabel);
			logger.info("Action status : {}", actionStatus);
			logger.info("Action Value : {}", actionValue);
			RuleAction ruleAction = new RuleAction();
			ruleAction.setRule(loadedRule);
			ruleAction.setActuator(affectedActuator);
			ruleAction.setStatus(actionStatus);
			ruleAction.setLabel(actionLabel);
			ruleAction.setValue(actionValue);
			
//			ruleActions = actionManager.getRuleActions(getRuleId());
			return Action.SUCCESS;
		} catch(Exception e) {
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.ERROR;
		}
	}
}
