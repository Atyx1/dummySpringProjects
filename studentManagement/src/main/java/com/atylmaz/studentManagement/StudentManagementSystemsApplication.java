package com.atylmaz.studentManagement;

import com.atylmaz.studentManagement.entity.Student;
import com.atylmaz.studentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemsApplication.class, args);
	}


	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		/*Student student_1= new Student("esra","iridag","sumes38@gmail.com");
		Student student_2= new Student("ahmet","iridag","ahmet@gmail.com");
		Student student_3= new Student("kutay","iridag","kutay38@gmail.com");
		studentRepository.save(student_1);
		studentRepository.save(student_2);
		studentRepository.save(student_3);*/

	}
}
