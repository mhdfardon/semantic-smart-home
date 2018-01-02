package fr.liris.smarthome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.liris.smarthome.data.SensorDao;
import fr.liris.smarthome.model.Sensor;
import fr.liris.smarthome.service.RuleManager;
import fr.liris.smarthome.service.SensorManager;

@Service("sensorManager")
@Transactional
public class SensorManagerImpl implements SensorManager {
	
	@Autowired
	private RuleManager ruleManager;
	
	@Autowired
	private SensorDao sensorDao;

	/*
	 * (non-Javadoc)
	 * @see fr.liris.smarthome.service.SensorManager#getAllSensors()
	 */
	public List<Sensor> getAllSensors() {
		
//		List<Rule> rules = ruleManager.getSensorRules(1L);
		List<Sensor> sensors = sensorDao.readAllOrderByNameAsc();
		
//		Sensor bedRoomThermometer = new Sensor();
//		bedRoomThermometer.setId(1L);
//		bedRoomThermometer.setName("Bedroom Thermometer");
//		bedRoomThermometer.setMeasure("Temperature");
//		bedRoomThermometer.setType("Thermometer");
//		bedRoomThermometer.setUnit("Cel");
//		bedRoomThermometer.setValue(19);
//		bedRoomThermometer.getRules().addAll(rules);
//		sensors.add(bedRoomThermometer);
//		
//		Sensor salonThermometer = new Sensor();
//		salonThermometer.setId(2L);
//		salonThermometer.setName("Living room Thermometer");
//		salonThermometer.setMeasure("Temperature");
//		salonThermometer.setType("Thermometer");
//		salonThermometer.setUnit("Cel");
//		salonThermometer.setValue(19);
//		salonThermometer.getRules().addAll(rules);
//		sensors.add(salonThermometer);
		return sensors;
	}

	@Override
	public void createNewSensor(Sensor sensor) {
		//TODO : Implement the semantic creation of rules on the creation of a sensor
		sensorDao.save(sensor);
	}
}
