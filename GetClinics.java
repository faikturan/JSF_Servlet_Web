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
import com.faikturan.hastaneotomasyonu.service.ClinicService;


@ManagedBean(name="getClinics")
@ViewScoped
public class GetClinics implements Serializable {

	public List<String> fillList() throws Exception
	{
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		ClinicService  clinicService = 
				 (ClinicService) context.getBean("clinicService");
		return clinicService.getAllClinicNames();
		
	}
}
