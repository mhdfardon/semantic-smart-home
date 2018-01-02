<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/sideline/header/head.jsp" />
<link href="/smarthomedemo/sideline/style/cciBoard.css" rel="stylesheet"
	type="text/css" />
<script type='text/javascript'
	src='/smarthomedemo/pages/sensorRule/js/sensorRule.js'></script>
<title>Configuration of actions on rule</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>Configuration of actions on rule</h2>
	<jsp:include page="/sideline/header/menu.jsp" />

	<div id="mainContent">

		<div id="searchCriteriaDiv"
			firstName="<s:property value="firstName"/>"
			lastName="<s:property value="lastName"/>"
			studentNumber="<s:property value="studentNumber"/>">
		</div>

		<ul>
			<li>
				<label for="sensorName"><b>Sensor Name :
				</b><s:property value="rule.sensor.name" /></label>
			</li>
			<li>
				<label for="sensorMeasure"><b>Sensor Measure :
				</b><s:property value="rule.sensor.measure" /></label>
			</li>
			<li>
				<label for="sensorType"><b>Sensor Type :
				</b></b><s:property value="rule.sensor.type" /></label>
			</li>
			<li>
				<label for="sensorUnit"><b>Sensor Unit :
				</b></b><s:property value="rule.sensor.unit" /></label>
			</li>
		</ul>
		<ul>
			<li>
				<label for="ruleName"><b>Rule Name :
				</b><s:property value="rule.name" /></label>
			</li>
			<li>
				<label for="inferenceType"><b>Rule Inference Type :
				</b><s:property value="rule.inferenceType" /></label>
			</li>
			<li>
				<label for="deduce"><b>Deducing :
				</b></b><s:property value="rule.deduce" /></label>
			</li>
			<li>
				<label for="suggest"><b>Suggesting :
				</b></b><s:property value="rule.suggest" /></label>
			</li>
		</ul>

				<br>
				<br>
				<br>
				<br>
		<label for="sensorType"><b>Actions on this rule :</b></label>
				<br>
		<div id="ruleActionsTableTableDiv">
			<s:if test="rule.ruleActions.size() > 0">
				<table id="ruleActionsTable">
					<thead>
						<tr>
							<th class="actionLabel">Action Label</th>
							<th class="actuator">Actuator</th>
							<th class="actionStatus">Status</th>
							<th class="actionValue">Value</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="rule.ruleActions" status="stat">
							<tr class="ligne<s:property value="#stat.index % 2"/>" >
								<td class="actionLabel"><s:property value="label" /></td>
								<td class="actuator"><s:property value="actuator.name" /></td>
								<td class="actionStatus"><s:property value="status" /></td>
								<td class="actionValue"><s:property value="value" /></td>
							</tr>
						</s:iterator>
					</tbody>
					<tfoot></tfoot>
				</table>
			</s:if>
			<s:else>
				There are no actions for this rule
			</s:else>
		</div>
		
		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div id="ruleActionCreationDiv">
			<form name="ruleActionCreationForm" method="post" id="ruleActionCreationForm" action="ruleActionCreationAction.action">
				<input type="hidden" name="ruleId" id="ruleId" value="<s:property value="rule.id" />" />
				<ul>
					<li>
						<label for="actionLabel"><b>Action Label :
						</b></label> <input type="text" name="actionLabel" id="actionLabel" value=""  />
					</li>
					<li>
						<label for="sensorMeasure"><b>Actuator :
						</b></label><select id="actionActuatorId" name="actionActuatorId">
							<option value="noActuator" selected>
							</option>
							<s:iterator value="actuators" var="actionActuator">
								<option value="<s:property value="id" />">
									<s:property value="name"/>
								</option>
							</s:iterator>
						</select>
					</li>
					<li>
						<label for="sensorType"><b>Turn Device On / Off :
						</b></label> <select id="actionStatus" name="actionStatus">
							<option value="ON" selected>
								ON
							</option>
							<option value="OFF">
								OFF
							</option>
						</select>
					</li>
					<li>
						<label for="sensorUnit"><b>Set Value of Device :
						</b></label> <input type="number" name="actionValue" id="actionValue" value=""  />
					</li>
				</ul>
				<button type="submit">Validate</button>
			</form>
		</div>
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		<br>&nbsp;
		
	
	</div>
	
	<div id="studentDeployDiv">
		</div>
	<div id="footerDiv">
	</div>
	
</body>
</html>