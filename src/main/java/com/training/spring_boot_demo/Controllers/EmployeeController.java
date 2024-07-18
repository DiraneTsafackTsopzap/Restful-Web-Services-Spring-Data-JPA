package com.training.spring_boot_demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring_boot_demo.Model.Employee;
import com.training.spring_boot_demo.Service.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    

// appel du repositories ici 
@Autowired
private EmployeeRepository employeeRepository;


// definir la methode pour save un employee ds la liste
@PostMapping
public Employee save(@RequestBody Employee employee)
{
    return employeeRepository.save_employee(employee);
}

// Retourner tous les Employees de la Liste
@GetMapping
public List<Employee> get_all_employees() {
    return employeeRepository.get_employees();
}


// retourner un employee en fonction de l'id
@GetMapping("/{id}")
public Employee get_employee_id (@PathVariable String id)
{
    return employeeRepository.get_employee_by_id(id);
}

// Supprimer un employee
@DeleteMapping("/{id}")
public String delete_employe_id (@PathVariable String id)
{
    return employeeRepository.delete_employee_id(id);
}

}
