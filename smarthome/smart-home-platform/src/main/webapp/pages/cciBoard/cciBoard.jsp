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
	src='/smarthomedemo/pages/cciBoard/js/cciBoard.js'></script>
<title>Tableau de bord des articles</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>Liste des &eacute;tudiants en M2 CCI</h2>
	<jsp:include page="/sideline/header/menu.jsp" />

	<div id="mainContent">

		<div id="searchCriteriaDiv"
			firstName="<s:property value="firstName"/>"
			lastName="<s:property value="lastName"/>"
			studentNumber="<s:property value="studentNumber"/>">
		</div>

		<div id="studentsTableDiv">
			<s:if test="students.size() > 0">
				<table id="studentsTable">
					<thead>
						<tr>
							<th class="studentNumber">Numero etudiant</th>
							<th class="firstName">Prenom</th>
							<th class="lastName">NOM</th>
							<th class="email">Email</th>
							<th class="formation">Formation</th>
							<th class="langagesProgrammation">langagesProgrammation</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="students" status="stat">
							<tr class="ligne<s:property value="#stat.index % 2"/>" >
								<td class="studentNumber">
									<div class="left">
										<s:property value="studentNumber" />
									</div>
									<div studentId="<s:property value="id" />"
										title="Voir les d&eacute;tails de l'&eacute;tudiant"
										class="loadStudent2">
									</div>
								</td>
								<td class="firstName"><s:property value="firstName" /></td>
								<td class="lastName"><s:property value="lastName" /></td>
								<td class="email"><s:property value="email" /></td>
								<td class="formation"><s:iterator value="formations">
										<s:property value="formationName" />
										<br>
									</s:iterator></td>
								<td class="langagesProgrammation"><s:property value="langagesProgrammation" /></td>
							</tr>
						</s:iterator>
					</tbody>
					<tfoot></tfoot>
				</table>
			</s:if>
			<s:else>
				Pas d'&eacute;tudiants
			</s:else>
		</div>
	</div>
	<div id="studentDeployDiv">
		</div>
	<div id="footerDiv">
	</div>
	<form name="studentDetailsForm" method="post" id="studentDetailsForm" action="accessAction.action">
	</form>
</body>
</html>