package com.flynaut.studentCrud.controller;

import com.flynaut.studentCrud.entity.Student;
import com.flynaut.studentCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        try {
            return ResponseEntity.ok(studentService.updateStudent(id, student));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}







/*
    {
        "name": "Pranav Mahajan",
        "email": "pranav@gmail.com",
        "age": 25,
        "city": "Dasnur"
    }
    {
        "name": "Yash Mahajan",
        "email": "yash@gmail.com",
        "age": 23,
        "city": "Singnur"
    }
    {
        "name": "Kunal Mahajan",
        "email": "kunal@gmail.com",
        "age": 20,
        "city": "Savda"
    }
    {
        "name": "Sujal Mahajan",
        "email": "sujal@gmail.com",
        "age": 14,
        "city": "Jalgaon"
    }
 */