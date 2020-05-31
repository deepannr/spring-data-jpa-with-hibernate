package com.spring.boot.jpa.miniProj.repo;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.jpa.miniProj.data.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
