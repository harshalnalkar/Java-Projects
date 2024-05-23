package com.employees_details.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employees_details.hibernate.EmployeeDTO;
import com.employees_details.helper.EmployeeHelper;
import com.employees_details.helper.ValidationResult;
import com.employees_details.utility.HibernateUtility;

public class EmployeeDAO {

	private HibernateUtility utility = HibernateUtility.getInstance();

	public void addEmployee(EmployeeDTO employeeDTO) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = utility.OpenSession();
			transaction = session.beginTransaction();
			session.save(employeeDTO);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			utility.closeSession(session);
		}
	}

	// Method to display all employees list
	public List<EmployeeDTO> getAllEmployees() {

		List<EmployeeDTO> employees = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = utility.OpenSession();
			transaction = session.beginTransaction();
			employees = session.createSQLQuery("Select * from employees_details").addEntity(EmployeeDTO.class).list();
			transaction.commit();

			if (employees.isEmpty() || employees == null) {
				System.out.println("No employees found.");
			}

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			utility.closeSession(session);
		}
		return employees;
	}

	public void updateEmployee(EmployeeDTO dto) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = utility.OpenSession();
			transaction = session.beginTransaction();

			session.saveOrUpdate(dto);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			utility.closeSession(session);
		}
	}

	public void deleteEmployee(int employeeID) {
		Session session = null;
		Transaction transaction = null;

		try {

			session = utility.OpenSession();
			transaction = session.beginTransaction();

			EmployeeDTO dto = (EmployeeDTO) session.get(EmployeeDTO.class, employeeID);

			if (dto != null) {

				System.out.println("Employee found: " + dto);
				session.delete(dto);
				transaction.commit();
				System.out.println("Transaction committed.");

			} else {
				System.out.println("Employee with ID " + employeeID + " not found.");

			}

			transaction = session.beginTransaction();
			List<EmployeeDTO> employees = session.createSQLQuery("SELECT * FROM employees_details ORDER BY employee_id")
					.addEntity(EmployeeDTO.class).list();

			int deleteID = employeeID;
			
			for (EmployeeDTO employeeDTO : employees) {
				
				int currentID = employeeDTO.getEmployeeID();
				
				if (currentID > deleteID) {
					employeeDTO.setEmployeeID(currentID - 1);
					session.update(employeeDTO);
				}
			}

			transaction.commit();
			System.out.println("IDs reassigned and transaction committed.");

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			utility.closeSession(session);
		}

	}

	public EmployeeDTO searchEmployee(int employeeID) {

		Session session = null;
		Transaction transaction = null;
		EmployeeDTO dto = null;

		try {

			session = utility.OpenSession();
			transaction = session.beginTransaction();
			dto = (EmployeeDTO) session.get(EmployeeDTO.class, employeeID);

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			utility.closeSession(session);
		}

		return dto;
	}

}