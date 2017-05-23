package com.faikturan.hastaneotomasyonu.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.service.AvailableAppointmentsService;
import com.faikturan.hastaneotomasyonu.service.CitiesService;


@ManagedBean(name="getCities")
@ViewScoped
public class GetCities implements Serializable {

	public List<String> fillList()
	{
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		CitiesService  citiesService = 
				(CitiesService) context.getBean("citiesService");
		return citiesService.getAllCityNames();
		
	}
}
