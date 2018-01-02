<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/sideline/header/head.jsp" />
<link href="/smarthomedemo/sideline/style/newSensor.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/smarthomedemo/pages/newSensor/js/newSensor.js'></script>
<title>Create New Sensor</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>Create New Sensor</h2>
	<jsp:include page="/sideline/header/menu.jsp" />

	
	<form name="newSensorForm" method="post" id="newSensorForm" action="createSensorAction.action">
		<input type="hidden" name="studentId" id="studentId" value="<s:property value="student.id" />" />
		<ul>
			<li>
				<label for="sensorName"><b>Sensor Name :
				</b></label> <input type="text" name="sensorName" id="sensorName" value=""  />
			</li>
			<li>
				<label for="sensorMeasure"><b>Sensor Measure :
				</b></label> <input type="text" name="sensorMeasure" id="sensorMeasure" value=""  />
			</li>
			<li>
				<label for="sensorType"><b>Sensor Type :
				</b></label> <input type="text" name="sensorType" id="sensorType" value=""  />
			</li>
			<li>
				<label for="sensorUnit"><b>Sensor Unit :
				</b></label> <input type="text" name="sensorUnit" id="sensorUnit" value=""  />
			</li>
		</ul>
		<button type="submit">Validate</button>
	</form>
</body>
</html>