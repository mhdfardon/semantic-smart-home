package fr.liris.smarthome.service;

import java.util.List;

import fr.liris.smarthome.model.Actuator;

public interface ActuatorManager {
	
	public List<Actuator> getAllActuators();
	
	public Actuator getById(Long id);
	
	public void createNewActuator(Actuator actuator);
}
