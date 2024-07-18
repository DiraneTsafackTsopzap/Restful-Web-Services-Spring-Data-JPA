package com.training.spring_boot_demo.Model;

import java.util.UUID;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;



@Entity
public class Person {
    
    @Id
    public String Id = UUID.randomUUID().toString();
    public String Nom;
    public String Prenom;
}
