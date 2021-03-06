package fr.liris.cci.data;

import java.util.List;

import org.synyx.hades.dao.GenericDao;
import org.synyx.hades.dao.Query;

import fr.liris.cci.model.User;

public interface UserDao extends GenericDao<User, Long> {
	
	/**
	 * Find all users
	 * @return the list of all users
	 */
	@Query("from User order by name asc")
	public List<User> readAllOrderByNameAsc();
}