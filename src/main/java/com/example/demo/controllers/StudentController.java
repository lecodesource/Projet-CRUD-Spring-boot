package com.example.demo.controllers;

import com.example.demo.Models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentsService;

    // Affichage de la page d'index (formulaire de création)
    @GetMapping("/index")
    public String AfficherPage(Model model) {
        model.addAttribute("student", new Student());
        return "students"; // Page de création (index.html)
    }

    // Enregistrement d'un étudiant (création et mise à jour)
    @PostMapping("/index")
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirect) {
        studentsService.saveStudent(student); // Sauvegarde l'étudiant, création ou mise à jour
        // redirect.addFlashAttribute("message", "Étudiant enregistré avec succès !");
        return "redirect:/students"; // Redirige vers la liste des étudiants
    }

    @GetMapping("/students")
    public String getAllStudents( Model model) {
        model.addAttribute("students", studentsService.getAllStudents());
        return "liststudents";
    }


    // Suppression d'un étudiant
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirect) {
        studentsService.deleteStudentById(id); // Suppression de l'étudiant
        redirect.addFlashAttribute("message", "Étudiant supprimé avec succès !");
        return "redirect:/students"; // Redirige vers la liste des étudiants
    }

    // Page de modification d'un étudiant
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentsService.getStudentById(id); // Récupère l'étudiant par son ID
        model.addAttribute("student", student); // Ajoute l'étudiant au modèle pour la vue
        return "modificationstudents"; // Affiche le formulaire de modification
    }

    // Mise à jour d'un étudiant
    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentsService.saveStudent(student); // Enregistre ou met à jour l'étudiant
        return "redirect:/students"; // Redirige vers la liste des étudiants
    }
}