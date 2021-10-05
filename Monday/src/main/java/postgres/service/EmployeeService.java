package postgres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import postgres.model.Employee;
import postgres.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		 return employeeRepository.findAll();
		
		
	}
  

	
	public void deleteEmployee(Long id) {
	 Boolean exists=employeeRepository.existsById(id);
	 if(!exists) {
		 System.out.println("employee doesnot exist"+id);
	 }
	 employeeRepository.deleteById(id);
		 
	}

	
	public List <Employee> addNewEmployeee(@RequestBody List <Employee> employee) {
		return employeeRepository.saveAll(employee);
	}



	public Optional<Employee> getById(Long id) {
		return employeeRepository.findById(id);
	}


//
//	public Employee updateEmployee(@RequestBody Employee updateEmployee, @PathVariable Long id) {
//
//	       return employeeRepository.findById(id)
//	           .map(employee -> {
//	          employee.setId(updateEmployee.getId());
//	          employee.setDate_of_joining(updateEmployee.getDate_of_joining());
//	          employee
//	        return employeeRepository.save(employee);
//	      })
//	      .orElseGet(() -> {
//	    	  updateEmployee.setId(id);
//	        return employeeRepository.save(updateEmployee);
//	      });
//			
//		}

	

}
   
   

