package com.student.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Size(min = 3, message = "First name should have atleast 3 characters")
	private String firstName;

//    @Size(min = 3, message = "Last name should have atleast 3 characters")
	private String lastName;

//    @NotNull(message = "DOB is mandatory")
//    @Past(message = "DOB should be a past date")
	private LocalDate dob;

	// @Pattern(regexp = "[ABC]", message = "Valid values for section are A, B and
	// C")
	private String section;

	// @Pattern(regexp = "[MF]", message = "Valid values for Gender are M or F")
	private String gender;

	// @Min(value = 0, message = "Marks range is 0 to 100")
	// @Max(value = 100, message = "Marks range is 0 to 100")
	private Integer marks1;

	// @Min(value = 0, message = "Marks range is 0 to 100")
	// @Max(value = 100, message = "Marks range is 0 to 100")
	private Integer marks2;

	// @Min(value = 0, message = "Marks range is 0 to 100")
	// @Max(value = 100, message = "Marks range is 0 to 100")
	private Integer marks3;

	private Integer total;
	private Double average;

	private String result;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getMarks1() {
		return marks1;
	}

	public void setMarks1(Integer marks1) {
		this.marks1 = marks1;
	}

	public Integer getMarks2() {
		return marks2;
	}

	public void setMarks2(Integer marks2) {
		this.marks2 = marks2;
	}

	public Integer getMarks3() {
		return marks3;
	}

	public void setMarks3(Integer marks3) {
		this.marks3 = marks3;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", section=" + section + ", gender=" + gender + ", marks1=" + marks1 + ", marks2=" + marks2
				+ ", marks3=" + marks3 + ", total=" + total + ", Average=" + average + ", result=" + result + "]";
	}

	public Student() {

	}

}
