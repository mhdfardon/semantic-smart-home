package fr.liris.smarthome.data;

import java.util.List;

import org.synyx.hades.dao.GenericDao;
import org.synyx.hades.dao.Query;

import fr.liris.smarthome.model.Student;

public interface StudentDao extends GenericDao<Student, Long> {
	
	/**
	 * Find all students
	 * @return the list of all users
	 */
	@Query("from Student order by lastName asc")
	public List<Student> readAllOrderByNameAsc();

}
