<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/sideline/header/head.jsp" />
<link href="/ccidemo/sideline/style/studentCreation.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/ccidemo/pages/studentCreation/js/studentCreation.js'></script>
<title>Nouveau &eacute;tudiant</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>Liste des &eacute;tudiants en M2 CCI</h2>
	<jsp:include page="/sideline/header/menu.jsp" />
	
	<div id="mainContent">
		<div class="pageTitleDiv">
			<span class="pageTitle">Remplir les donn&eacute;es du nouveau
				&eacute;tudiant</span>
		</div>
		<div id="studentCreationDiv">
			<s:form name="studentCreationForm" method="post"
				id="studentCreationForm" action="studentCreationAction.action">
				<table id="studentCreationTable">
					<tr>
						<td class="right">
							<div class="fillDetailDiv">
								<span class="fillDetailTitle">Numb&eacute;ro &eacute;tudiant</span>
							</div>
						</td>
						<td class="left">
							<input type="text" name="studentNumber" id="studentNumber" />
						</td>
					</tr>
					<tr>
						<td class="right">
							<div class="fillDetailDiv">
								<span class="fillDetailTitle">Pr&eacute;nom</span>
							</div>
						</td>
						<td class="left">
							<input type="text" name="firstName" id="firstName" />
						</td>
					</tr>
					<tr>
						<td class="right">
							<div class="fillDetailDiv">
								<span class="fillDetailTitle">Nom</span>
							</div>
						</td>
						<td class="left">
							<input type="text" name="lastName" id="lastName" />
						</td>
					</tr>
					<tr>
						<td class="right">
							<div class="fillDetailDiv">
								<span class="fillDetailTitle">Email</span>
							</div>
						</td>
						<td class="left">
							<input type="text" name="email" id="email" />
						</td>
					</tr>
					<tr>
						<td class="right">
							<div class="fillDetailDiv">
								<span class="fillDetailTitle">Langages de programmation</span>
							</div>
						</td>
						<td class="left">
							<input type="text" name="langagesProgrammation" id="langagesProgrammation" />
						</td>
					</tr>
					<tr>
						<td class="right">
							<div class="fillDetailDiv">
								<span class="fillDetailTitle">Formations</span>
							</div>
						</td>
						<td class="left">
							<input type="text" name="formation" id="formation" />
						</td>
					</tr>
					<tr>
						<td class="right">
							<div class="fillDetailDiv">
								<span class="fillDetailTitle">Motif</span>
							</div>
						</td>
						<td class="left">
							<input type="text" name="motif" id="motif" />
						</td>
					</tr>
					
				</table>
				<s:submit></s:submit>
			</s:form>
		</div>
	</div>