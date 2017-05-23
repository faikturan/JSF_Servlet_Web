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

import com.faikturan.hastaneotomasyonu.entity.Randevusaatleri;
import com.faikturan.hastaneotomasyonu.entity.Uygunrandevular;
import com.faikturan.hastaneotomasyonu.service.AvailableAppointmentsService;

@ManagedBean(name="getAvailableAppointments")
@ViewScoped
public class GetAvailableAppointments implements Serializable {

	List<Object[]> doctorAndTimeList;
	List<Randevusaatleri> appointmentClockResults;
	
	boolean renderingTakingAppointmentInfo = true;
	boolean renderingClocks = false;
	boolean renderingDataTable = false;
	int hospitalid;
	
	@ManagedProperty(value="#{saveAppointments}")
	private SaveAppointments saveAppointmentsObjectInAvailableAppointments;
	
	
	public List<Uygunrandevular> fillList()
	{
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		AvailableAppointmentsService takenAppointmentsService = 
				(AvailableAppointmentsService) context.getBean
				("availebleAppointmentsService");
		setRenderingDataTable(true);
		
		return AvailableAppointmentsService.getAllAvailableAppointments
				(saveAppointmentsObjectInAvailableAppointments.getHospital(),
						saveAppointmentsObjectInAvailableAppointments.clinic,
						saveAppointmentsObjectInAvailableAppointments.clinicPlace);
		
	}
	
	public void changeRenderingStates(){
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		AvailableAppointmentsService availableAppointmentsService = 
				(AvailableAppointmentsService) context.getBean
				("availableAppointmentsService");
		
		
		Boolean[] array = 
				availableAppointmentsService.
				changeRenderingStates(saveAppointmentsObjectInAvailableAppointments);
		
		setDoctorAndTimeList(availableAppointmentsService.getDoctorAndTimeList());
		setAppointmentClockResults(availableAppointmentsService.
				getAppointmentClockResults());
		
		setRenderingTakingAppointmentInfo(array[0]);
		setRenderingClocks(array[1]);
	}
	
	
	public SaveAppointments getSaveAppointmentsObjectInAvailableAppointments() {
		return saveAppointmentsObjectInAvailableAppointments;
	}
	public void setSaveAppointmentsObjectInAvailableAppointments(
			SaveAppointments saveAppointmentsObjectInAvailableAppointments) {
		this.saveAppointmentsObjectInAvailableAppointments = saveAppointmentsObjectInAvailableAppointments;
	}
	public List<Object[]> getDoctorAndTimeList() {
		return doctorAndTimeList;
	}
	public void setDoctorAndTimeList(List<Object[]> doctorAndTimeList) {
		this.doctorAndTimeList = doctorAndTimeList;
	}
	public List<Randevusaatleri> getAppointmentClockResults() {
		return appointmentClockResults;
	}
	public void setAppointmentClockResults(List<Randevusaatleri> appointmentClockResults) {
		this.appointmentClockResults = appointmentClockResults;
	}
	public boolean isRenderingTakingAppointmentInfo() {
		return renderingTakingAppointmentInfo;
	}
	public void setRenderingTakingAppointmentInfo(boolean renderingTakingAppointmentInfo) {
		this.renderingTakingAppointmentInfo = renderingTakingAppointmentInfo;
	}
	public boolean isRenderingClocks() {
		return renderingClocks;
	}
	public void setRenderingClocks(boolean renderingClocks) {
		this.renderingClocks = renderingClocks;
	}
	public boolean isRenderingDataTable() {
		return renderingDataTable;
	}
	public void setRenderingDataTable(boolean renderingDataTable) {
		this.renderingDataTable = renderingDataTable;
	}
	public int getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
	}
	
	
	
	
	
	
	
	
	
	
	
}
