package fr.liris.smarthome.web.action;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.smarthome.model.Actuator;
import fr.liris.smarthome.service.ActuatorManager;

public class ActuatorBoardAction extends GenericAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1301128888702373969L;
	
	private static final Logger logger = LoggerFactory.getLogger(ActuatorBoardAction.class);
	

	@Autowired
	public ActuatorManager actuatorManager;
	
	private List<Actuator> actuators;

	private String actuatorName;

	private String actuatorDescription;
		
	public List<Actuator> getActuators() {
		return actuators;
	}

	public void setActuators(List<Actuator> actuators) {
		this.actuators = actuators;
	}

	public String getActuatorName() {
		return actuatorName;
	}

	public void setActuatorName(String actuatorName) {
		this.actuatorName = actuatorName;
	}

	public String getActuatorDescription() {
		return actuatorDescription;
	}

	public void setActuatorDescription(String actuatorDescription) {
		this.actuatorDescription = actuatorDescription;
	}

	public String execute() {
		logger.debug("START execute");
		try {
			actuators = actuatorManager.getAllActuators();
			return Action.SUCCESS;

		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.SUCCESS;
		}
	}

	public String load() {
		try {
			logger.debug("START LOAD");
			actuators = actuatorManager.getAllActuators();
			return Action.SUCCESS;
		}
		catch(Exception e) {
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.ERROR;
		}
	}
	
	public String createActuator() {
		try {
			logger.debug("START createActuator");
			logger.debug("actuatorName = {}, actuatorDescription = {}", actuatorName, actuatorDescription);
			Actuator actuator = new Actuator(actuatorName, actuatorDescription);
			
			actuatorManager.createNewActuator(actuator);
			
//			logger.info("Actuators number {}", actuators.size());
			return Action.SUCCESS;
		} catch(Exception e) {
			logger.error("Exception in ACTION createActuator : {}", e.getMessage());
			return Action.ERROR;
		}
	}
}
