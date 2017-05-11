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
@Table(name="uygunrandevular")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Uygunrandevular.findAll", query = "SELECT u FROM Uygunrandevular u"),
	@NamedQuery(name= "Uygunrandevular.findByUygunrandevuid", 
	query = "SELECT u FROM  Uygunrandevular u WHERE u.uygunrandevuid = :uygunandevuid"),
	@NamedQuery(name= "Uygunrandevular.findByDoktorid", 
	query = "SELECT u FROM  Uygunrandevular u WHERE u.doktorid = :doktorid"),
	@NamedQuery(name= "Uygunrandevular.findByTarih", 
	query = "SELECT u FROM  Uygunrandevular u WHERE u.tarih = :tarih"),
	@NamedQuery(name= "Uygunrandevular.findByHastaneid", 
	query = "SELECT u FROM  Uygunrandevular u WHERE u.hastaneid = :hastaneid"),
	@NamedQuery(name= "Uygunrandevular.findByKlinikid", 
	query = "SELECT u FROM  Uygunrandevular u WHERE u.klinikid = :klinikid"),
	@NamedQuery(name= "Uygunrandevular.findByKlinikyeri", 
	query = "SELECT u FROM  Uygunrandevular u WHERE u.klinikyeri = :klinikyeri")})
public class Uygunrandevular implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="uygunrandevuid")
	private Integer uygunrandevuid;
	
	@Size(max = 50)
	@Column(name="doktoradi")
	private String doktoradi;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="doktorid")
	private Integer doktorid;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="hastaneid")
	private Integer hastaneid;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="klinikid")
	private Integer klinikid;
	
	@Size(max = 50)
	@Column(name="klinikyeri")
	private String klinikyeri;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="randevualindimi")
	private boolean randevualindimi;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="tarih")
	@Temporal(TemporalType.DATE)
	private Date tarih;

	public Uygunrandevular() {	
	}
	
	public Uygunrandevular(Integer uygunrandevuid) {
		this.uygunrandevuid = uygunrandevuid;
	}

	public Uygunrandevular(Integer uygunrandevuid, String doktoradi, Integer doktorid, Integer hastaneid,
			Integer klinikid, String klinikyeri, boolean randevualindimi, Date tarih) {
		this.uygunrandevuid = uygunrandevuid;
		this.doktoradi = doktoradi;
		this.doktorid = doktorid;
		this.hastaneid = hastaneid;
		this.klinikid = klinikid;
		this.klinikyeri = klinikyeri;
		this.randevualindimi = randevualindimi;
		this.tarih = tarih;
	}

	public Integer getUygunrandevuid() {
		return uygunrandevuid;
	}

	public void setUygunrandevuid(Integer uygunrandevuid) {
		this.uygunrandevuid = uygunrandevuid;
	}

	public String getDoktoradi() {
		return doktoradi;
	}

	public void setDoktoradi(String doktoradi) {
		this.doktoradi = doktoradi;
	}

	public Integer getDoktorid() {
		return doktorid;
	}

	public void setDoktorid(Integer doktorid) {
		this.doktorid = doktorid;
	}

	public Integer getHastaneid() {
		return hastaneid;
	}

	public void setHastaneid(Integer hastaneid) {
		this.hastaneid = hastaneid;
	}

	public Integer getKlinikid() {
		return klinikid;
	}

	public void setKlinikid(Integer klinikid) {
		this.klinikid = klinikid;
	}

	public String getKlinikyeri() {
		return klinikyeri;
	}

	public void setKlinikyeri(String klinikyeri) {
		this.klinikyeri = klinikyeri;
	}

	public boolean isRandevualindimi() {
		return randevualindimi;
	}

	public void setRandevualindimi(boolean randevualindimi) {
		this.randevualindimi = randevualindimi;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((uygunrandevuid != null) ? uygunrandevuid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Uygunrandevular)){
			return false;
		}
		Uygunrandevular other = (Uygunrandevular) object;
		return !((this.uygunrandevuid == null && other.uygunrandevuid != null) 
				|| (this.uygunrandevuid != null && !this.uygunrandevuid.equals(other.uygunrandevuid)));
	}

	@Override
	public String toString() {
		return "Uygunrandevular [uygunrandevuid=" + uygunrandevuid + "]";
	}
}