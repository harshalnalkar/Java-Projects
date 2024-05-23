<%@page import="com.employees_details.dao.EmployeeDAO"%>
<%@page import="com.employees_details.hibernate.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Employees Details</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="/employees_details/staticContent/css/index.css">

<script type="text/javascript"
	src="/employees_details/staticContent/js/addFunction.js"></script>


<script type="text/javascript"
	src="/employees_details/staticContent/js/crudFunction.js"></script>


<script type="text/javascript"
	src="/employees_details/staticContent/js/updateEmployee.js"></script>

<script type="text/javascript"
	src="/employees_details/staticContent/js/searchEmployee.js"></script>

<!-- <script type="text/javascript" src="/employees_details/staticContent/js/employeeList.js"></script>
 -->
<link rel="stylesheet"
	href="/employees_details/staticContent/css/jquery-ui.min.css">
<link rel="stylesheet"
	href="/employees_details/staticContent/css/ui.jqgrid.css">




<script type="text/javascript"
	src="/employees_details/staticContent/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="/employees_details/staticContent/js/jquery.min.js"></script>
<script type="text/javascript"
	src="/employees_details/staticContent/js/jquery-ui-min.js"></script>
<script type="text/javascript"
	src="/employees_details/staticContent/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="/employees_details/staticContent/js/jqueryUi.js"></script>
<script type="text/javascript"
	src="/employees_details/staticContent/js/jquery.jqgrid.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2 class="mb-0">Employee's Details</h2>
			</div>
			<div class="card-body">
				<!-- Add Employee Button and Search Bar -->
				<div class="d-flex justify-content-between mb-3">
					<!-- Add Employee Button -->
					<button type="button" class="btn btn-primary"
						id="addEmployeeButton" onclick="addForm()">Add Employee</button>
					<!-- Search Button and Input -->
					<div class="input-group search-bar">
						<input type="text" class="form-control" placeholder="Search..."
							id="searchInput">
						<div class="input-group-append">
							<button type="button" class="btn btn-secondary" id="searchButton">Search</button>
						</div>
					</div>
				</div>

				<!-- Add Employee Form -->
				<div id="addForm" style="display: none;">
					<h4 class="mb-3">Add Employee</h4>
					<form id="addEmployeeForm">
						<div class="form-group">
							<label for="employeeName">Employee Name:</label> <input
								type="text" class="form-control" id="employeeName" required
								name="employeeName" autofocus="autofocus">
						</div>
						<div class="form-group">
							<label for="email">Email:</label> <input type="email"
								class="form-control" id="email" required name="email">
						</div>
						<div class="form-group">
							<label for="contact">Contact:</label> <input type="text"
								class="form-control" id="contact" required name="contact">
						</div>
						<div class="form-group">
							<label>Self Identify:</label> <br>
							<div class="checkbox" style="display: flex;">
								<div style="flex: 1;">
									<input type="checkbox" id="maleCheckbox" name="selfIdentify"
										value="Male"> <label for="maleCheckbox">Male</label>
								</div>
								<div style="flex: 1;">
									<input type="checkbox" id="femaleCheckbox" name="selfIdentify"
										value="Female"> <label for="femaleCheckbox">Female</label>
								</div>
								<div style="flex: 1;">
									<input type="checkbox" id="transgenderCheckbox"
										name="selfIdentify" value="Transgender"> <label
										for="transgenderCheckbox">Transgender</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="address">Address:</label> <input type="text"
								class="form-control" id="address" required name="address">
						</div>
						<button type="submit" class="btn btn-success"
							onclick="addEmployee()">Add</button>
						<button type="reset" class="btn btn-success" onclick="closeForm()">Previous</button>
					</form>
				</div>

				<!-- Employee List -->
				<div id="employeeList" class="mt-5"
					style="max-height: 100vh; overflow-y: auto;">
					<%
						EmployeeDAO dao = new EmployeeDAO();
						List<EmployeeDTO> employees = dao.getAllEmployees();
						String msg = (String) request.getAttribute("msg");

						if (employees == null || employees.isEmpty()) {
					%>
					<div class="alert alert-info" role="alert">No employees
						found.</div>
					<%
						}

						if (msg != null) {
					%>
					<h2><%=msg%></h2>
					<%
						}
					%>
					<h4 class="mb-3">Employee List</h4>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Employee Name</th>
								<th>Email</th>
								<th>Contact</th>
								<th>Self Identify</th>
								<th>Address</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (EmployeeDTO employee : employees) {
							%>
							<tr data-employee-id="<%=employee.getEmployeeID()%>">
								<td><%=employee.getEmployeeID()%></td>
								<td class="editable"><%=employee.getEmployeeName()%></td>
								<td class="editable"><%=employee.getEmail()%></td>
								<td class="editable"><%=employee.getContact()%></td>
								<td class="editable"><%=(employee.getSelfIdentity() != null) ? employee.getSelfIdentity() : "N/A"%></td>
								<td class="editable"><%=employee.getAddress()%></td>
								<td>
									<button class="btn btn-sm btn-primary edit-button">Edit</button>
									<button class="btn btn-sm btn-danger delete-button">Delete</button>

									<button class="btn btn-sm btn-success save-button"
										style="display: none;">Save</button>
									<button class="btn btn-sm btn-secondary cancel-button"
										style="display: none;">Cancel</button>

								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
