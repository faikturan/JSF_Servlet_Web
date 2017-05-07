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
@Table(name="klinikyerleri")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Klinikyerleri.findAll", query = "SELECT k FROM Klinikyerleri k"),
	@NamedQuery(name= "Klinikyerleri.findById", 
	query = "SELECT k FROM  Klinikyerleri k WHERE k.id = :id"),
	@NamedQuery(name= "Klinikyerleri.findByKlinikyeri", 
	query = "SELECT k FROM Klinikyerleri k WHERE k.klinikyeri = :klinikyeri"),
	@NamedQuery(name= "Klinikyerleri.findByHastaneid", 
	query = "SELECT k FROM  Klinikyerleri k WHERE k.hastaneid = :hastaneid")})
public class Klinikyerleri implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id")
	private Integer id;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name="klinikyeri")
	private String klinikyeri;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="hastaneid")
	private int hastaneid;
	
	public Klinikyerleri() {	
	}

	public Klinikyerleri(Integer id) {
		this.id = id;
	}

	public Klinikyerleri(Integer id, String klinikyeri, int hastaneid) {
		this.id = id;
		this.klinikyeri = klinikyeri;
		this.hastaneid = hastaneid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKlinikyeri() {
		return klinikyeri;
	}

	public void setKlinikyeri(String klinikyeri) {
		this.klinikyeri = klinikyeri;
	}

	public int getHastaneid() {
		return hastaneid;
	}

	public void setHastaneid(int hastaneid) {
		this.hastaneid = hastaneid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((id != null) ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Klinikyerleri)){
			return false;
		}
		Klinikyerleri other = (Klinikyerleri) object;
		return !((this.id == null && other.id != null) 
				|| (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "Klinikyerleri [id=" + id + "]";
	}
	
}