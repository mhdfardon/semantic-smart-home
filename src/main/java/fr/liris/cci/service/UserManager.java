package fr.liris.cci.service;

import java.util.List;

import fr.liris.cci.model.Student;
import fr.liris.cci.model.User;

public interface UserManager {
	
	/**
	 * Find item by id
	 * 
	 * @param id
	 * @return the item
	 */
	public User getById(Long id);
	
	/**
	 * Find all users
	 * @return the list of all users
	 */
	public List<User> readAllOrderByDateAsc();
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Long id);

	public void updateStudentInfos(Student student);
}
