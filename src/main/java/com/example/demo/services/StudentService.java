package com.example.demo.services;

import com.example.demo.Models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

 @Autowired
 private StudentRepository studentRepository;

 // Sauvegarde ou mise à jour de l'étudiant
 public Student saveStudent(Student student) {
  return studentRepository.save(student); // Utilise save() qui gère la création et la mise à jour
 }

 // Récupère tous les étudiants
 public List<Student> getAllStudents() {
  return studentRepository.findAll();
 }


 // Supprime un étudiant par son ID
 public void deleteStudentById(Long id) {
  studentRepository.deleteById(id);
 }

 // Récupère un étudiant par son ID
 public Student getStudentById(Long id) {
  return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
 }
}
