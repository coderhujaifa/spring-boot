package com.huzaifa.studentMenagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huzaifa.studentMenagementSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
