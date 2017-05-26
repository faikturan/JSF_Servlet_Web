package com.faikturan.hastaneotomasyonu.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.service.AvailableAppointmentsService;
import com.faikturan.hastaneotomasyonu.service.CitiesService;
import com.faikturan.hastaneotomasyonu.service.ClinicService;
import com.faikturan.hastaneotomasyonu.service.DistrictService;


@ManagedBean(name="getDistricts")
@ViewScoped
public class GetDistricts implements Serializable {

	@ManagedProperty(value="#{saveAppointments}")
	private SaveAppointments saveAppointments;
	
	String currentCity;
	
	public SaveAppointments getSaveAppointments() {
		return saveAppointments;
	}

	public void setSaveAppointments(SaveAppointments saveAppointments) {
		this.saveAppointments = saveAppointments;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public List<String> fillList() throws Exception
	{
		System.out.println("Get Districts FillList metodu çalýþtý!");
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		DistrictService  districtService = 
				 (DistrictService) context.getBean("districtService");
		return districtService.getAllDistrictNames(saveAppointments.getCurrentCity());
		
	}
}
