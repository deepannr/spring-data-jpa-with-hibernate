package com.spring.boot.jpa.miniProj.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MP_APPOINTMENT")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Timestamp appointmentDate;

	private boolean started;

	private boolean ended;

	private String reason;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Timestamp appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded(boolean ended) {
		this.ended = ended;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDate=" + appointmentDate + ", started=" + started + ", ended="
				+ ended + ", reason=" + reason + "]";
	}
}
