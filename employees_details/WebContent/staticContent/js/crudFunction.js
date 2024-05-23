function addEmployee() {

	var employeeName = document.getElementById('employeeName').value;
	var email = document.getElementById("email").value;
	var contact = document.getElementById("contact").value;
	var address = document.getElementById("address").value;

	var checkboxes = document.getElementsByName("selfIdentify");
	var selfIdentify = " ";

	// Iterate over the checkboxes to construct the selfIdentity string
	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			selfIdentify += checkboxes[i].value + ", ";
		}
	}

	// Remove the trailing comma and space if selfIdentity is not empty
	if (selfIdentify !== "") {
		selfIdentify = selfIdentify.slice(0, -2);
	}

	var params = {};

	params["employeeName"] = employeeName;
	params["email"] = email;
	params["contact"] = contact;
	params["selfIdentify"] = selfIdentify;
	params["address"] = address;

	params["methodName"] = "addEmployee";

	console.log("Params to be sent:", params);

	$.post('/employees_details/jsp/utility/Controller.jsp', params,
			function(data) {
				alert(data);
				window.location.reload();
				console.log('Response from Controller.jsp:', data);
			}).fail(function(jqXHR, textStatus, errorThrown) {
		console.error("AJAX Error:", textStatus, errorThrown);
		if (textStatus === "timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}
