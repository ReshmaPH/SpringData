package com.reshma.patientscheduling.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Insurance {
	private String provider_name;
	private double copay;
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public double getCopay() {
		return copay;
	}
	public void setCopay(double copay) {
		this.copay = copay;
	}
	@Override
	public String toString() {
		return "Insurance [provider_name=" + provider_name + ", copay=" + copay + "]";
	}
	
}
