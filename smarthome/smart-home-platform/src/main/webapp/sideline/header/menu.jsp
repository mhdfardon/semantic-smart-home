<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="menu_heading">
	<ul id="navigation">
		<li class="enTete">
			<div class="headingBlock">
				<div class="headingPuce"></div>
				<div class="headingLabel">Semantic Smart Home</div>
			</div>
			<ul class="Menu">
				<li>
					<s:url id="url" action="sensorBoardAction"></s:url>
					<s:a href="%{url}">Sensors Board</s:a>
				</li>
				<li>
					<s:url id="url" action="actuatorBoardAction"></s:url>
					<s:a href="%{url}">Actuators Board</s:a>
				</li>
				<li>
					<s:url id="url" action="newSensorAction"></s:url>
					<s:a href="%{url}">Create New Sensor</s:a>
				</li>
				<li>
					<s:url id="url" action="newActuatorAction"></s:url>
					<s:a href="%{url}">Create New Actuator</s:a>
				</li>
			</ul>
		</li>
	</ul>
</div>