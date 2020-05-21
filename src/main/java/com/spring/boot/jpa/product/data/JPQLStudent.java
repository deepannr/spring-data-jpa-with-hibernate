package com.spring.boot.jpa.product.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Student")
@ApiModel("All Details about Student")
public class JPQLStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studId")
	private int id;

	@NotNull(message = "{validation.student.firstName}")
	@Size(min = 3, message = "{validation.student.firstName.length}")
	@ApiModelProperty(notes = "First Name should not be empty")
	@Column(name = "fName")
	private String firstName;

	@NotNull(message = "{validation.student.lastName}")
	@Size(min = 3, message = "{validation.student.lastName.length}")
	@ApiModelProperty(notes = "Last Name should not be empty")
	@Column(name = "lName")
	private String lastName;

	@PositiveOrZero(message = "{validation.student.marks}")
	@ApiModelProperty(notes = "Marks should be zero or more")
	@Column(name = "score")
	private int marks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}
