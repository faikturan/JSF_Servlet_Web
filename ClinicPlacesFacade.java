package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Klinikyerleri;

public class ClinicPlacesFacade extends AbstractFacade<Klinikyerleri> {

	@PersistenceContext
	private EntityManager em;
	
	public ClinicPlacesFacade() {
		super(Klinikyerleri.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
