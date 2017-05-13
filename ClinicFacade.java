package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Klinikler;

public class ClinicFacade extends AbstractFacade<Klinikler> {

	@PersistenceContext
	private EntityManager em;
	
	public ClinicFacade() {
		super(Klinikler.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
