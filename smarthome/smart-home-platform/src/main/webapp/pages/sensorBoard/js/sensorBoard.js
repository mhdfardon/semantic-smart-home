/**
 * @author fardon
 */
$(document).ready(function() {
	
	$('.datePicker').datepicker({
		dateFormat: 'dd/mm/yy',
		changeMonth: true,
		changeYear: true
	});
	
	$('#sensorsTable').dataTable({
		"bSort": false,
		"iDisplayLength" : 10,
		"bFilter": true,
		"bJQueryUI": true,
		"bAutoWidth": true,
		"sPaginationType": "full_numbers",
		"bScrollCollapse": true,
		"bPaginate": true
	});
});