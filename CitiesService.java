package com.faikturan.hastaneotomasyonu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.faikturan.hastaneotomasyonu.entity.Iller;
import com.faikturan.hastaneotomasyonu.facade.CitiesFacade;

public class CitiesService {
	
	@Autowired
	private CitiesFacade citiesFacade;
	
	List<Iller> cityResults;
	List<String> cities;
	int cityId;
	
	public CitiesFacade getCitiesFacade() {
		return citiesFacade;
	}

	public void setCitiesFacade(CitiesFacade citiesFacade) {
		this.citiesFacade = citiesFacade;
	}

	public List<Iller> getCityResults() {
		return cityResults;
	}

	public void setCityResults(List<Iller> cityResults) {
		this.cityResults = cityResults;
	}



	public List<String> getCities() {
		return cities;
	}



	public void setCities(List<String> cities) {
		this.cities = cities;
	}



	public int getCityId() {
		return cityId;
	}



	public void setCityId(int cityId) {
		this.cityId = cityId;
	}



	public List<String> getAllCityNames() {
		cities = new ArrayList<>();
		try {
			cityResults = citiesFacade.findListByNamedQuery("Iller.findAll");
		} catch (Exception e) {
			System.err.println("An Error Occured! Error is: " +e);
		}
		
		for (Iller i : cityResults) 
		{
			cities.add(i.getSehir());
		}
		return cities;
	}

}
