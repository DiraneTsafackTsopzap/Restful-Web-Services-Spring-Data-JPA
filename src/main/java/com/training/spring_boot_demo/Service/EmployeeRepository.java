package com.training.spring_boot_demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring_boot_demo.ErrorException.EmployeeNotFoundException;
import com.training.spring_boot_demo.Model.Employee;
import com.training.spring_boot_demo.Model.Person;
import com.training.spring_boot_demo.ServiceDatabase.IPersonRepositoryDatabase;


@Service
public class EmployeeRepository implements IEmployeeRepository {


    List<Employee> employees_listes = new ArrayList<>();

    @Override
    public Employee save_employee(Employee employee) {

        if (employee == null || employee.Prenom == null || employee.Nom == null ||
        employee.Prenom.isEmpty() || employee.Nom.isEmpty()) {
        throw new IllegalArgumentException("Employee email or name cannot be null or empty");
    }
    System.out.println("Ajout de l'employé réussi : " + employee.Id);
    return employee;
    }

    @Override
    public List<Employee> get_employees() {
        return employees_listes;
    }

    @Override
    public Employee get_employee_by_id(String id) {
    return employees_listes.stream()
            .filter(employee -> employee.Id.equals(id))
            .findFirst()
            .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with this Id: " + id));
}

@Override
public String delete_employee_id(String id) {
    Employee employee = employees_listes.stream()
            .filter(e -> e.Id.equalsIgnoreCase(id))
            .findFirst()
            .orElseThrow(() -> new EmployeeNotFoundException("Aucun employé n'est trouvé avec cet ID : " + id));
    
    employees_listes.remove(employee);
    return "Employee deleted with this Id: " + id;
}



// Create data in database--------------------------------------------------------------------------------------------------------

@Autowired
private IPersonRepositoryDatabase employeeRepository;
public Person save_employee_entity(Person employee) {
    return employeeRepository.save(employee);
}

}
