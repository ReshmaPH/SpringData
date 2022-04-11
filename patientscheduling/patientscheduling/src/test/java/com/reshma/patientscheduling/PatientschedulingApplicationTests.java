package com.reshma.patientscheduling;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reshma.patientscheduling.entities.Appointment;
import com.reshma.patientscheduling.entities.Doctor;
import com.reshma.patientscheduling.entities.Insurance;
import com.reshma.patientscheduling.entities.Patients;
import com.reshma.patientscheduling.repositories.AppointmentRepository;
import com.reshma.patientscheduling.repositories.DoctorRepository;
import com.reshma.patientscheduling.repositories.PatientsRepository;

@SpringBootTest
class PatientschedulingApplicationTests {
	@Autowired
	DoctorRepository doctorRepo;
	@Autowired
	PatientsRepository patientsRepo;
	@Autowired
	AppointmentRepository appointmentRepo;

	@Test
	void testCreateDoctor() {
		Doctor doctor=new Doctor();
		doctor.setFirstName("Appu");
		doctor.setLastName("Appu");
		doctor.setSpeciality("Pediatrician");
		
		doctorRepo.save(doctor);
	}
	
	@Test
	void testCreatePatient() {
		Patients patient=new Patients();
		patient.setFirstName("Thennal");
		patient.setLastName("K");
		patient.setPhone("12345678");
		
		Insurance insurance=new Insurance();
		insurance.setCopay(20000.10);
		insurance.setProvider_name("Kimji");
		
		patient.setInsurance(insurance);
		Doctor doctor=doctorRepo.findById(101L).get();
		List<Doctor> doctors=new ArrayList();
		doctors.add(doctor);
		patient.setDoctors(doctors);
		
		patientsRepo.save(patient);
	}
	
	@Test
	void testCreateAppointment() {
		
		Appointment appointment=new Appointment();
		LocalTime appointmentTime=LocalTime.now();
		appointment.setAppointment_time(appointmentTime);
		appointment.setDoctor(doctorRepo.findById(101L).get());
		appointment.setPatient(patientsRepo.findById(104L).get());
		appointment.setReason("fever");
		appointment.setStarted(true);
		appointmentRepo.save(appointment);
		
		
	}
	

}
