package com.reshma.patientscheduling.entities;


import java.sql.Timestamp;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private long id;
	private LocalTime appointment_time;
	private boolean started;
	private boolean ended;
	private String reason;
	
	@ManyToOne
	private Patients patient;
	
	@ManyToOne
	private Doctor doctor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalTime getAppointment_time() {
		return appointment_time;
	}

	public void setAppointment_time(LocalTime appointment_time) {
		this.appointment_time = appointment_time;
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

	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
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
		return "Appointment [id=" + id + ", appointment_time=" + appointment_time + ", started=" + started + ", ended="
				+ ended + ", reason=" + reason + ", patient=" + patient + ", doctor=" + doctor + "]";
	}
	
	
	
	
}
