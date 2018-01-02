package fr.liris.cci.service;

import java.util.List;

import fr.liris.cci.model.Actuator;

public interface ActuatorManager {
	
	public List<Actuator> getAllActuators();
	
	public void createNewActuator(Actuator actuator);
}
