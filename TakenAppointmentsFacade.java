package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Takenappointments;

public class TakenAppointmentsFacade extends AbstractFacade<Takenappointments> {

	@PersistenceContext
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public TakenAppointmentsFacade() {
		super(Takenappointments.class);
	}

}
