package com.example.demo.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
// import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table( name = "students")
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Getter @Setter
     private long Id;
     @Getter @Setter
     private String firstName;
     @Getter @Setter
     private String lastName;
     @Getter @Setter
     private Integer age;
     @Getter @Setter
     private String phone;    
}