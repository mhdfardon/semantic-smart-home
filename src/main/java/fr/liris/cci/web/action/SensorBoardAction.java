package fr.liris.cci.web.action;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.cci.model.Sensor;
import fr.liris.cci.service.SensorManager;

public class SensorBoardAction extends GenericAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1301128888702373969L;
	
	private static final Logger logger = LoggerFactory.getLogger(SensorBoardAction.class);
	

	@Autowired
	public SensorManager sensorManager;
	
	private List<Sensor> sensors;

	private String sensorsName;

	private String sensorMeasure;

	private String sensorType;

	private String sensorUnit;

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	
	public String getSensorsName() {
		return sensorsName;
	}

	public void setSensorsName(String sensorsName) {
		this.sensorsName = sensorsName;
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
			Sensor sensor = new Sensor();
			sensor.setId(4L);
			sensor.setName(sensorsName);
			sensor.setMeasure(sensorMeasure);
			sensor.setType(sensorType);
			sensor.setUnit(sensorUnit);
//			sensors.add(sensor);
			
			logger.info("Sensors number {}", sensors.size());
			return Action.SUCCESS;
		} catch(Exception e) {
			logger.error("Exception in ACTION createSensor : {}", e.getMessage());
			return Action.ERROR;
		}
	}
}
