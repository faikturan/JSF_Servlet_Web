package com.faikturan.hastaneotomasyonu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.entity.Doktorlar;
import com.faikturan.hastaneotomasyonu.entity.Hastaneler;
import com.faikturan.hastaneotomasyonu.entity.Klinikler;
import com.faikturan.hastaneotomasyonu.facade.DoctorFacade;

public class DoctorService {

	@Autowired
	private DoctorFacade doctorFacade;
	
	List<Doktorlar> doctorResults;
	List<String> doctors;
	
	
	public List<String> getAllDoctorNames(String clinic, String hospital) throws Exception {
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		ClinicService clinicService = (ClinicService) context.getBean("clinicService");
		
		int clinicId = 0;
		for (Klinikler k : clinicService.getClinicResults()) {
			if (k.getKlinikadi().equals(clinic)) {
				clinicId = k.getId();
				break;
			}
			
		}
		
		int hospitalId=0;
		
		HospitalsService hospitalsService = 
				(HospitalsService) context.getBean("hospitalService");
		for (Hastaneler h : hospitalsService.getHospitalResults()) {
			if (h.getHastaneadi().equals(hospital)) {
				hospitalId = h.getId();
			}
			
		}
		
		doctors = new ArrayList<>();
		Map map = new HashMap();
		map.put("clinicid", clinicId);
		map.put("hospitalid", hospitalId);
		doctorResults =
				doctorFacade.findListByNamedQuery
				("Doktorlar.findByBransIdAndHastaneID", map);
		for (Doktorlar d : doctorResults) {
			doctors.add(d.getDoktoradi());
		}
		return doctors;
	}

}

