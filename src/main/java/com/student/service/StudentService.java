package com.student.service;

import java.time.LocalDate;
import java.time.Period;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) {

		// Validate first name and last name length
		if (student.getFirstName().length() < 3 || student.getLastName().length() < 3) {
			throw new IllegalArgumentException("First name and last name must be at least 3 characters long.");
		}

		// Validate date of birth and age
		LocalDate dob = student.getDob();
		if (dob == null) {
			throw new IllegalArgumentException("Date of birth is mandatory.");
		}
		LocalDate now = LocalDate.now();
		int age = Period.between(dob, now).getYears();
		if (age <= 15 || age > 20) {
			throw new IllegalArgumentException("Age must be greater than 15 years and less than or equal to 20 years.");
		}

		// Validate marks range
		int marks1 = student.getMarks1() != null ? student.getMarks1() : 0;
		int marks2 = student.getMarks2() != null ? student.getMarks2() : 0;
		int marks3 = student.getMarks3() != null ? student.getMarks3() : 0;
		if (marks1 < 0 || marks1 > 100 || marks2 < 0 || marks2 > 100 || marks3 < 0 || marks3 > 100) {
			throw new IllegalArgumentException("Marks should be between 0 and 100.");
		}

		// Validate section
		String section = student.getSection();
		if (!section.equals("A") && !section.equals("B") && !section.equals("C")) {
			throw new IllegalArgumentException("Section must be A, B, or C.");
		}

		// Validate gender
		String gender = student.getGender();
		if (!gender.equals("M") && !gender.equals("F")) {
			throw new IllegalArgumentException("Gender must be M or F.");
		}

		// Calculate total and average marks
		int total = marks1 + marks2 + marks3;
		double average = total / 3.0;

		// Determine result
		String result = average >= 35? "Pass" : "Fail";

		// Set calculated fields in student object
		student.setTotal(total);
		student.setAverage(average);
		student.setResult(result);

		// Save student object in database
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) {
		Student existingStudent = studentRepository.findById(student.getId())
				.orElseThrow(() -> new IllegalArgumentException(student.getId() + "not found"));

		return createStudent(student);

	}
}
