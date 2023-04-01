package com.atylmaz.studentManagement.Service;

import com.atylmaz.studentManagement.entity.Student;

import java.util.List;

public interface StudentService {
List<Student> getAllStudents();

Student addStudent(Student student);
Student updateStudent(Student student);
Student getStudentById(Long id);


}
