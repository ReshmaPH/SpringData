package com.reshma.patientscheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reshma.patientscheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
