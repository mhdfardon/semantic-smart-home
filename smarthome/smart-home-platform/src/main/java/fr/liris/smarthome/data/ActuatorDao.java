package fr.liris.smarthome.data;

import java.util.List;

import org.synyx.hades.dao.GenericDao;
import org.synyx.hades.dao.Query;

import fr.liris.smarthome.model.Actuator;

public interface ActuatorDao extends GenericDao<Actuator, Long> {

	@Query("from Actuator order by name asc")
	public List<Actuator> readAllOrderByNameAsc();

}
