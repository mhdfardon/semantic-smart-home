package fr.liris.cci.web.action;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import fr.liris.cci.model.Student;
import fr.liris.cci.service.UserManager;

public class CciBoardAction extends GenericAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1301128888702373969L;
	
	private static final Logger logger = LoggerFactory.getLogger(CciBoardAction.class);
	

	@Autowired
	public UserManager userManager;
	
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public String execute() {
		logger.debug("START execute");
		try {
			students = userManager.getAllStudents();
			return Action.SUCCESS;

		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.SUCCESS;
		}
	}

	public String load() {
		try {
			logger.debug("START LOAD");
			students = userManager.getAllStudents();
			return Action.SUCCESS;
		}
		catch(Exception e) {
			logger.error("Exception in ACTION LOAD : {}", e.getMessage());
			return Action.ERROR;
		}
	}

}
