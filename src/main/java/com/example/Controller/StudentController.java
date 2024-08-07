package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		return service.createStudent(student);
	}

	@GetMapping("/student")
	public List<Student> getAllStudent() {
		return service.getAll();
	}

	@GetMapping("/student/{stid}")
	public Student getStudentById(@PathVariable("stid") Integer x) {
		return service.getStudentById(x);
	}

	@PutMapping("/student/{stid}")
	public Student updateStudentById(@PathVariable("stid") Integer x, @RequestBody Student student) {
		return service.updateStudentById(x, student);
	}

	@DeleteMapping("/student/{stid}")
	public String deleteStudentById(@PathVariable("stid") Integer x) {
		service.deleteStudentById(x);
		return "student deleted successfully with " + x + " id";
	}

}
