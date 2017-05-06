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
@Table(name="ilceler")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Ilceler.findAll", query = "SELECT i FROM Ilceler i"),
	@NamedQuery(name= "Ilceler.findById", 
	query = "SELECT i FROM Ilceler i WHERE i.id = :id"),
	@NamedQuery(name= "Ilceler.findByIlce", 
	query = "SELECT i FROM Ilceler i WHERE i.ilce = :ilce"),
	@NamedQuery(name= "Ilceler.findBySehir", 
	query = "SELECT i FROM Ilceler i WHERE i.sehir = :sehir")})
public class Ilceler implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id")
	private Integer id;
	
	@Basic(optional=false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name="ilce")
	private String ilce;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="sehir")
	private Integer sehir;
	
	public Ilceler() {	
	}

	public Ilceler(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIlce() {
		return ilce;
	}

	public void setIlce(String ilce) {
		this.ilce = ilce;
	}

	public Integer getSehir() {
		return sehir;
	}

	public void setSehir(Integer sehir) {
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
		if(!(object instanceof Ilceler)){
			return false;
		}
		Ilceler other = (Ilceler) object;
		return !((this.id == null && other.id != null) 
				|| (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "Ilceler [id=" + id + "]";
	}

	
}