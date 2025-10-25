package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }

    //CREATE
    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    //READ
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long Id)
    {
        return studentRepository.findById(Id);        
    }

    public List<Student> getStudentsByName(String name)
    {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    //UPDATE
    public Student updateStudent(Long id, Student updatedStudent)
    {
        return studentRepository.findById(id)
        .map(student ->{
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setEmail(updatedStudent.getEmail());
            return studentRepository.save(student);
        })
        .orElseThrow(()-> new RuntimeException("Student not found"));
    }

    //PARTIAL UPDATE
    // PARTIAL UPDATE
    public Student partialUpdateStudent(Long id, Student partialStudent) {
    return studentRepository.findById(id)
        .map(student -> {
            if (partialStudent.getName() != null)
                student.setName(partialStudent.getName());

            if (partialStudent.getEmail() != null)
                student.setEmail(partialStudent.getEmail());

            if (partialStudent.getAge() != 0)
                student.setAge(partialStudent.getAge());

            // Save updated entity
            return studentRepository.save(student);
        })
        .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
}
    //Delete
    public boolean deleteStudent(Long id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        } 
        return false;
    }




    
}


