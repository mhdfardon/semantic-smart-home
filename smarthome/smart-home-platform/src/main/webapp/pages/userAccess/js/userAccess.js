/**
 * @author fardon
 */
$(document).ready(function() {
	$('#loginButton').live("click",function() {
//		var encryptedPassword = $('#cciBoardAction_password').attr('value');
//		encryptedPassword = encrypt(encryptedPassword);
//		$('#accessAction_encryptedPassword').attr('value', encryptedPassword);
		document.cciBoardAction.submit();
	});
});