$(document).ready(function() {

	$("#search-summary").submit(function(event) {
		event.preventDefault();
		_getUploadSummary();
	});

});

function _getUploadSummary() {

	var fileName = $("#filename").val();
	$("#upload-summary-table").remove();

	$
			.ajax({
				type : "GET",
				contentType : "application/json",
				url : "/search/summary",
				data : {
					"filename" : fileName
				},
				dataType : 'json',
				cache : false,
				success : function(data) {

					var summary = $("#summary");

					var table = "<table class='table' id='upload-summary-table'>"
							+ "<tr>"
							+ "<th>File Name</th>"
							+ "<th>Valid Deals Count</th>"
							+ "<th>Invalid Deals Count</th>"
							+ "<th>Process Duration (seconds)</th>"
							+ "<th>Import Date</th>"
							+ "</tr>"
							+ "<tr>"
							+ "<td>"
							+ data.sourceFileName
							+ "</td>"
							+ "<td>"
							+ data.validDealsImportedCount
							+ "</td>"
							+ "<td>"
							+ data.invalidDealsImportedCount
							+ "</td>"
							+ "<td>"
							+ data.processDuration
							+ "</td>"
							+ "<td>"
							+ data.importDate + "</td>" + "</tr></table>";

					summary.append(table);

					_clearSearchInput();
				},
				error : function(data) {

					$("#alertMsg").remove();
					$("#upload-summary-table").remove();

					var alertDiv = $("#alert");
					alertDiv
							.append("<div id='alertMsg' class='alert alert-danger'><p><strong>"
									+ data.responseText + "</strong></p></div>");
				}
			});
}

function _clearSearchInput() {
	$("#filename").val("");
}