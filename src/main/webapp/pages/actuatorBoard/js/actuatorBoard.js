/**
 * @author fardon
 */
$(document).ready(function() {
	
	$('.datePicker').datepicker({
		dateFormat: 'dd/mm/yy',
//		minDate: 0,
		changeMonth: true,
		changeYear: true
//		hideIfNoPrevNext: true
	});
	

	$('#studentsTable').dataTable({
		"bSort": false,
		"iDisplayLength" : 10,
		"bFilter": true,
		"bJQueryUI": true,
		"bAutoWidth": true,
		"sPaginationType": "full_numbers",
		"oLanguage": {
			"sProcessing":   "Traitement en cours...",
			"sLengthMenu":   "Afficher _MENU_ \351l\351ments",
			"sZeroRecords":  "Aucun \351l\351ment \340  afficher",
			"sInfo":         "Affichage de l'\351l\351ment _START_ \340 _END_ sur _TOTAL_ \351l\351ments",
			"sInfoEmpty":    "Affichage de l'\351l\351ment 0 Ã  0 sur 0 \351l\351ments",
			"sInfoFiltered": "(filtr\351 de _MAX_ \351l\351ments au total)",
			"sInfoPostFix":  "",
			"sSearch":       "Rechercher :",
			"sUrl":          "",
			"oPaginate": {
				"sFirst":    "Premier",
				"sPrevious": "Pr\351c\351dent",
				"sNext":     "Suivant",
				"sLast":     "Dernier"
			}
		},
		"bScrollCollapse": true,
		"bPaginate": true
	});
	
	$('.loadStudent2').live("click",function() {
		// Calling : http://localhost:8080/ccidemo/jersey/CciBoard/getStudents
		var url = "/ccidemo/jersey/CciBoard/getStudents?";
		$.ajax({
			async: false,
			type: "GET",
			url: url,
			processData: true,
			cache: false,
			success: function(data, text, jqXHR) {
				if(jqXHR.status == 200) {
					alert(data);
					$("#studentDeployDiv").html(data);
					//	Hide ajax load page
					hideWaitScreen();
					$(thisDialog).dialog( "close" );
					alertPopup("Les donn\351es ont bien \351t\351 mises \340 jour..", "Etudiant mis \340 jour", false, "#1E639A");
					document.itemDetailsForm.submit();
				}
				else {
					//	Hide ajax load page
					hideWaitScreen();
					$(thisDialog).dialog( "close" );
					alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", true, "red");
				}
			},
			error: function(jqXHR, text, errorThrown) {
					hideWaitScreen();
					alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", false, "red");
					location.reload(true);
//				}
			}
		});
	});

	/**
	 * Listener on the fields, 
	 * enable the writing on the field, 
	 * changez the button to prepare the update of the fields.
	 */
	$('.loadStudent').live("click",function() {

		showWaitScreen();
		var studentId = $(this).attr('studentId');
		loadStudent(studentId);

		$('#studentDeployDiv').dialog({
			height: 400,
			bgiframe: true,
			resizable: false,
			width: 450,
			modal: true,
			title: "D\351tails de l'\351tudiant",
			buttons: {
				Valider: function() {
					showWaitScreen();
					var thisDialog = this;
					var studentId = $('#studentId').val();
					var studentNumber = $('#studentNumber').val();
					var firstName = $('#firstName').val();
					var lastName = $('#lastName').val();
					var email = $('#email').val();
					var langagesProgrammation = $('#langagesProgrammation').val();
					
					/*
					 * Jersey Call to update
					 */
					var url = "/ccidemo/jersey/CciBoard/updateStudentInfos?studentId=" + studentId + 
												"&studentNumber=" + studentNumber +
												"&firstName=" + firstName + "&lastName=" + lastName + 
											"&email=" + email + "&langagesProgrammation=" + langagesProgrammation;
					$.ajax({
						async: false,
						type: "GET",
						url: url,
						processData: true,
						cache: false,
						success: function(data, text, jqXHR) {
							if(jqXHR.status == 200) {
								//	Hide ajax load page
								hideWaitScreen();
								$(thisDialog).dialog( "close" );
								alertPopup("Les donn\351es ont bien \351t\351 mises \340 jour..", "Etudiant mis \340 jour", false, "#1E639A");
								document.itemDetailsForm.submit();
							}
							else {
								//	Hide ajax load page
								hideWaitScreen();
								$(thisDialog).dialog( "close" );
								alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", true, "red");
							}
						},
						error: function(jqXHR, text, errorThrown) {
								hideWaitScreen();
								alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", false, "red");
								location.reload(true);
//							}
						}
					});
				},
				Fermer: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
});

/**
 * Popup to load the item details for update
 * 
 * @param {Object} itemId The ID of the item
 */
function loadStudent(studentId) {
	//	Calling struts action to inject the data in the div
	$.ajax({
		type: "POST",
		async: false,
		url: "/ccidemo/pages/userAccess/studentDetailsAction.action",
		data: "studentId=" + studentId,
		timeout : 12000,
		cache: false,
		dataType: "html",
		error: function(jqXHR, text, errorThrown) {
			studentId(jqXHR.status);
			if(jqXHR.status == 500) {
				hideWaitScreen();
				alert("La session est expir\351e");
				window.location = "/ccidemo/pages/userAccess/userAccess.jsp";
			}
			else {
				hideWaitScreen();
				alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", false, "red");
				location.reload(true);

			}
		},
		success: function(data) {
//			alert("Success");
			hideWaitScreen();
			$("#studentDeployDiv").html(data);
		}
	});
}