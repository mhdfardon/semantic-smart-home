package fr.liris.smarthome.web.jersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.JResponse;
import com.sun.jersey.spi.resource.PerRequest;

import fr.liris.smarthome.model.Student;
import fr.liris.smarthome.service.UserManager;

@Path("/CciBoard/")
@PerRequest
@Component
public class CciBoardResource {

	/**
	 * Reference on class logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CciBoardResource.class);

	@Autowired
	private UserManager studentManager;

	/**
	 * 
	 * @param studentId
	 * @param studentNumber
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param langagesProgrammation
	 * @return
	 */
	@GET
	@Path("/updateStudentInfos")
	@Produces("application/json")
	public Response updateStudentInfos(
			@QueryParam("studentId") Long studentId,
			@QueryParam("studentNumber") String studentNumber,
			@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName,
			@QueryParam("email") String email,
			@QueryParam("langagesProgrammation") String langagesProgrammation) {
		try {
			Student student = new Student(studentId, studentNumber, firstName, lastName, email, null, langagesProgrammation);
			studentManager.updateStudentInfos(student);

			logger.debug("MAJ OK");
			return Response.status(200).entity("OK").type("text/html").build();
		}
		catch (Exception e) {
			logger.error("SQL Connection failure : {}", e.getMessage());
			return Response.status(409).entity("NOK").type("text/html").build();
		}
	}
	
	@GET
	@Path("/getStudents")
	@Produces("application/json")
	public Response getStudents() {
		try {
			
			List<Student> students = studentManager.getAllStudents();

			logger.debug("MAJ OK : " + students.size());
			return Response.status(200).entity(students).type("text/html").build();
		}
		catch (Exception e) {
			logger.error("SQL Connection failure : {}", e.getMessage());
			return Response.status(409).entity("NOK").type("text/html").build();
		}
	}
	
	@GET
	@Path("/getStudents2")
	@Produces(MediaType.TEXT_XML)
	public List<Student> getStudents2() {
		try {
			
			List<Student> students = studentManager.getAllStudents();

			logger.debug("MAJ OK : " + students.size());
			return students;
		}
		catch (Exception e) {
			logger.error("SQL Connection failure : {}", e.getMessage());
			return null;
//			return Response.status(409).entity("NOK").type("text/html").build();
		}
	}
	
	@GET
	@Path("/getStudents3")
	@Produces(MediaType.APPLICATION_JSON)
	public JResponse<List<Student>> getStudents3() {
		try {
			
			List<Student> students = studentManager.getAllStudents();

			logger.debug("MAJ OK : " + students.size());
			return JResponse.ok(students).build();
		}
		catch (Exception e) {
			logger.error("SQL Connection failure : {}", e.getMessage());
			return null;
//			return Response.status(409).entity("NOK").type("text/html").build();
		}
	}
	
	@GET
	@Path("/getStudents4")
	@Produces(MediaType.APPLICATION_JSON)
	public JResponse<List<Student>> getStudents4() {
		try {
			
			List<Student> students = studentManager.getAllStudents();
			
			logger.debug("MAJ OK : " + students.size());
//			GenericEntity<List<Student>> entity = new GenericEntity<List<Student>>(students) {};
			GenericEntity<List<Student>> entity = new GenericEntity<List<Student>>(students) {};
			JResponse response = JResponse.ok().entity(entity).build();
			return response;
		}
		catch (Exception e) {
			logger.error("SQL Connection failure : {}", e.getMessage());
			return null;
//			return Response.status(409).entity("NOK").type("text/html").build();
		}
	}
	
	@GET
	@Path("/getStudents5")
	@Produces(MediaType.APPLICATION_JSON)
	public JResponse<List<Student>> getStudents5() {
		try {
			
			List<Student> students = studentManager.getAllStudents();

			logger.debug("MAJ OK : " + students.size());
			GenericEntity<List<Student>> entity = new GenericEntity<List<Student>>(students) {};
			JResponse response = JResponse.ok(entity).build();
			return response;
		}
		catch (Exception e) {
			logger.error("SQL Connection failure : {}", e.getMessage());
			return null;
//			return Response.status(409).entity("NOK").type("text/html").build();
		}
	}
}