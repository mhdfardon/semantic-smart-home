<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/sideline/header/head.jsp" />
<link href="/ccidemo/sideline/style/userAccess.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/ccidemo/sideline/js/encrypt.js'></script>
<script type='text/javascript' src='/ccidemo/pages/userAccess/js/userAccess.js'></script>
<title>User Access Page</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>Page d'authentification</h2>
	<center>
		<s:form action="cciBoardAction">
			<s:hidden name="encryptedPassword" value="" />
			<s:textfield name="userId" label="Utilisateur" />
		</s:form>
		<button id="loginButton">Login</button>
	</center>
</body>
</html>