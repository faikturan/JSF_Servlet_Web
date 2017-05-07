package com.faikturan.hastaneotomasyonu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="takenappointments")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Takenappointments.findAll", query = "SELECT t FROM Takenappointments t"),
	@NamedQuery(name= "Takenappointments.findByPatientIdAndIsAppointmentCancelled", 
	query = "SELECT t FROM  Takenappointments t WHERE t.patientid =:patientid AND t.wasappointmentcancelled =:wasappointmentcancelled")})
public class Takenappointments implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="takedappointmentid")
	private int takedappointmentid;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name="clinicname")
	private String clinicname;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name="clinicplace")
	private String clinicplace;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="clockid")
	private int clockid;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	
	@Column(name="datepassed")
	private boolean datepassed;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="doktorid")
	private int doktorid;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name="hospitalname")
	private String hospitalname;
	
	@Column(name="hour")
	private String hour;
	
	@Column(name="patientid")
	private String patientid;
	
	
	private boolean wasappointmentcancelled;
	
	
	public Takenappointments() {	
	}

	public int getTakedappointmentid() {
		return takedappointmentid;
	}

	public void setTakedappointmentid(int takedappointmentid) {
		this.takedappointmentid = takedappointmentid;
	}

	public String getClinicname() {
		return clinicname;
	}

	public void setClinicname(String clinicname) {
		this.clinicname = clinicname;
	}



	public String getClinicplace() {
		return clinicplace;
	}



	public void setClinicplace(String clinicplace) {
		this.clinicplace = clinicplace;
	}



	public int getClockid() {
		return clockid;
	}



	public void setClockid(int clockid) {
		this.clockid = clockid;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public boolean isDatepassed() {
		return datepassed;
	}



	public void setDatepassed(boolean datepassed) {
		this.datepassed = datepassed;
	}



	public int getDoktorid() {
		return doktorid;
	}



	public void setDoktorid(int doktorid) {
		this.doktorid = doktorid;
	}



	public String getHospitalname() {
		return hospitalname;
	}



	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}



	public String getHour() {
		return hour;
	}



	public void setHour(String hour) {
		this.hour = hour;
	}



	public String getPatientid() {
		return patientid;
	}



	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public boolean isWasappointmentcancelled() {
		return wasappointmentcancelled;
	}

	public void setWasappointmentcancelled(boolean wasappointmentcancelled) {
		this.wasappointmentcancelled = wasappointmentcancelled;
	}



	
	
}