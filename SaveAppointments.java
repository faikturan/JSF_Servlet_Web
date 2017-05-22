package com.faikturan.hastaneotomasyonu.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.entity.Takenappointments;
import com.faikturan.hastaneotomasyonu.entity.Uygunrandevular;
import com.faikturan.hastaneotomasyonu.service.SaveAppointmentsService;


@ManagedBean
@SessionScoped
public class SaveAppointments implements Serializable {

	private String currentCity = "";
	String comingIdentityNumber;
	String comingPassword;
	String currentDistrict;
	String clinic;
	private String city;
	String district;
	private String hospital;
	String clinicPlace;
	String doctor;
	private String clockId;
	Uygunrandevular selectedAppointment;
	String operationResult;
	
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getComingIdentityNumber() {
		return comingIdentityNumber;
	}
	public void setComingIdentityNumber(String comingIdentityNumber) {
		this.comingIdentityNumber = comingIdentityNumber;
	}
	public String getComingPassword() {
		return comingPassword;
	}
	public void setComingPassword(String comingPassword) {
		this.comingPassword = comingPassword;
	}
	public String getCurrentDistrict() {
		return currentDistrict;
	}
	public void setCurrentDistrict(String currentDistrict) {
		this.currentDistrict = currentDistrict;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getClinicPlace() {
		return clinicPlace;
	}
	public void setClinicPlace(String clinicPlace) {
		this.clinicPlace = clinicPlace;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getClockId() {
		return clockId;
	}
	public void setClockId(String clockId) {
		this.clockId = clockId;
	}
	public Uygunrandevular getSelectedAppointment() {
		return selectedAppointment;
	}
	public void setSelectedAppointment(Uygunrandevular selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}
	public String getOperationResult() {
		return operationResult;
	}
	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}
	
	
	public void saveToDb(ActionEvent event) throws Exception{
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		SaveAppointmentsService saveAppointmentsService = 
				(SaveAppointmentsService) context.getBean("saveAppointmentsService");
		Takenappointments takenappointmentsObject = new Takenappointments();
		takenappointmentsObject.setDoktorid(selectedAppointment.getDoktorid());
		takenappointmentsObject.setPatientid(comingIdentityNumber);
		takenappointmentsObject.setHospitalname(hospital);
		takenappointmentsObject.setClinicname(clinic);
		takenappointmentsObject.setClinicplace(clinicPlace);
		takenappointmentsObject.setClockid(Integer.parseInt(clockId));
		operationResult = saveAppointmentsService.saveAppointmentToDb(takenappointmentsObject);
		
	}
	
	
	

}
