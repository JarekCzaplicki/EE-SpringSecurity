package com.eespringsecurity.controller;

import com.eespringsecurity.model.Student;
import com.google.common.collect.Lists;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {
    private List<Student> students = Lists.newArrayList(
            new Student(1, "S1"),
            new Student(2, "S2"),
            new Student(3, "S3")
    );

//    @PreAuthorize() przyjmuje
//    - hasRole('ROLE_ADMIN')
//    - hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT')
//    - hasAuthority('student:write')
//    - hasAnyAuthority('student:write', 'student:read')

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('students:post')")
    public String registerNewStudent(@RequestBody Student student) {
        students.add(student);
        return "registerNewStudent: " + student;
    }

    @DeleteMapping()
    @PreAuthorize("hasAuthority('students:delete')")
    public Student deleteStudent(@RequestBody Student student) {
        students.remove(student);
        return student;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('students:put')")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student student) {
        return student;
    }
}
