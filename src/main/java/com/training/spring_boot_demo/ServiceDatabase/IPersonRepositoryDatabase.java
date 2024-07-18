package com.training.spring_boot_demo.ServiceDatabase;

import org.springframework.data.jpa.repository.JpaRepository;


import com.training.spring_boot_demo.Model.Person;

public interface IPersonRepositoryDatabase extends JpaRepository<Person, String> {

}
