/**
 * 
 */
$(document).ready(function() {
	$('.datePicker').datepicker({
		dateFormat: 'dd/mm/yy',
//		minDate: 0,
		changeMonth: true,
		changeYear: true,
		hideIfNoPrevNext: true
	});
});

/**
 * Function to test if the data is number
 */
function isNumber(num) {

  return !isNaN(parseFloat(num)) && isFinite(num);

}

function isInteger(str) {
	return /^\d+$/.test(str);
}

/**
 * Function to test if the data are decimal of 10 digits
 */
function isTendigits(str) {
	return /^\d{10}$/.test(str);
}

/**
 * Function to remove all white spaces from the beginning and the end of the text
 * @param {str} the text to clean
 * @return 	the cleaned text
 */	
function whiteSpacesTrim(str) {
	return str.replace(/^\s+|\s+$/g, '');
}

//	Show ajax load page
function showWaitScreen() {
	$("#fullscreen").show();
	$("#loading").show();
}

// Hide ajax load page
function hideWaitScreen() {
	$("#fullscreen").hide();
	$("#loading").hide();
}

/**
 * Displaying alert popup instead of JS alert
 * 
 * message		:	the message to display	: String
 * title		:	The title of the alert popup	:	String
 * reload		:	reloading page	:	boolean
 * fontColor	:	the color of font	:	String
 * 
 */
function alertPopup(message, title, reload, fontColor) {

	$("#alertPopup").html('<span>' + message + '</span>');
	$("#alertPopup").css("color", fontColor);
	$("#alertPopup").css("font-size", "10px");
	//	Calculating height
	var popupHeight = (message.length / 3.05 ) + 110;
	$("#alertPopup").dialog({
		height : popupHeight,
		bgiframe : true,/* IE6 hack */
		width : 300,
		zIndex : 998,
		resizable : false,/* IE6 hack */
		title : title,
		/*
		 * blocking html page
		 */
		modal : true,
		buttons : {
			"Ok" : function() {
				$(this).dialog("close");
				if (reload) {
					location.reload(true);
				}
			}
		}
	});
}

function trim(myString) {
	return myString.replace(/^\s+/g, '').replace(/\s+$/g, '')
};

//function trim(str) {
//	str = str.replace(/^\s+/, '');
//	for ( var i = str.length - 1; i >= 0; i--) {
//		if (/\S/.test(str.charAt(i))) {
//			str = str.substring(0, i + 1);
//			break;
//		}
//	}
//	return str;
//}

jQuery.fn.dataTableExt.oSort['date-euro-asc'] = function(a, b) {
	if (trim(a) != '') {
		var frDatea = trim(a).split(' ');
		var frTimea = frDatea[2].split(':');
		var frDatea2 = frDatea[0].split('/');
		var x = (frDatea2[2] + frDatea2[1] + frDatea2[0] + frTimea[0] + frTimea[1]) * 1;
	} else {
		var x = 100000000000; // = l'an 1000 ...
	}

	if (trim(b) != '') {
		var frDateb = trim(b).split(' ');
		var frTimeb = frDateb[2].split(':');
		frDateb = frDateb[0].split('/');
		var y = (frDateb[2] + frDateb[1] + frDateb[0] + frTimeb[0] + frTimeb[1]) * 1;
	} else {
		var y = 100000000000;
	}
	var z = ((x < y) ? -1 : ((x > y) ? 1 : 0));
	return z;
};

jQuery.fn.dataTableExt.oSort['date-euro-desc'] = function(a, b) {
	if (trim(a) != '') {
		var frDatea = trim(a).split(' ');
		var frTimea = frDatea[2].split(':');
		var frDatea2 = frDatea[0].split('/');
		var x = (frDatea2[2] + frDatea2[1] + frDatea2[0] + frTimea[0] + frTimea[1]) * 1;
	} else {
		var x = 100000000000;
	}

	if (trim(b) != '') {
		var frDateb = trim(b).split(' ');
		var frTimeb = frDateb[2].split(':');
		frDateb = frDateb[0].split('/');
		var y = (frDateb[2] + frDateb[1] + frDateb[0] + frTimeb[0] + frTimeb[1]) * 1;
	} else {
		var y = 100000000000;
	}
	var z = ((x < y) ? 1 : ((x > y) ? -1 : 0));
	return z;
};

jQuery.fn.dataTableExt.oSort['date-euro2-asc'] = function(a, b) {
	if (trim(a) != '') {
		var frDatea = trim(a).split(' ');
		var frDatea2 = frDatea[0].split('/');
		var x = (frDatea2[2] + frDatea2[1] + frDatea2[0]) * 1;
	} else {
		var x = 10000000; // = l'an 1000 ...
	}

	if (trim(b) != '') {
		var frDateb = trim(b).split(' ');
		frDateb = frDateb[0].split('/');
		var y = (frDateb[2] + frDateb[1] + frDateb[0]) * 1;
	} else {
		var y = 10000000;
	}
	var z = ((x < y) ? -1 : ((x > y) ? 1 : 0));
	return z;
};

jQuery.fn.dataTableExt.oSort['date-euro2-desc'] = function(a, b) {
	if (trim(a) != '') {
		var frDatea = trim(a).split(' ');
		var frDatea2 = frDatea[0].split('/');
		var x = (frDatea2[2] + frDatea2[1] + frDatea2[0]) * 1;
	} else {
		var x = 10000000;
	}

	if (trim(b) != '') {
		var frDateb = trim(b).split(' ');
		frDateb = frDateb[0].split('/');
		var y = (frDateb[2] + frDateb[1] + frDateb[0]) * 1;
	} else {
		var y = 10000000;
	}
	var z = ((x < y) ? 1 : ((x > y) ? -1 : 0));
	return z;
};