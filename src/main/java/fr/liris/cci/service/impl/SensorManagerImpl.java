package fr.liris.cci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.liris.cci.model.Rule;
import fr.liris.cci.model.Sensor;
import fr.liris.cci.service.RuleManager;
import fr.liris.cci.service.SensorManager;

@Service
public class SensorManagerImpl implements SensorManager {
	
	@Autowired
	private RuleManager ruleManager;

	/*
	 * (non-Javadoc)
	 * @see fr.liris.cci.service.SensorManager#getAllSensors()
	 */
	public List<Sensor> getAllSensors() {
		
		List<Rule> rules = ruleManager.getSensorRules(1L);
		List<Sensor> sensors = new ArrayList<Sensor>();
		
		Sensor bedRoomThermometer = new Sensor();
		bedRoomThermometer.setId(1L);
		bedRoomThermometer.setName("Bedroom Thermometer");
		bedRoomThermometer.setMeasure("Temperature");
		bedRoomThermometer.setType("Thermometer");
		bedRoomThermometer.setUnit("Cel");
		bedRoomThermometer.setValue(19);
		bedRoomThermometer.getRules().addAll(rules);
		sensors.add(bedRoomThermometer);
		
		Sensor salonThermometer = new Sensor();
		salonThermometer.setId(2L);
		salonThermometer.setName("Living room Thermometer");
		salonThermometer.setMeasure("Temperature");
		salonThermometer.setType("Thermometer");
		salonThermometer.setUnit("Cel");
		salonThermometer.setValue(19);
		salonThermometer.getRules().addAll(rules);
		sensors.add(salonThermometer);
		return sensors;
	}

	@Override
	public void createNewSensor(Sensor sensor) {
		// TODO Auto-generated method stub
	}
}
