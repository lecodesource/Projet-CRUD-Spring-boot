package com.example.demo.controllers;

import com.example.demo.Models.Student;
import com.example.demo.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// pour ajouter des prefixes
@RequestMapping("/api")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public  String  hello(){
        return this.helloService.hello();

    }
    /*@GetMapping("/test")
    public ResponseEntity<Student> introduction() {

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("DOE");
        return ResponseEntity.ok(student);
    }*/
}
