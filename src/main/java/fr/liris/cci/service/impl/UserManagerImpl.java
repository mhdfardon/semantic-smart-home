package fr.liris.cci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.liris.cci.model.Student;
import fr.liris.cci.model.User;
import fr.liris.cci.service.UserManager;


@Service("userManager")
@Transactional
public class UserManagerImpl implements UserManager {

//	@Autowired
//	private UserDao userDao;
//
//	@Autowired
//	private StudentDao studentDao;

	public User getById(Long id) {
//		User user = userDao.readByPrimaryKey(id);
//		return user;
		return null;
	}


	public List<User> readAllOrderByDateAsc() {
//		List<User> userList = userDao.readAllOrderByNameAsc();
		List<User> userList = new ArrayList<User>();
		userList.add(new User("mohamad",null,null));
		userList.add(new User("Achraf",null,null));
		userList.add(new User("Catarina",null,null));
		return userList;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.liris.cci.service.UserManager#getAllStudents()
	 */
	public List<Student> getAllStudents() {
//		List<Student> students = studentDao.readAllOrderByNameAsc();
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1L,"n1","Mohamad","Fardon","email", "PHD", "Java"));
		studentList.add(new Student(1L,"n1","Mohamad2","Fardon","email", "PHD", "Java"));
		studentList.add(new Student(1L,"n1","Mohamad3","Fardon","email", "PHD", "Java"));
		return studentList;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.liris.cci.service.UserManager#getStudentById(java.lang.Long)
	 */
	public Student getStudentById(Long id) {
//		return studentDao.readByPrimaryKey(id);
		return new Student(1L,"n1","Mohamad","Fardon","email", "PHD", "Java");
	}
	
	public void updateStudentInfos(Student newStudent) {
//		Student dbStudent = studentDao.readByPrimaryKey(newStudent.getId());
//		dbStudent.setStudentNumber(newStudent.getStudentNumber());
//		dbStudent.setFirstName(newStudent.getFirstName());
//		dbStudent.setLastName(newStudent.getLastName());
//		dbStudent.setEmail(newStudent.getEmail());
//		dbStudent.setLangagesProgrammation(newStudent.getLangagesProgrammation());
	}
	
}