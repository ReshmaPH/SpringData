package com.reshma.patientscheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reshma.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long>{

}
