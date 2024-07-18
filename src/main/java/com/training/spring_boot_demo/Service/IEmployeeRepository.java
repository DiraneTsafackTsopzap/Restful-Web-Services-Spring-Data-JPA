package com.training.spring_boot_demo.Service;

import java.util.List;

import com.training.spring_boot_demo.Model.Employee;
import com.training.spring_boot_demo.Model.Person;

public interface IEmployeeRepository  {

    Employee save_employee(Employee employee);

    List<Employee> get_employees();

    Employee get_employee_by_id (String id);

    String delete_employee_id (String id);


    Person save_employee_entity(Person employee);
}
