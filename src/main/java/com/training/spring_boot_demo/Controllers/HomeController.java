package com.training.spring_boot_demo.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.training.spring_boot_demo.Model.User;

@RestController
public class HomeController {

   @RequestMapping("/")
   public String home() {
    return "Bienvenue Dirane serges";
   }



   @GetMapping("/user")

   public User user()
   {
     var user = new User();
         user.Id = "1";
         user.Nom ="Dirane Serges";
         user.Prenom ="pavel";
 
     return user;
   }
}
