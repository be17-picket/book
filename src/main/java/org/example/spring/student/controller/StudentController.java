package org.example.spring.student.controller;

import org.example.spring.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody StudentDto.Register dto) {
        studentService.register(dto);

        return ResponseEntity.status(200).body("등록 성공");
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<StudentDto.Student> response = studentService.list();

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/read")
    public ResponseEntity read(Integer idx) {
        StudentDto.Student response = studentService.read(idx);

        return ResponseEntity.status(200).body(response);
    }


    @GetMapping("/search")
    public ResponseEntity search(String name) {
        List<StudentDto.Student> response = studentService.search(name);

        return ResponseEntity.status(200).body(response);
    }


}
