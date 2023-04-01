package com.atylmaz.studentManagement.controller;

import com.atylmaz.studentManagement.Service.StudentService;
import com.atylmaz.studentManagement.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }




    @GetMapping("/students")
    public String ListStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String addStudentForm(Model model) {
        //create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);

        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id,Model model) {

              model.addAttribute("student",studentService.getStudentById(id));
             //return de dönülen değerleri html sayfası olarak oluşturuyoruz
             return "edit_student";

    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
      @ModelAttribute("student") Student student1,
        Model model){

        Student existingStudent=studentService.getStudentById(id);
        existingStudent.setEmail(student1.getEmail());
        existingStudent.setFirstName(student1.getFirstName());
        existingStudent.setLastName(student1.getLastName());
        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }




}

















