package com.wipro.officeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.officeapp.entity.Employee;
import com.wipro.officeapp.entity.SalaryRecord;
import com.wipro.officeapp.repository.SalaryRecordRepository;

@Service
public class SalaryRecordService {
	
	@Autowired
	private SalaryRecordRepository salaryRepo;

	public boolean saveRecord(SalaryRecord salaryRecord) {
		// TODO Auto-generated method stub
		try {
			salaryRepo.save(salaryRecord);
			salaryRepo.flush();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		   System.err.println("Save Salary " +e.getMessage());
		   return false;
		}
	}
	public List<SalaryRecord> list() {
		return salaryRepo.findAll();

	}

}
