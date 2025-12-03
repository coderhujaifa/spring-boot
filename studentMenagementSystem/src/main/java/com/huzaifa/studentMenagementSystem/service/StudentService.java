package com.huzaifa.studentMenagementSystem.service;

import java.util.List;

import com.huzaifa.studentMenagementSystem.dto.StudentDto;

public interface StudentService {

    StudentDto createStudent(StudentDto dto);

    StudentDto getStudent(Long id);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long id, StudentDto dto);

    void deleteStudent(Long id);
}

