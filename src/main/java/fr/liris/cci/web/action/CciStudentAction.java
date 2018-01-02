package fr.liris.cci.web.action;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.cci.model.Student;
import fr.liris.cci.service.UserManager;

public class CciStudentAction extends GenericAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6715800287017769366L;


	private static final Logger logger = LoggerFactory.getLogger(CciStudentAction.class);
	
	@Autowired
	public UserManager userManager;
	
	private Long studentId;

	private Student student;
	
	public String execute() {
		logger.debug("START CciStudentAction");
		try {
			student = userManager.getStudentById(studentId);
			return Action.SUCCESS;
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.SUCCESS;
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
}
