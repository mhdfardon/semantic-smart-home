package fr.liris.smarthome.web.action;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.semantic.service.SensorRuleService;
import fr.liris.smarthome.model.Sensor;
import fr.liris.smarthome.service.SensorManager;

public class SensorBoardAction extends GenericAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1301128888702373969L;
	
	private static final Logger logger = LoggerFactory.getLogger(SensorBoardAction.class);

	@Autowired
	public SensorManager sensorManager;
	
	@Autowired
	private SensorRuleService sensorRuleService;
	
	private List<Sensor> sensors;

	private String sensorName;

	private String sensorMeasure;

	private String sensorType;

	private String sensorUnit;

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	
	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public String getSensorMeasure() {
		return sensorMeasure;
	}

	public void setSensorMeasure(String sensorMeasure) {
		this.sensorMeasure = sensorMeasure;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public String getSensorUnit() {
		return sensorUnit;
	}

	public void setSensorUnit(String sensorUnit) {
		this.sensorUnit = sensorUnit;
	}

	public String execute() {
		logger.debug("START execute");
		try {
			
			
			
			
			
			
			
			
			
			logger.info("Testing semantic service");
			sensorRuleService.getLinkedOpenRules("RoomTempature");
			
			
			sensors = sensorManager.getAllSensors();
			logger.info("Sensors number {}", sensors.size());
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
			sensors = sensorManager.getAllSensors();
			logger.info("Sensors number {}", sensors.size());
			return Action.SUCCESS;
		} catch(Exception e) {
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.ERROR;
		}
	}
	
	public String createSensor() {
		try {
			logger.debug("START createSensor");
			logger.debug("sensorName = {}, sensorMeasure = {}, sensorType = {}, sensorUnit = {}", new Object[] {sensorName, sensorMeasure, sensorType, sensorUnit});
			Sensor sensor = new Sensor(sensorName, sensorMeasure, sensorType, sensorUnit);
			
			sensorManager.createNewSensor(sensor);
			
//			logger.info("Sensors number {}", sensors.size());
			return Action.SUCCESS;
		} catch(Exception e) {
			logger.error("Exception in ACTION createSensor : {}", e.getMessage());
			return Action.ERROR;
		}
	}
}
