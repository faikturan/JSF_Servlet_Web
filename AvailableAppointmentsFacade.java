package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Uygunrandevular;

public class AvailableAppointmentsFacade extends AbstractFacade<Uygunrandevular> {

	@PersistenceContext
	private EntityManager em;
	
	public AvailableAppointmentsFacade() {
		super(Uygunrandevular.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
