package com.eespringsecurity.controller;

import com.eespringsecurity.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Student 1"), // index 0
            new Student(2, "Student 2"), // index 1
            new Student(3, "Student 3")  // index 2
    );
// localhost:8080/api/v1/students/4
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
//        return STUDENTS.get(id); // index 4 means that the collection have a 5 elements
    return STUDENTS.stream()
            .filter(student ->student.getStudentId().equals(id))
            .findFirst()
            .orElseThrow(()-> new IllegalStateException(
                    "Student with id " + id + " not found"
            ));
    }

}
