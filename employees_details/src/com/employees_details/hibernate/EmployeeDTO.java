package com.employees_details.hibernate;

public class EmployeeDTO {

	private int employeeID;
	private String employeeName;

	private String email;
	private long contact;
	private String selfIdentity;
	private String address;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getSelfIdentity() {
		return selfIdentity;
	}
	public void setSelfIdentity(String selfIdentity) {
		this.selfIdentity = selfIdentity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public EmployeeDTO(int employeeID, String employeeName, String email, long contact, String selfIdentity,
			String address) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.email = email;
		this.contact = contact;
		this.selfIdentity = selfIdentity;
		this.address = address;
	}
	public EmployeeDTO() {
		super();
	}

}
