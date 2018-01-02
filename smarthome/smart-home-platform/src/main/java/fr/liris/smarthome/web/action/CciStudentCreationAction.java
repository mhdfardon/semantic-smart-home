package fr.liris.smarthome.web.action;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.smarthome.data.StudentDao;
import fr.liris.smarthome.model.Student;

public class CciStudentCreationAction extends GenericAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6715800287017769366L;

	private static final Logger logger = LoggerFactory.getLogger(CciStudentAction.class);
	
	@Autowired
	private StudentDao studentDao;

	private Long studentId;
	private String studentNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String motif;
	private String langagesProgrammation;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getLangagesProgrammation() {
		return langagesProgrammation;
	}

	public void setLangagesProgrammation(String langagesProgrammation) {
		this.langagesProgrammation = langagesProgrammation;
	}

	public String execute() {
		logger.debug("START CciStudentAction");
		try {
			return Action.SUCCESS;
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.SUCCESS;
		}
	}

	public String createStudent() {
		logger.debug("START createStudent");
		try {
			Student student = new Student(null, studentNumber, firstName, lastName, email, motif, langagesProgrammation);
			studentDao.save(student);
			return Action.SUCCESS;
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.SUCCESS;
		}
	}
}
