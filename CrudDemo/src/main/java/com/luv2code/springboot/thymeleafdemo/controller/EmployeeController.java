package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
    private EmployeeService theEmployees;

	public EmployeeController(EmployeeService theEmployees) {
		this.theEmployees = theEmployees;
	}

// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
// get the employees from db
		List<Employee> theEmployees_1= theEmployees.findAll();



		// add to the spring model
		theModel.addAttribute("employees", theEmployees_1);

		return "employees/list-employees";
	}


	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model model){
		Employee theEmployee=new Employee();
		model.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		theEmployees.save(employee);

		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){
      //get the employee from the service

		Employee theEmployee=theEmployees.findById(theId);

		//set Employee from in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);

		//send over to our form
        return "employees/employee-form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId")int theId){
		//delete the employee
		theEmployees.deleteById(theId);
		//redirect to the /employees/list
		return "redirect:/employees/list";
	}
}









