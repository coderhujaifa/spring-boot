package com.huzaifa.studentMenagementSystem.mapper;

import com.huzaifa.studentMenagementSystem.dto.StudentDto;
import com.huzaifa.studentMenagementSystem.entity.Student;

public class StudentMapper {

    public static Student mapToStudent(StudentDto dto) {
        return new Student(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getCourse()
        );
    }

    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }
} 
