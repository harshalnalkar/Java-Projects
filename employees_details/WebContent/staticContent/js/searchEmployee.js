document.addEventListener("DOMContentLoaded", function() {
    // JavaScript to handle the search functionality by ID
    document.getElementById("searchButton").addEventListener("click", function() {
        const searchInput = document.getElementById("searchInput").value.trim();
        if (searchInput !== "") {
            const params = {
                action: "searchById",
                employeeID: searchInput,
                methodName: "searchEmployee"
            }; // Parameters for the AJAX request

            // AJAX request to search employee by ID
            $.post('/employees_details/jsp/utility/Controller.jsp', params, function(data) {
                // Handle the response from the backend
                console.log('Response from Controller.jsp:', data);
                // Reset background color for all rows
                $("#employeeList tbody tr").css("background-color", "");
                // Highlight the matching row
                const jsonData = JSON.parse(data); // Parse the JSON data
                const employeeID = parseInt(jsonData.employeeID); // Parse employeeID as an integer

                // Check if employeeID is a valid number
                if (!isNaN(employeeID)) {
                    const matchingRow = $("#employeeList tbody tr[data-employee-id='" + employeeID + "']");
                    if (matchingRow.length > 0) {
                        matchingRow.css("background-color", "yellow");
                        // Scroll to the matching row (optional)
                        matchingRow.get(0).scrollIntoView({ behavior: "smooth", block: "center" });
                    } else {
                        alert("No employee found with ID: " + searchInput);
                    }
                } else {
                    alert("Invalid employee ID: " + jsonData.employeeID);
                }


            }).fail(function(jqXHR, textStatus, errorThrown) {
                console.error("AJAX Error:", textStatus, errorThrown);
                if (textStatus === "timeout") {
                    $(loaderObj).hide();
                    $(loaderObj).find('#errorDiv').show();
                }
            });
        } else {
            alert("Please enter an ID to search.");
        }
    });
});
