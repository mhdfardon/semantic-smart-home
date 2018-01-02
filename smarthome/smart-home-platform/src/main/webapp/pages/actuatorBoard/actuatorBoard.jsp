<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/sideline/header/head.jsp" />
<link href="/smarthomedemo/sideline/style/actuatorBoard.css" rel="stylesheet"
	type="text/css" />
<script type='text/javascript'
	src='/smarthomedemo/pages/actuatorBoard/js/actuatorBoard.js'></script>
<title>Actuators Board</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>Actuators board</h2>
	<jsp:include page="/sideline/header/menu.jsp" />

	<div id="mainContent">

		<div id="searchCriteriaDiv"
			name="<s:property value="name"/>"
			type="<s:property value="type"/>"
			measure="<s:property value="measure"/>">
		</div>

		<div id="actuatorsTableDiv">
			<s:if test="actuators.size() > 0">
				<table id="actuatorsTable">
					<thead>
						<tr>
							<th class="name">Actuator Name</th>
							<th class="description">Description</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="actuators" status="stat">
							<tr class="ligne<s:property value="#stat.index % 2"/>" >
								<td class="name"><s:property value="name" /></td>
								<td class="description"><s:property value="description" /></td>
							</tr>
						</s:iterator>
					</tbody>
					<tfoot></tfoot>
				</table>
			</s:if>
			<s:else>
				There are no actuators
			</s:else>
		</div>
	</div>
	<div id="actuatorDeployDiv">
		</div>
	<div id="footerDiv">
	</div>
	<form name="actuatorDetailsForm" method="post" id="actuatorDetailsForm" action="accessAction.action">
	</form>
</body>
</html>