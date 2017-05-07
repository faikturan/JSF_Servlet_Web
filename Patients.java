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
@Table(name="patients")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Patients.findAll", query = "SELECT p FROM Patients p"),
	@NamedQuery(name= "Patients.findByIdentitynumber", 
	query = "SELECT p FROM  Patients p WHERE p.identitynumber = :identitynumber"),
	@NamedQuery(name= "Patients.findByBirthdate", 
	query = "SELECT p FROM  Patients p WHERE p.birthdate = :birthdate"),
	@NamedQuery(name= "Patients.findByEmailaddress", 
	query = "SELECT p FROM  Patients p WHERE p.emailaddress = :emailaddress"),
	@NamedQuery(name= "Patients.findByEnabled", 
	query = "SELECT p FROM  Patients p WHERE p.enabled = :enabled"),
	@NamedQuery(name= "Patients.findByFathername", 
	query = "SELECT p FROM  Patients p WHERE p.fathername = :fathername"),
	@NamedQuery(name= "Patients.findByGender", 
	query = "SELECT p FROM  Patients p WHERE p.gender = :gender"),
	@NamedQuery(name= "Patients.findByMothername", 
	query = "SELECT p FROM  Patients p WHERE p.mothername = :mothername"),
	@NamedQuery(name= "Patients.findByName", 
	query = "SELECT p FROM  Patients p WHERE p.name = :name"),
	@NamedQuery(name= "Patients.findByPassword", 
	query = "SELECT p FROM  Patients p WHERE p.password = :password"),
	@NamedQuery(name= "Patients.findByPhonenumber", 
	query = "SELECT p FROM  Patients p WHERE p.phonenumber = :phonenumber"),
	@NamedQuery(name= "Patients.findByRole", 
	query = "SELECT p FROM  Patients p WHERE p.role = :role"),
	@NamedQuery(name= "Patients.findBySurname", 
	query = "SELECT p FROM  Patients p WHERE p.surname = :surname")})
public class Patients implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional=false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name="identitynumber")
	private String identitynumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "birthdate")
	private Date birthdate;
	
	@Size(max=255)
	@Column(name="emailaddress")
	private String emailaddress;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@Size(max=255)
	@Column(name="fathername")
	private String fathername;
	
	@Size(max=255)
	@Column(name="gender")
	private String gender;
	
	@Size(max=255)
	@Column(name="mothername")
	private String mothername;
	
	@Size(max=255)
	@Column(name="name")
	private String name;
	
	@Size(max=255)
	@Column(name="password")
	private String password;
	
	@Size(max=255)
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Size(max=255)
	@Column(name="role")
	private String role;
	
	@Size(max=255)
	@Column(name="surname")
	private String surname;
	
	public Patients() {	
	}

	public Patients(String identitynumber) {
		this.identitynumber = identitynumber;
		
	}
	public String getIdentitynumber() {
		return identitynumber;
	}

	public void setIdentitynumber(String identitynumber) {
		this.identitynumber = identitynumber;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((identitynumber != null) ? identitynumber.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Patients)){
			return false;
		}
		Patients other = (Patients) object;
		return !((this.identitynumber == null && other.identitynumber != null) 
				|| (this.identitynumber != null && !this.identitynumber.equals(other.identitynumber)));
	}

	@Override
	public String toString() {
		return "Patients [identitynumber=" + identitynumber + "]";
	}
}