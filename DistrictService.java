package com.faikturan.hastaneotomasyonu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.faikturan.hastaneotomasyonu.entity.Ilceler;
import com.faikturan.hastaneotomasyonu.entity.Iller;
import com.faikturan.hastaneotomasyonu.facade.DistrictsFacade;

public class DistrictService {

	private List<Ilceler>districtResults;
	private List<String> districtNames;
	
	@Autowired
	private DistrictsFacade districtsFacade;
	
	@Autowired
	private CitiesService citiesService;
	
	
	public List<Ilceler> getDistrictResults() {
		return districtResults;
	}


	public void setDistrictResults(List<Ilceler> districtResults) {
		this.districtResults = districtResults;
	}


	public List<String> getDistrictNames() {
		return districtNames;
	}


	public void setDistrictNames(List<String> districtNames) {
		this.districtNames = districtNames;
	}


	public DistrictsFacade getDistrictsFacade() {
		return districtsFacade;
	}


	public void setDistrictsFacade(DistrictsFacade districtsFacade) {
		this.districtsFacade = districtsFacade;
	}


	public CitiesService getCitiesService() {
		return citiesService;
	}


	public void setCitiesService(CitiesService citiesService) {
		this.citiesService = citiesService;
	}


	public List<String> getAllDistrictNames(String currentCity) throws Exception {
		int cityId = 0;
		for (Iller i : citiesService.getAllResults()) {
			if (i.getSehir().equals(currentCity)) {
				cityId = i.getId();
				break;
			}
		}
		
		Map parameters = new HashMap();
		parameters.put("sehir", cityId);
		districtResults = 
				districtsFacade.
				findListByNamedQuery("Ilceler.findBySehir", parameters);
		districtNames = new ArrayList<>();
		
		for (Ilceler i : districtResults) {
			districtNames.add(i.getIlce());
		}
		return districtNames;
	}

}
