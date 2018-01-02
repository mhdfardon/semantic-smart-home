/**
 * @author fardon
 */
$(document).ready(function() {
	
	$('#totalsTable').hide();
	
	$('.datePicker').datepicker({
		dateFormat: 'dd/mm/yy',
// minDate: 0,
		changeMonth: true,
		changeYear: true
// hideIfNoPrevNext: true
	});
	
	/**
	 * Listener on the fields, enable the writing on the field, changez the
	 * button to prepare the update of the fields.
	 */
	$('#createNewClient').live("click",function() {

		showWaitScreen();

		$('#newClientPopupDiv').dialog({
			height: 1070,
			bgiframe: true,
			resizable: false,
			width: 650,
			modal: true,
			title: "Create new client",
			buttons: {
				Valider: function() {	// Fonction pour ajouter un nouveau code
										// postal
					showWaitScreen();
					var thisDialog = this;
					
					var shortName = $('#shortName').val();
					var fullName = $('#fullName').val();
					var address = $('#address').val();
					var city = $('#city').val();
					var country = $('#country').val();
					var website = $('#website').val();
					var fax = $('#fax').val();
					var tel = $('#tel').val();
					var email = $('#email').val();
					
// //var itemType = $('#itemType option:selected').text();
// var itemCategory = $('#itemCategory option:selected').val();
// //var itemSeason = $('#itemSeason option:selected').text();
// var itemUser = $('#itemUser option:selected').val();
					
					if(shortName == null || shortName == "") {
						// Hide ajax load page
						hideWaitScreen();
						alert("Please insert a short name !");
						return false;
					}
					
					/*
					 * Jersey Call to update an Item
					 */
					var url = "/invoice/jersey/Client/createNewClient?shortName=" + shortName + "&fullName=" + fullName
													+ "&address=" + address + "&city=" + city +  + "&country=" + country 
													+ "&website=" + website + "&fax=" + fax + "&tel=" + tel + "&email=" + email;
					$.ajax({
						async: false,
						type: "GET",
						url: url,
						processData: true,
						cache: false,
						success: function(data, text, jqXHR) {
							if(jqXHR.status == 200) {
								// Hide ajax load page
								hideWaitScreen();
								$(thisDialog).dialog( "close" );
								alertPopup("L'achat a bien \351t\351 mis \340 jour..", "Achat mis \340 jour", false, "#1E639A");
								loadClients();
							}
						},
						error: function(jqXHR, text, errorThrown) {
							// Hide ajax load page
							hideWaitScreen();
							alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", false, "red");
							location.reload(true);
						}
					});
				},
				Annuler: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});

	$('#itemsListTable').dataTable({
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
// "bPaginate": tue,
// "bInfo" : false,
// "aaSorting": [[ 2, "asc" ]],
// "aoColumns" : [
// null,
// null,
// { "sType" : "date-euro" },
// null,
// null,
// null,
// null,
// null,
// null
// ],
// "sScrollY": "250px",
		"bScrollCollapse": true,
		"bPaginate": true
	});
// oTable.fnDraw();

	$('#submit').live("click",function() {
		var userId = $('#userIdSelect :selected').val();
		
		if(userId == "noUser") {
			userId = 0;
		}
		document.itemSearchForm.action = "itemBoardAction.action";
		document.itemSearchForm.submit();
	});
	
	$('#showHideIcon').live("click",function() {
		var statut = $('#showHideIcon').attr('statut');

		if(statut == "show") {
			$('#showHideIcon').attr('statut', 'hide');
			$('#totalsTable').hide();
		}
		else {			
			$('#showHideIcon').attr('statut', 'show');
			$('#totalsTable').show();
		}
	});
	
	
	$('#excelExport').live("click",function() {
		var itemStartDate = $('#searchCriteriaDiv').attr('itemStartDate');
		var itemEndDate = $('#searchCriteriaDiv').attr('itemEndDate');
		var categoriesIdsString = $('#searchCriteriaDiv').attr('categoriesIdsString');
		var userId = $('#searchCriteriaDiv').attr('userId');
		document.itemExcelExport.action = "/home/jersey/Item/Achats.xls";
		$('<input />').attr('type', 'hidden').attr('name', 'userId').attr('value', userId).appendTo('#itemExcelExport');
		$('<input />').attr('type', 'hidden').attr('name', 'categoriesIdsString').attr('value', categoriesIdsString).appendTo('#itemExcelExport');
		$('<input />').attr('type', 'hidden').attr('name', 'itemStartDate').attr('value', itemStartDate).appendTo('#itemExcelExport');
		$('<input />').attr('type', 'hidden').attr('name', 'itemEndDate').attr('value', itemEndDate).appendTo('#itemExcelExport');
		document.itemExcelExport.submit();
	});
	
	/**
	 * Listener on the fields, enable the writing on the field, changez the
	 * button to prepare the update of the fields.
	 */
	$('.restTest').live("click",function() {
		alert(getStudents);
		$.ajax({
			async: false,
			type: "GET",
			url: url,
			processData: true,
			cache: false,
			success: function(data, text, jqXHR) {
				alert(jqXHR.status);
				alert(jqXHR.text);
				alert(jqXHR.data);
			},
			error: function(jqXHR, text, errorThrown) {
					alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", false, "red");
			}
		});
	}
	$('.itemConfigure').live("click",function() {

		showWaitScreen();
		var itemId = $(this).attr('itemId');
		loadItem(itemId);

		$('#itemDeployDiv').dialog({
			height: 570,
			bgiframe: true,
			resizable: false,
			width: 450,
			modal: true,
			title: "Modifier les d\351tails de l'\351v\351nement",
			buttons: {
				Valider: function() {	// Fonction pour ajouter un nouveau code
										// postal
					showWaitScreen();
					var thisDialog = this;
					
					var itemName = $('#itemName').val();
					var itemDescription = $('#itemDescription').val();
					var itemDate = $('#itemDate').val();
					var itemPrice = $('#itemPrice').val();
					var ticketsNb = $('#ticketsNb').val();
					var ticketsAmount = $('#ticketsAmount').val();
					
					// var itemType = $('#itemType option:selected').text();
					var itemCategory = $('#itemCategory option:selected').val();
					// var itemSeason = $('#itemSeason option:selected').text();
					var itemUser = $('#itemUser option:selected').val();
					
					/*
					 * check if there is an item name
					 */
					if(itemName == null || itemName == "") {
						// Hide ajax load page
						hideWaitScreen();
						alert("Veuillez pr\351ciser un nom d'achat !");
						return false;
					}
					
					/*
					 * check if there is an item description
					 */
					if(itemDescription == null || itemDescription == "") {
						// Hide ajax load page
						hideWaitScreen();
						alert("Veuillez pr\351ciser une description de l'achat !");
						return false;
					}
					
					/*
					 * check item date
					 */
					if(itemDate == null || itemDate == "") {
						// Hide ajax load page
						hideWaitScreen();
						alert("Veuillez pr\351ciser la date de l'achat !");
						return false;
					}
					
					
					/*
					 * check item price
					 */
					if(itemPrice == null || itemPrice == "") {
						// Hide ajax load page
						hideWaitScreen();
						alert("Veuillez pr\351ciser le prix l'achat !");
						return false;
					}
					
					if(!isNumber(itemPrice)) {
						hideWaitScreen();
						alert("Le prix l'achat doit \352tre une valeur num\351rique !");
						return false;
					}
					
					/*
					 * check ticketsNb
					 */
					if(ticketsNb == null || ticketsNb == "") {
						// Hide ajax load page
						ticketsNb = "0";
					}
					
					if(!isInteger(ticketsNb)) {
						hideWaitScreen();
						alert("Le nombre des tickets restaurants doit \352tre une valeur num\351rique enti\350re !");
						return false;
					}
					
					/*
					 * check ticketsAmount
					 */
					if(ticketsAmount == null || ticketsAmount == "") {
						// Hide ajax load page
						ticketsAmount = "0";
					}
					
					if(!isNumber(ticketsAmount)) {
						hideWaitScreen();
						alert("Le montant des tickets restaurants doit \352tre une valeur num\351rique !");
						return false;
					}
					
					/*
					 * check itemCategory
					 */
					if(itemCategory == null || itemCategory == "" || itemCategory == "noCategory") {
						// Hide ajax load page
						hideWaitScreen();
						alert("Veuillez pr\351ciser la cat\351gorie de l'achat !");
						return false;
					}
					
					/*
					 * check itemUser
					 */
					if(itemUser == null || itemUser == "" || itemUser == "noUser") {
						// Hide ajax load page
						hideWaitScreen();
						alert("Veuillez pr\351ciser la personne qui effectu\351 l'achat !");
						return false;
					}

					/*
					 * Jersey Call to update an Item
					 */
					var url = "/home/jersey/Item/updateItem?itemId=" + itemId + "&itemName=" + itemName + 
								"&itemDescription=" + itemDescription + "&itemDate=" + itemDate + 
								"&itemPrice=" + itemPrice + "&ticketsNb=" + ticketsNb + "&ticketsAmount="
								+ ticketsAmount + "&itemCategory=" + itemCategory + "&itemUser=" + itemUser;
					$.ajax({
						async: false,
						type: "GET",
						url: url,
						processData: true,
						cache: false,
						success: function(data, text, jqXHR) {
							if(jqXHR.status == 200) {
								// Hide ajax load page
								hideWaitScreen();
								$(thisDialog).dialog( "close" );
								alertPopup("L'achat a bien \351t\351 mis \340 jour..", "Achat mis \340 jour", false, "#1E639A");
								
								var formUserId = $('#searchCriteriaDiv').attr('userId');
								var formCategoriesIdsString = $('#searchCriteriaDiv').attr('categoriesIdsString');
								var formItemStartDate = $('#searchCriteriaDiv').attr('itemStartDate');
								var formItemEndDate = $('#searchCriteriaDiv').attr('itemEndDate');
// document.itemDetailsForm.action = "/home/jersey/Item/Achats.xls";
								$('<input />').attr('type', 'hidden').attr('name', 'userId').attr('value', formUserId).appendTo('#itemDetailsForm');
								$('<input />').attr('type', 'hidden').attr('name', 'categoriesIdsString').attr('value', formCategoriesIdsString).appendTo('#itemDetailsForm');
								$('<input />').attr('type', 'hidden').attr('name', 'itemStartDate').attr('value', formItemStartDate).appendTo('#itemDetailsForm');
								$('<input />').attr('type', 'hidden').attr('name', 'itemEndDate').attr('value', formItemEndDate).appendTo('#itemDetailsForm');
								document.itemDetailsForm.submit();
							}
							else {
								// Hide ajax load page
								hideWaitScreen();
								$(thisDialog).dialog( "close" );
								alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", true, "red");
							}
						},
						error: function(jqXHR, text, errorThrown) {
// if(jqXHR.status == 500) {
// // Hide ajax load page
// hideWaitScreen();
// alert("La session est expir\351e");
// window.location = "/home/pages/userAccess/userAccess.jsp";
// }
// else {
								// Hide ajax load page
								hideWaitScreen();
								alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", false, "red");
								location.reload(true);
// }
						}
					});
				},
				Supprimer: function() {
					var answer = confirm ("Etes-vous sur de vouloir supprimer cet \351v\351nement ?");
					if (!answer) {
						return false;
					}
					showWaitScreen();
					var thisDialog = this;

					/*
					 * Jersey Call to delete an Item
					 */
					var url = "/home/jersey/Item/deleteItem?itemId=" + itemId;
					$.ajax({
						async: false,
						type: "GET",
						url: url,
						processData: true,
						cache: false,
						success: function(data, text, jqXHR) {
							if(jqXHR.status == 200) {
								// Hide ajax load page
								hideWaitScreen();
								$(thisDialog).dialog( "close" );
								alertPopup("L'\351v\351nement a bien \351t\351 supprim\351.", "Ev\351nement supprim\351", false, "#1E639A");
								
								var formUserId = $('#searchCriteriaDiv').attr('userId');
								var formCategoriesIdsString = $('#searchCriteriaDiv').attr('categoriesIdsString');
								var formItemStartDate = $('#searchCriteriaDiv').attr('itemStartDate');
								var formItemEndDate = $('#searchCriteriaDiv').attr('itemEndDate');
// document.itemDetailsForm.action = "/home/jersey/Item/Achats.xls";
								$('<input />').attr('type', 'hidden').attr('name', 'userId').attr('value', formUserId).appendTo('#itemDetailsForm');
								$('<input />').attr('type', 'hidden').attr('name', 'categoriesIdsString').attr('value', formCategoriesIdsString).appendTo('#itemDetailsForm');
								$('<input />').attr('type', 'hidden').attr('name', 'itemStartDate').attr('value', formItemStartDate).appendTo('#itemDetailsForm');
								$('<input />').attr('type', 'hidden').attr('name', 'itemEndDate').attr('value', formItemEndDate).appendTo('#itemDetailsForm');
								document.itemDetailsForm.submit();

							}
							else {
								// Hide ajax load page
								hideWaitScreen();
								$(thisDialog).dialog( "close" );
								alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", true, "red");
							}
						},
						error: function(jqXHR, text, errorThrown) {
// if(jqXHR.status == 500) {
// // Hide ajax load page
// hideWaitScreen();
// alert("La session est expir\351e");
// window.location = "/home/pages/userAccess/userAccess.jsp";
// }
// else {
								// Hide ajax load page
								hideWaitScreen();
								alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", false, "red");
								location.reload(true);
// }
						}
					});
				},
				Annuler: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
});

/**
 * Popup to load the item details for update
 * 
 * @param {Object}
 *            itemId The ID of the item
 */
function loadItem(itemId) {
	
	// Calling struts action to inject the data in the div
	$.ajax({
		type: "POST",
		async: false,
		url: "/home/pages/userAccess/itemDetailsAction.action",
		data: "itemId=" + itemId,
		timeout : 12000,
		cache: false,
		dataType: "html",
		error: function(jqXHR, text, errorThrown) {
			if(jqXHR.status == 500) {
				// Hide ajax load page
				hideWaitScreen();
				alert("La session est expir\351e");
				window.location = "/home/pages/userAccess/userAccess.jsp";
			}
			else {
				// Hide ajax load page
				hideWaitScreen();
				alertPopup("Une erreur interne s'est produite. La page va recharger pour synchronisation.", "Erreur interne", false, "red");
				location.reload(true);

			}
		},
		success: function(data) {
			hideWaitScreen();
			$("#itemDeployDiv").html(data);
			$('.datePicker').datepicker({
				dateFormat: 'dd/mm/yy',
// minDate: 0,
				changeMonth: true,
				changeYear: true,
				hideIfNoPrevNext: true
			});
			$('.timePicker').timepicker({});
		}
	});
}