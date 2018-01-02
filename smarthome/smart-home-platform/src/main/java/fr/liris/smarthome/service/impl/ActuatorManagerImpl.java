package fr.liris.smarthome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.liris.smarthome.data.ActuatorDao;
import fr.liris.smarthome.model.Actuator;
import fr.liris.smarthome.service.ActuatorManager;

@Service("actuatorManager")
@Transactional
public class ActuatorManagerImpl implements ActuatorManager {
	
	@Autowired
	private ActuatorDao actuatorDao;

	/*
	 * (non-Javadoc)
	 * @see fr.liris.smarthome.service.ActuatorManager#getAllActuators()
	 */
	public List<Actuator> getAllActuators() {
		List<Actuator> actuators = actuatorDao.readAllOrderByNameAsc();
		return actuators;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.liris.smarthome.service.ActuatorManager#createNewActuator(fr.liris.smarthome.model.Actuator)
	 */
	public void createNewActuator(Actuator actuator) {
		actuatorDao.save(actuator);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.liris.smarthome.service.ActuatorManager#getById(java.lang.Long)
	 */
	public Actuator getById(Long id) {
		return actuatorDao.readByPrimaryKey(id);
	}

}
