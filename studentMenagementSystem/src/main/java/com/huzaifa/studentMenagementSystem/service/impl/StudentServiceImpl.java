package com.huzaifa.studentMenagementSystem.service.impl;


import org.springframework.stereotype.Service;

import com.huzaifa.studentMenagementSystem.dto.StudentDto;
import com.huzaifa.studentMenagementSystem.entity.Student;
import com.huzaifa.studentMenagementSystem.mapper.StudentMapper;
import com.huzaifa.studentMenagementSystem.repository.StudentRepository;
import com.huzaifa.studentMenagementSystem.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentDto createStudent(StudentDto dto) {
        Student student = StudentMapper.mapToStudent(dto);
        Student saved = repo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    @Override
    public StudentDto getStudent(Long id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return repo.findAll()
                .stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto dto) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        Student updated = repo.save(student);
        return StudentMapper.mapToStudentDto(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        repo.delete(student);
    }
}

