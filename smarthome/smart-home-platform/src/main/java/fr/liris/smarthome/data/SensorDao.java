package fr.liris.smarthome.data;

import java.util.List;

import org.synyx.hades.dao.GenericDao;
import org.synyx.hades.dao.Query;

import fr.liris.smarthome.model.Sensor;

public interface SensorDao extends GenericDao<Sensor, Long> {
	
	@Query("from Sensor order by name asc")
	public List<Sensor> readAllOrderByNameAsc();

}
