package com.wipro.officeapp.entity;

import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;





import lombok.Data;

@Entity
@Table(name = "emp_info")
@Data
@JsonIdentityInfo(
		          generator = ObjectIdGenerators.PropertyGenerator.class,
		          property = "empId")
public class Employee {
	
	@Id
	@Column(name = "emp_id")
	private String empId;
	
	@Column(name = "emp_name",nullable = false)
	private String empName;
	
	@Column(name = "emp_salary",nullable = false)
	private Float salary;
	
	@Column(name = "emp_mail",nullable = false,unique = true)
	private String email;
	
	@Column(name = "emp_phone",nullable = true,unique = true)
	private String phone;
	
	@OneToOne
	@JoinColumn(name = "emp_address")
	private Address address;
	
	@OneToMany(mappedBy = "employee")
	private List<SalaryRecord> salaryRecords;
	
	

}
