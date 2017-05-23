package com.faikturan.hastaneotomasyonu.service;

import java.util.List;

import com.faikturan.hastaneotomasyonu.entity.Hastaneler;

public class HospitalsService {

	List<Hastaneler> hospitalResults;

	public List<Hastaneler> getHospitalResults() {
		return hospitalResults;
	}

	public void setHospitalResults(List<Hastaneler> hospitalResults) {
		this.hospitalResults = hospitalResults;
	}
	
	

}
