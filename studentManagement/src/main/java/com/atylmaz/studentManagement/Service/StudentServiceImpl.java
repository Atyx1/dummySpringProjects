package com.atylmaz.studentManagement.Service;

import com.atylmaz.studentManagement.entity.Student;
import com.atylmaz.studentManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository theStudentRepository){

         this.studentRepository=theStudentRepository;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Student student=studentRepository.getReferenceById(id);
        return student;
    }
}
