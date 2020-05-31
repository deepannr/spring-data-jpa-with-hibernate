package com.spring.boot.jpa.miniProj.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MP_DOCTOR")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName;

	private String lastName;

	private String speciality;

	@ManyToMany(mappedBy = "doctors")
	private Set<Patient> patients;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Appointment> appointments;

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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	
	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", speciality=" + speciality
				+ "]";
	}
}
