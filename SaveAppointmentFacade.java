package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;

import com.faikturan.hastaneotomasyonu.entity.Takenappointments;

public class SaveAppointmentFacade extends AbstractFacade<Takenappointments> {

	private EntityManager em;
	
	public SaveAppointmentFacade() {
		super(Takenappointments.class);	
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	
}
