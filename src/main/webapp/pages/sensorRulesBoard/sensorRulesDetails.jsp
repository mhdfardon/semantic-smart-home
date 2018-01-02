<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<input type="hidden" name="studentId" id="studentId" value="<s:property value="student.id" />" />
<ul>
	<li>
		<label for="studentNumber"><b>Num&eacute;ro :
		</b></label> <input type="text" name="studentNumber" 
		id="studentNumber" value="<s:property value="student.studentNumber" />"  />
	</li>
	<li>
		<label for="firstName"><b>Pr&eacute;nom :
		</b></label> <input type="text" name="firstName" 
		id="firstName" value="<s:property value="student.firstName" />"  />
	</li>
	<li>
		<label for="lastName"><b>NOM :
		</b></label> <input type="text" name="lastName" 
		id="lastName" value="<s:property value="student.lastName" />"  />
	</li>
	<li>
		<label for="email"><b>Email :
		</b></label> <input class="email" type="text" name="email" 
		id="email" value="<s:property value="student.email" />"  />
	</li>
	<li>
		<label for="langagesProgrammation"><b>Langages de programmation :
		</b></label> <input type="text" name="langagesProgrammation" 
		id="langagesProgrammation" value="<s:property value="student.langagesProgrammation" />"  />
	</li>			
</ul>