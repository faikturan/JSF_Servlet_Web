package com.faikturan.hastaneotomasyonu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.faikturan.hastaneotomasyonu.entity.Klinikler;
import com.faikturan.hastaneotomasyonu.facade.ClinicFacade;

public class ClinicService {
	
	List<Klinikler> clinicResults;
	List<String> clinics;
	
	@Autowired
	private ClinicFacade clinicFacade;

	public List<Klinikler> getClinicResults() {
		return clinicResults;
	}

	public void setClinicResults(List<Klinikler> clinicResults) {
		this.clinicResults = clinicResults;
	}

	public List<String> getAllClinicNames() throws Exception {
		clinics = new ArrayList<>();
		clinicResults = clinicFacade.findListByNamedQuery("Klinikler.findAll");
		for (Klinikler k : clinicResults) {
			clinics.add(k.getKlinikadi());
		}
		return clinics;
	}
	
	

}
