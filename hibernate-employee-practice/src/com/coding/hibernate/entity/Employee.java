package com.coding.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.coding.hibernate.utils.DateUtils;


@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "company")
	private String companyName;
	
	@Column(name = "joining_date")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, String companyName, String joiningDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.joiningDate = DateUtils.formatDate(joiningDate);
	}

	public Employee(String firstName, String lastName, String companyName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.joiningDate = DateUtils.formatDate(null);
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		Date dateObject = DateUtils.formatDate(joiningDate);
		this.joiningDate = dateObject;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", companyName="
				+ companyName + ", joiningDate=" + joiningDate + "]";
	}
}
