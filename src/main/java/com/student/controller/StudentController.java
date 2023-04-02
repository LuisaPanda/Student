package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		// Validate age
		Student createdStudent = studentService.createStudent(student);
		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		// Validate age
		Student updateStudent = studentService.updateStudent(student);
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);
	}

}
