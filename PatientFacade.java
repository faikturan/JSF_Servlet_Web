package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Patients;

public class PatientFacade extends AbstractFacade<Patients> {

	@PersistenceContext
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public PatientFacade() {
		super(Patients.class);
	}

}
