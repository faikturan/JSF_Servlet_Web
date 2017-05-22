package com.faikturan.hastaneotomasyonu.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.entity.Takenappointments;
import com.faikturan.hastaneotomasyonu.service.TakenAppointmentsService;

@ManagedBean
@ViewScoped
public class GetAppointmentsOfPatient implements Serializable {

	List<Takenappointments> takenappointmentsOfPatient;
	Boolean cancelButtonmRendered;
	Boolean passedText;
	String cancelMessage;
	
	@ManagedProperty(value = "#{saveAppointments}")
	private SaveAppointments saveAppointments;
	
	public void fillList() throws Exception{
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		TakenAppointmentsService takenAppointmentsService = 
				(TakenAppointmentsService) context.getBean("takenAppointmentsService");
		
		takenappointmentsOfPatient = 
				takenAppointmentsService.
				getAppointmentsOfPatient(saveAppointments.comingIdentityNumber);
	}
	
	public void cancelAppointment(){
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		TakenAppointmentsService takenAppointmentsService = 
				(TakenAppointmentsService) context.getBean("takenAppointmentsService");
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		cancelMessage = takenAppointmentsService.cancelAppointment
				(Integer.parseInt(params.get("takenAppointmentId")));
		
	}
	

	public List<Takenappointments> getTakenappointmentsOfPatient() {
		return takenappointmentsOfPatient;
	}

	public void setTakenappointmentsOfPatient(List<Takenappointments> takenappointmentsOfPatient) {
		this.takenappointmentsOfPatient = takenappointmentsOfPatient;
	}

	public Boolean getCancelButtonmRendered() {
		return cancelButtonmRendered;
	}

	public void setCancelButtonmRendered(Boolean cancelButtonmRendered) {
		this.cancelButtonmRendered = cancelButtonmRendered;
	}

	public Boolean getPassedText() {
		return passedText;
	}

	public void setPassedText(Boolean passedText) {
		this.passedText = passedText;
	}

	public String getCancelMessage() {
		return cancelMessage;
	}

	public void setCancelMessage(String cancelMessage) {
		this.cancelMessage = cancelMessage;
	}

	public SaveAppointments getSaveAppointments() {
		return saveAppointments;
	}

	public void setSaveAppointments(SaveAppointments saveAppointments) {
		this.saveAppointments = saveAppointments;
	}
	
	
	
}
