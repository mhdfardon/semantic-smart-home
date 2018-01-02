package fr.liris.cci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.liris.cci.model.Actuator;
import fr.liris.cci.service.ActuatorManager;

@Service("actuatorManager")
@Transactional
public class ActuatorManagerImpl implements ActuatorManager {

	/*
	 * (non-Javadoc)
	 * @see fr.liris.cci.service.ActuatorManager#getAllActuators()
	 */
	public List<Actuator> getAllActuators() {
		List<Actuator> actuators = new ArrayList<Actuator>();
		
		Actuator actuator = new Actuator();
		actuator.setId(1L);
		actuator.setName("BedRoom Air Conditionner");
		actuators.add(actuator);
		
		actuator = new Actuator();
		actuator.setId(2L);
		actuator.setName("Living Room Air Conditionner");
		actuators.add(actuator);
		
		actuator = new Actuator();
		actuator.setId(3L);
		actuator.setName("Central Heater");
		actuators.add(actuator);
		
		return actuators;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.liris.cci.service.ActuatorManager#createNewActuator(fr.liris.cci.model.Actuator)
	 */
	public void createNewActuator(Actuator actuator) {
		// TODO Auto-generated method stub
	}

}
