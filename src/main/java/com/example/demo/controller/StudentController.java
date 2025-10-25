package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    //CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }
    // READ - All
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }
    // READ - By ID
    @GetMapping("id/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) 
    {
        return studentService.getStudentById(id);
    }
    // READ - By Name
    @GetMapping("/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) 
    {
        return studentService.getStudentsByName(name);
    }

    //UPDATE (PUT)-Replace full object
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {     
        return studentService.updateStudent(id,updatedStudent);
    }

    //Partial Update (PATCH) - Update only provided fields
    @PatchMapping("/{id}")
    public Student partialUpdateStudent(@PathVariable Long id, @RequestBody Student partialStudent){
        return studentService.partialUpdateStudent(id, partialStudent);
    }
    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        boolean isDeleted = studentService.deleteStudent(id);
        return isDeleted ? "Student deleted successfully" : "Student not found";
    }
}
