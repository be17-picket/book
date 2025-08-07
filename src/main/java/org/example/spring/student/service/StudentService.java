package org.example.spring.student.service;


import org.example.spring.student.model.StudentEntity;
import org.example.spring.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void register(StudentDto.Register dto) {
        studentRepository.save(dto.toEntity());
    }

    public List<StudentDto.Student> list() {
        List<StudentEntity> result = studentRepository.findAll();

        return result.stream().map(StudentDto.Student::from).toList();
    }

    public StudentDto.Student read(Integer idx) {
        Optional<StudentEntity> result = studentRepository.findById(idx);

        if (result.isPresent()) {
            StudentEntity entity = result.get();

            return StudentDto.Student.from(entity);
        }

        return null;
    }

    public List<StudentDto.Student> search(String name) {
        List<StudentEntity> result = studentRepository.findByName(name);

        return result.stream().map(StudentDto.Student::from).toList();
    }
}
