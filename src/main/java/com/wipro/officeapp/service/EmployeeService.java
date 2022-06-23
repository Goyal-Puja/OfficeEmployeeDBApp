package com.wipro.officeapp.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.officeapp.repository.AddressRepository;
import com.wipro.officeapp.repository.EmployeeRepository; 
import com.wipro.officeapp.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private AddressRepository addressRepo;
    public boolean saveEmployee(Employee emp) {
    	
    	try {
			addressRepo.save(emp.getAddress());
			empRepo.save(emp);
			empRepo.flush();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return false;
		}
		
	}
    public List<Employee> list() {
    	return empRepo.findAll();
		
	}
    
  public Optional<Employee> get(String eid){
	  return empRepo.findById(eid);
  }
  
  public boolean deleteEmployee(String eid) {
	  
	  try {
		empRepo.deleteById(eid);
		  empRepo.flush();
		  return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.err.println(e.getMessage());
		return false;
	}
	
}
  
}
