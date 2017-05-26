package com.faikturan.hastaneotomasyonu.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.service.DoctorService;


@ManagedBean(name="getDoctors")
@ViewScoped
public class GetDoctors implements Serializable {

	@ManagedProperty(value="#{saveAppointments}")
	private SaveAppointments saveAppointments;

	
	public SaveAppointments getSaveAppointments() {
		return saveAppointments;
	}

	public void setSaveAppointments(SaveAppointments saveAppointments) {
		this.saveAppointments = saveAppointments;
	}

	public List<String> fillList() throws Exception
	{
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		DoctorService  doctorService = 
				  (DoctorService) context.getBean("doctorService");
		return doctorService.getAllDoctorNames(saveAppointments.getClinic(), 
				saveAppointments.getHospital());
		
	}
}
