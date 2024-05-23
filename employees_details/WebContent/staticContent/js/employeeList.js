 window.onload = function() {
        getEmployeeList();
    };

    function getEmployeeList() {
        fetch("controller.jsp?action=getAllEmployees")
            .then(response => response.text())
            .then(data => {
                document.getElementById("employeeList").innerHTML = data;
            })
            .catch(error => console.error('Error fetching employee list:', error));
    }