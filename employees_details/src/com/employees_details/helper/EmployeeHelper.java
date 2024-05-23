package com.employees_details.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employees_details.dao.EmployeeDAO;
import com.employees_details.hibernate.EmployeeDTO;

public class EmployeeHelper {

	public void addEmployee(HttpServletRequest req, HttpServletResponse res) {

		String employeeName = req.getParameter("employeeName");
		String email = req.getParameter("email");
		long contact = Long.parseLong(req.getParameter("contact"));
		String selfIdentity = req.getParameter("selfIdentify");
		String address = req.getParameter("address");

		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeName(employeeName);
		dto.setEmail(email);
		dto.setContact(contact);
		dto.setSelfIdentity(selfIdentity);
		dto.setAddress(address);

		EmployeeDAO dao = new EmployeeDAO();
		dao.addEmployee(dto);

	}

	public void updateEmployee(HttpServletRequest req, HttpServletResponse res) {

		int employeeID = Integer.parseInt(req.getParameter("employeeID"));
		String employeeName = req.getParameter("employeeName");
		String email = req.getParameter("email");
		long contact = Long.parseLong(req.getParameter("contact"));
		String selfIdentity = req.getParameter("selfIdentity");
		String address = req.getParameter("address");

		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeID(employeeID);
		dto.setEmployeeName(employeeName);
		dto.setEmail(email);
		dto.setContact(contact);
		dto.setSelfIdentity(selfIdentity);
		dto.setAddress(address);

		EmployeeDAO dao = new EmployeeDAO();
		dao.updateEmployee(dto);

	}

	public void deleteEmployee(HttpServletRequest req, HttpServletResponse res) {

		int employeeID = Integer.parseInt(req.getParameter("employeeID"));
		EmployeeDAO dao = new EmployeeDAO();
		dao.deleteEmployee(employeeID);

	}

	public EmployeeDTO searchEmployee(int employeeID) {
		
		EmployeeDAO dao = new EmployeeDAO();
		return dao.searchEmployee(employeeID);
	}

}
