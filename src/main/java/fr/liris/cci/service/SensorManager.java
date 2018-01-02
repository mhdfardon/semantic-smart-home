package fr.liris.cci.service;

import java.util.List;

import fr.liris.cci.model.Sensor;

public interface SensorManager {
	
	public List<Sensor> getAllSensors();
	
	public void createNewSensor(Sensor sensor);
}
