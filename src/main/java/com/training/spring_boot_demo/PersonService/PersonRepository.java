package com.training.spring_boot_demo.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring_boot_demo.ErrorException.EmployeeNotFoundException;

import com.training.spring_boot_demo.Model.Person;

import com.training.spring_boot_demo.ServiceDatabase.IPersonRepositoryDatabase;

@Service
public class PersonRepository implements IPersonRepository{

   @Autowired
    private IPersonRepositoryDatabase personrepository;

   

   
    @Override
    public Person save_person(Person person) {
        if (person == null || person.Prenom == null || person.Nom == null ||
        person.Prenom.isEmpty() || person.Nom.isEmpty()) {
        throw new IllegalArgumentException("Employee prenom or nom cannot be null or empty");
    }
    return personrepository.save(person);
    }

    @Override
    public List<Person> get_person() {
        
        return personrepository.findAll();
    }

    @Override
    public Person get_person_by_id(String id) {
        return personrepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Aucun Person n'est trouvé avec cet ID : " + id));
    }

    @Override
    public String delete_person_id(String id) {
       Person employee = personrepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Aucun Person n'est trouvé avec cet ID : " + id));
        personrepository.delete(employee);
        return "Employee deleted with this Id: " + id;
    }

}
