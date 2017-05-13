package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Hastaneler;

public class HospitalFacade extends AbstractFacade<Hastaneler> {

	@PersistenceContext
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public HospitalFacade() {
		super(Hastaneler.class);
	}

}
