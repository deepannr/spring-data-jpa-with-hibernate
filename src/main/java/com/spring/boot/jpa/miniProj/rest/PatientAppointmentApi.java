package com.spring.boot.jpa.miniProj.rest;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.jpa.miniProj.data.Appointment;
import com.spring.boot.jpa.miniProj.data.Doctor;
import com.spring.boot.jpa.miniProj.data.InputAppointment;
import com.spring.boot.jpa.miniProj.data.InputDoctor;
import com.spring.boot.jpa.miniProj.data.InputPatient;
import com.spring.boot.jpa.miniProj.data.Insurance;
import com.spring.boot.jpa.miniProj.data.Patient;
import com.spring.boot.jpa.miniProj.repo.AppointmentRepository;
import com.spring.boot.jpa.miniProj.repo.DoctorRepository;
import com.spring.boot.jpa.miniProj.repo.PatientRepository;

@RestController
@RequestMapping("/patientAppointment")
class PatientAppointmentApi {
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	
	@PostMapping("/addDoctor")
	public Iterable<Doctor> addDoctor(@RequestBody InputDoctor input) {
		Doctor doctor = new Doctor();
		doctor.setFirstName(input.getFirstName());
		doctor.setLastName(input.getLastName());
		doctor.setSpeciality(input.getSpeciality());
		doctorRepo.save(doctor);
		
		return doctorRepo.findAll();
	}
	
	@GetMapping("/findAllDoctors")
	public Iterable<Doctor> findAllDoctors() {
		return doctorRepo.findAll();
	}
	
	@PostMapping("/addPatient")
	public Iterable<Patient> addPatient(@RequestBody InputPatient input) {
		Insurance insurance = new Insurance();
		insurance.setProviderName(input.getProviderName());
		insurance.setCopay(input.getCopay());
		
		Patient patient = new Patient();
		patient.setFirstName(input.getFirstName());
		patient.setLastName(input.getLastName());
		patient.setPhone(input.getPhone());
		patient.setInsurance(insurance);
		patientRepo.save(patient);
		
		return patientRepo.findAll();
	}
	
	@GetMapping("/findAllPatients")
	public Iterable<Patient> findAllPatients() {
		return patientRepo.findAll();
	}
	
	@PostMapping("/setAppointment")
	public Iterable<Appointment> setAppointment (@RequestBody InputAppointment input) {
		Appointment appointment = new Appointment();
		Timestamp now = new Timestamp(new Date().getTime());
		appointment.setAppointmentDate(now);
		appointment.setPatient(patientRepo.findAllPatientsByName(input.getPatientName()));
		appointment.setDoctor(doctorRepo.findAllDoctorByName(input.getDoctorName()));
		appointment.setStarted(true);
		appointment.setReason(input.getReason());

		appointmentRepo.save(appointment);
		
		return appointmentRepo.findAll();
	}
	
	@GetMapping("/findAllAppointments")
	public Iterable<Appointment> findAllAppointments() {
		return appointmentRepo.findAll();
	}
}
