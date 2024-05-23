package com.employees_details.utility;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employees_details.helper.EmployeeHelper;
import com.employees_details.hibernate.EmployeeDTO;
import com.google.gson.*;

public class Controller {

	private String toJson(Object data) {
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		return gson.toJson(data);
	}

	public String addEmployee(HttpServletRequest req, HttpServletResponse res) {

		System.out.println("In Controller for Save");
		EmployeeHelper helper = new EmployeeHelper();
		helper.addEmployee(req, res);
		req.setAttribute("msg", "Data Added Successfully...!!");
		return toJson("Data Added Successfully");
	}

	public String updateEmployee(HttpServletRequest req, HttpServletResponse res) {

		System.out.println("In Controller For update");
		EmployeeHelper helper = new EmployeeHelper();
		helper.updateEmployee(req, res);
		return toJson("Data Updated Successfully");
	}
	
	public String deleteEmployee(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("In Controller For Delete");
		EmployeeHelper helper = new EmployeeHelper();
		helper.deleteEmployee(req, res);
		return toJson("Data Deleted Successfully");
	}
	
	public String searchEmployee(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("In Controller For Serch");
		EmployeeHelper helper = new EmployeeHelper();
		EmployeeDTO dto = helper.searchEmployee(Integer.parseInt(req.getParameter("employeeID")));
		
		String jsonResponse = toJson(dto);
		return jsonResponse;
	}

}