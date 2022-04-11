package com.reshma.patientscheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reshma.patientscheduling.entities.Patients;

public interface PatientsRepository extends CrudRepository<Patients, Long>{

}
