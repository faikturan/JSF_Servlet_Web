package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Doktorlar;

public class DoktorFacade extends AbstractFacade<Doktorlar> {

	@PersistenceContext
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public DoktorFacade() {
		super(Doktorlar.class);
	}

}
