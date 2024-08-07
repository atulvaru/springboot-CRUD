package com.example.service;

import java.util.List;

import com.example.entity.Student;

public interface StudentService {
	Student createStudent(Student student);

	public List<Student> getAll();

	public void deleteStudentById(Integer x);

	public Student getStudentById(Integer x);

	Student updateStudentById(Integer x, Student student);

}
