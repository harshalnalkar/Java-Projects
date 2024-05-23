document.addEventListener("DOMContentLoaded", function() {
    const employeeList = document.getElementById("employeeList");

    employeeList.addEventListener("click", function(event) {
        const target = event.target;

        // Handle Edit button click
        if (target.classList.contains("edit-button")) {
            const row = target.closest("tr");
            const cells = row.querySelectorAll("td");

            // Toggle edit mode
            cells.forEach(cell => {
                if (cell.classList.contains("editable")) {
                    const currentValue = cell.textContent.trim();
                    cell.innerHTML = `<input type="text" class="form-control small-input" value="${currentValue}" style="width: 150px; height=7px; color: green;">`;
                }
            });

            // Toggle buttons visibility
            row.querySelector(".edit-button").style.display = "none";
            row.querySelector(".delete-button").style.display = "none";
            row.querySelector(".save-button").style.display = "inline-block";
            row.querySelector(".cancel-button").style.display = "inline-block";

            // Add editing class to mark the row as being edited
            row.classList.add("editing");
        }

        // Handle Save button click
        if (target.classList.contains("save-button")) {
            const row = target.closest("tr");
            const cells = row.querySelectorAll("td");
            const id = row.dataset.employeeId; // Get the employee ID from the
												// data attribute

            // Prepare data to send to backend
            const data = {
                employeeID: id,
                employeeName: cells[1].querySelector("input").value,
                email: cells[2].querySelector("input").value,
                contact: cells[3].querySelector("input").value,
                selfIdentity: cells[4].querySelector("input").value,
                address: cells[5].querySelector("input").value,
                methodName: "updateEmployee"
            };
            
            console.log("Data to send:", data);

            // AJAX request to update employee data
            $.post('/employees_details/jsp/utility/Controller.jsp', data,
                function(response) {
                    alert(response);
                    // Update table cells with new values
                    cells.forEach(cell => {
                        if (cell.classList.contains("editable")) {
                            const input = cell.querySelector("input");
                            cell.textContent = input.value;
                        }
                    });

                    // Toggle buttons visibility
                    row.querySelector(".edit-button").style.display = "inline-block";
                    row.querySelector(".delete-button").style.display = "inline-block";
                    row.querySelector(".save-button").style.display = "none";
                    row.querySelector(".cancel-button").style.display = "none";

                    // Remove editing class
                    row.classList.remove("editing");
                }).fail(function(jqXHR, textStatus, errorThrown) {
                console.error("AJAX Error:", textStatus, errorThrown);
                alert('Error updating employee data.');
            });
        }

        // Handle Cancel button click
        if (target.classList.contains("cancel-button")) {
            const row = target.closest("tr");
            const cells = row.querySelectorAll("td");

            // Revert to original data
            cells.forEach(cell => {
                if (cell.classList.contains("editable")) {
                    const input = cell.querySelector("input");
                    cell.textContent = input.defaultValue;
                }
            });

            // Toggle buttons visibility
            row.querySelector(".edit-button").style.display = "inline-block";
            row.querySelector(".delete-button").style.display = "inline-block";
            row.querySelector(".save-button").style.display = "none";
            row.querySelector(".cancel-button").style.display = "none";

            // Remove editing class
            row.classList.remove("editing");
        }
        
        // Handle Delete button click
        if (target.classList.contains("delete-button")) {
            const row = target.closest("tr");
            const id = row.dataset.employeeId; // Get the employee ID from the
												// data attribute
            console.log("Deleting employee with ID:", id);

            if (confirm('Are you sure you want to delete this employee?')) {
                // AJAX request to delete employee data
                $.post('/employees_details/jsp/utility/Controller.jsp', { employeeID: id, methodName: "deleteEmployee" },
                    function(response) {
                        alert(response);
                        window.location.reload();

                        // Remove row from table
                        row.parentNode.removeChild(row);

                        // Update remaining rows' IDs
                        const rows = employeeList.querySelectorAll("tr");
                        rows.forEach((row, index) => {
                            row.dataset.employeeId = index + 1;
                            const idCell = row.querySelector("td:first-child");
                            if (idCell) idCell.textContent = index + 1;
                        });
                    }).fail(function(jqXHR, textStatus, errorThrown) {
                    console.error("AJAX Error:", textStatus, errorThrown);
                    alert('Error deleting employee data.');
                });
            }
        }
    });
});
