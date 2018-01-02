package fr.liris.cci.web.action;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.cci.model.Actuator;
import fr.liris.cci.model.Sensor;
import fr.liris.cci.service.ActuatorManager;

public class ActuatorBoardAction extends GenericAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1301128888702373969L;
	
	private static final Logger logger = LoggerFactory.getLogger(ActuatorBoardAction.class);
	

	@Autowired
	public ActuatorManager actuatorManager;
	
	private List<Actuator> actuators;
		
	public List<Actuator> getActuators() {
		return actuators;
	}

	public void setActuators(List<Actuator> actuators) {
		this.actuators = actuators;
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
			logger.debug("START createSensor");
			
			
			return Action.SUCCESS;
		} catch(Exception e) {
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.ERROR;
		}
	}
}
