package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/students")
public class StudentWebController {
    private final StudentService studentService;

    public StudentWebController(StudentService studentService){
        this.studentService=studentService;
    }

    //READ-Display all students
    @GetMapping
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students"; //points to --->student.html
    }

    //CREATE -- Show add form
    @GetMapping("/add")
    public String showAddForm(Model model)
    {
        model.addAttribute("student", new Student());
        return "student-add"; //templates--->add- student.html
    }

    //CREATE - Handle for submit
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student")Student student) {
        studentService.saveStudent(student);        
        return "redirect:/students";
        }
        
        //UPDATE-Show edit form
        @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable Long id,Model model) {
            Student student=studentService.getStudentById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid student ID"+id));
            model.addAttribute("student", student);
            return "student-edit"; //template/student-edit.html
        }
        //Update - handle edit submit
        @PostMapping("/update/{id}")
        public String updateStudent(@PathVariable Long id,
        @ModelAttribute("student") Student updatedStudent) {
            studentService.updateStudent(id, updatedStudent);    
            return "redirect:/students";
        }
    
    //DELETE
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
    
        
}
