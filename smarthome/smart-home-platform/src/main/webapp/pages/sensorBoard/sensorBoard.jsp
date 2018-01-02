<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/sideline/header/head.jsp" />
<link href="/smarthomedemo/sideline/style/sensorBoard.css" rel="stylesheet"
	type="text/css" />
<script type='text/javascript'
	src='/smarthomedemo/pages/sensorBoard/js/sensorBoard.js'></script>
<title>Sensors Board</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>Sensors board</h2>
	<jsp:include page="/sideline/header/menu.jsp" />

	<div id="mainContent">

		<div id="searchCriteriaDiv"
			name="<s:property value="name"/>"
			type="<s:property value="type"/>"
			measure="<s:property value="measure"/>">
		</div>

		<div id="sensorsTableDiv">
			<s:if test="sensors.size() > 0">
				<table id="sensorsTable">
					<thead>
						<tr>
							<th class="name">Sensor Name</th>
							<th class="type">Type</th>
							<th class="measure">Measure</th>
							<th class="unit">Unit</th>
							<th class="rules">Rules</th>
							<th class="rules">Rules Actions Configuration</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="sensors" status="stat">
							<tr class="ligne<s:property value="#stat.index % 2"/>" >
								<td class="name"><s:property value="name" /></td>
								<td class="type"><s:property value="type" /></td>
								<td class="measure"><s:property value="measure" /></td>
								<td class="unit"><s:property value="unit" /></td>
								<td class="rules">
									<s:iterator value="rules">
										<s:property value="inferenceType" /> -> <s:property value="deduce" /> -> <s:property value="suggest" />
										<br>
									</s:iterator>
								</td>
								<td class="rulesConfigure">
									<s:iterator value="rules">
										<s:url id="url" action="ruleAction">
											<s:param name="ruleId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<s:a href="%{url}">Configure actions of this rule</s:a>
										<br>
									</s:iterator>
								</td>
							</tr>
						</s:iterator>
					</tbody>
					<tfoot></tfoot>
				</table>
			</s:if>
			<s:else>
				There are no sensors
			</s:else>
		</div>
	</div>
	<div id="sensorDeployDiv">
		</div>
	<div id="footerDiv">
	</div>
	<form name="sensorDetailsForm" method="post" id="sensorDetailsForm" action="accessAction.action">
	</form>
</body>
</html>