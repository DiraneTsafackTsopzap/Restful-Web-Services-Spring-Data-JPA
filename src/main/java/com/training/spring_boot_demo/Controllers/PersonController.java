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

import com.training.spring_boot_demo.Model.Person;
import com.training.spring_boot_demo.PersonService.PersonRepository;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonRepository PersonRepositories;



    @PostMapping
public Person save(@RequestBody Person person)
{
    return PersonRepositories.save_person(person);
}


// Retourner tous les person de ma db
@GetMapping
public List<Person> get_all_employees() {
    return PersonRepositories.get_person();
}

// retourner une Person en fonction de l'id
@GetMapping("/{id}")
public Person get_employee_id (@PathVariable String id)
{
    return PersonRepositories.get_person_by_id(id);
}

// Supprimer un employee
@DeleteMapping("/{id}")
public String delete_employe_id (@PathVariable String id)
{
    return PersonRepositories.delete_person_id(id);
}





}
