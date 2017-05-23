package com.faikturan.hastaneotomasyonu.service;

import java.util.List;

import com.faikturan.hastaneotomasyonu.entity.Klinikler;

public class ClinicService {
	
	List<Klinikler> clinicResults;

	public List<Klinikler> getClinicResults() {
		return clinicResults;
	}

	public void setClinicResults(List<Klinikler> clinicResults) {
		this.clinicResults = clinicResults;
	}
	
	

}
