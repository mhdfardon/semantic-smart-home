<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="fullscreen"></div>
<div id="loading">
	<img alt="Chargement..."
		src="/smarthomedemo/sideline/images/ajaxLoad.gif">
</div>
<div id="alertPopup" align="center"></div>
<main class="mCenter">
<div id="header">
	<ul id="logged">
		<li id="who"><s:property value="session.userSession.userName" /></li>
		<li id="what"><s:url id="url" action="logoutAction"></s:url> <s:a
				href="%{url}">D&eacute;connexion</s:a></li>
	</ul>
	<h1>Semantic Smart Home</h1>
</div>
</main>