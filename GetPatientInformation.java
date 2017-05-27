package com.faikturan.hastaneotomasyonu.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.entity.Patients;
import com.faikturan.hastaneotomasyonu.entity.Takenappointments;
import com.faikturan.hastaneotomasyonu.service.PatientsService;


@ManagedBean(name="getPatientInformation")
@ViewScoped
public class GetPatientInformation implements Serializable {

	private String identityNumber;
	private String name;
	private String surname;
	private String birthplace;
	private Date birthDate;
	private String fatherName;
	private String motherName;
	private String mobilePhoneNumber;
	private String homePhoneNumber;
	private String emailAddress;
	private String password;
	private String messageForUpdate;
	
	private Patients p;
	
	@ManagedProperty(value="#{saveAppointments}")
	private SaveAppointments saveAppointments;

	List<Takenappointments> takenappointmentsOfPatient;
	
	
	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessageForUpdate() {
		return messageForUpdate;
	}

	public void setMessageForUpdate(String messageForUpdate) {
		this.messageForUpdate = messageForUpdate;
	}

	public Patients getP() {
		return p;
	}

	public void setP(Patients p) {
		this.p = p;
	}

	public List<Takenappointments> getTakenappointmentsOfPatient() {
		return takenappointmentsOfPatient;
	}

	public void setTakenappointmentsOfPatient(List<Takenappointments> takenappointmentsOfPatient) {
		this.takenappointmentsOfPatient = takenappointmentsOfPatient;
	}

	public SaveAppointments getSaveAppointments() {
		return saveAppointments;
	}

	public void setSaveAppointments(SaveAppointments saveAppointments) {
		this.saveAppointments = saveAppointments;
	}

	public void fillList() throws Exception
	{
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		PatientsService  patientsService = 
				   (PatientsService) context.getBean("patientService");
		p = patientsService.getPatientInfo(saveAppointments.comingIdentityNumber);
		
	}
	
	public void updatePatientInfo() 
	{
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		PatientsService  patientsService = 
				   (PatientsService) context.getBean("patientService");
		
		messageForUpdate = patientsService.updatePatientInfo(p);
		
	}
}
