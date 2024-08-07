package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.exception.UserIdNotFoundException;
import com.example.respositroy.StudentRepository;

@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public void deleteStudentById(Integer x) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(x);
	}

	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(()->new UserIdNotFoundException("user with id : " + id + " Not Found"));
	}

	@Override
	public Student updateStudentById(Integer x, Student student) {
		// TODO Auto-generated method stub
		Student retrievedStudent = studentRepository.findById(x).get();
		retrievedStudent.setStname(student.getStname());
		return studentRepository.save(retrievedStudent);
	}

}
