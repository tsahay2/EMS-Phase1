package com.flp.ems.domain;

import java.util.Comparator;
import java.util.Date;

public class Employee implements Cloneable {

	int emp_id;
	String name;
	String kin_id;
	String email_id;
	Double phone_number;
	Date date_of_birth;
	Date date_of_joining;
	String address;
	int dept_id;
	int project_id;
	int role_id;
	static int cnt = 1;

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public Employee(String name, Double phone_number, String address, Date date_of_birth, Date date_of_joining,
			int dept_id, int project_id, int role_id) {

		this.emp_id = cnt;
		this.dept_id = dept_id;
		this.name = name;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
		this.address = address;
		this.dept_id = dept_id;
		this.project_id = project_id;
		this.role_id = role_id;
		cnt++;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKin_id() {
		return kin_id;
	}

	public void setKin_id(String kin_id) {
		this.kin_id = kin_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Double getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Double phone_number) {
		this.phone_number = phone_number;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	class MyComparator implements Comparator{
		@Override
		public int compare(Object o1, Object o2) {
			int diff =((Integer) o1)-((Integer) o2);
			
			return -diff;
		}
	}

}
