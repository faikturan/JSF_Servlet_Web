package com.faikturan.hastaneotomasyonu.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="iller")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Iller.findAll", query = "SELECT i FROM Iller i"),
	@NamedQuery(name= "Iller.findById", 
	query = "SELECT i FROM Iller i WHERE i.id = :id"),
	@NamedQuery(name= "Iller.findBySehir", 
	query = "SELECT i FROM Ilceler i WHERE i.sehir = :sehir")})
public class Iller implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id")
	private Integer id;
	
	@Size(max = 50)
	@Column(name="sehir")
	private String sehir;
	
	public Iller() {	
	}

	public Iller(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((id != null) ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Iller)){
			return false;
		}
		Iller other = (Iller) object;
		return !((this.id == null && other.id != null) 
				|| (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "Iller [id=" + id + "]";
	}

	

	
}