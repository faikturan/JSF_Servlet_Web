package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Ilceler;

public class DistrictsFacade extends AbstractFacade<Ilceler> {

	@PersistenceContext
	private EntityManager em;
	
	public DistrictsFacade() {
		super(Ilceler.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
