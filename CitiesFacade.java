package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Iller;

public class CitiesFacade extends AbstractFacade<Iller> {

	@PersistenceContext
	private EntityManager em;
	
	public CitiesFacade() {
		super(Iller.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
