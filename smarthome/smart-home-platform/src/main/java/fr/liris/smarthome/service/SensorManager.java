package fr.liris.smarthome.service;

import java.util.List;

import fr.liris.smarthome.model.Sensor;

public interface SensorManager {
	
	public List<Sensor> getAllSensors();
	
	public void createNewSensor(Sensor sensor);
}
