package com.training.spring_boot_demo.PersonService;

import java.util.List;

//mport com.training.spring_boot_demo.Model.Employee;
import com.training.spring_boot_demo.Model.Person;

public interface IPersonRepository {

    Person save_person(Person employee);

    List<Person> get_person();

    Person get_person_by_id (String id);

    String delete_person_id (String id);
    
} 
