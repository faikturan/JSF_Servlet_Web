package com.faikturan.hastaneotomasyonu.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.entity.Hastaneler;
import com.faikturan.hastaneotomasyonu.service.AvailableAppointmentsService;
import com.faikturan.hastaneotomasyonu.service.CitiesService;
import com.faikturan.hastaneotomasyonu.service.ClinicPlacesService;
import com.faikturan.hastaneotomasyonu.service.HospitalsService;


@ManagedBean(name="getClinicPlaces")
@ViewScoped
public class GetClinicPlaces implements Serializable {

	@ManagedProperty(value="#{saveAppointments}")
	private SaveAppointments appointmentObject;
	
	int hospitalId;
	
	
	public SaveAppointments getAppointmentObject() {
		return appointmentObject;
	}


	public void setAppointmentObject(SaveAppointments appointmentObject) {
		this.appointmentObject = appointmentObject;
	}


	public int getHospitalId() {
		return hospitalId;
	}


	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}


	public List<String> fillList() throws Exception
	{
		String currentHospital = appointmentObject.getHospital();
		
		System.out.println("Seçilen Klinik: " +appointmentObject.getClinic());
		
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		HospitalsService  hospitalsService = 
				 (HospitalsService) context.getBean("hospitalService");
		ClinicPlacesService clinicPlacesService = 
				(ClinicPlacesService) context.getBean("clinicPlacesService");
		
		for (Hastaneler h : hospitalsService.getHospitalResults()) {
			if (h.getHastaneadi().equals(currentHospital)) {
				setHospitalId(h.getId());
				break;
			}
		}
		
		return clinicPlacesService.getAllClinicNames(hospitalId);
		
	}
}
