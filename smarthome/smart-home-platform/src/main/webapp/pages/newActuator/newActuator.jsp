<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/sideline/header/head.jsp" />
<link href="/smarthomedemo/sideline/style/newActuator.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/smarthomedemo/pages/newActuator/js/newActuator.js'></script>
<title>Create New Actuator</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>Create New Actuator</h2>
	<jsp:include page="/sideline/header/menu.jsp" />

	
	<form name="newActuatorForm" method="post" id="newActuatorForm" action="createActuatorAction.action">
<%-- 		<input type="hidden" name="actuatorId" id="studentId" value="<s:property value="actuator.id" />" /> --%>
		<ul>
			<li>
				<label for="actuatorName"><b>Actuator Name :
				</b></label> <input type="text" name="actuatorName" id="actuatorName" value=""  />
			</li>
			<li>
				<label for="actuatorDescription"><b>Actuator Description :
				</b></label> <input type="text" name="actuatorDescription" id="actuatorDescription" value=""  />
			</li>
		</ul>
		<button type="submit">Validate</button>
	</form>
</body>
</html>