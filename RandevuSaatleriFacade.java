package com.faikturan.hastaneotomasyonu.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.faikturan.hastaneotomasyonu.entity.Randevusaatleri;

public class RandevuSaatleriFacade extends AbstractFacade<Randevusaatleri> {

	@PersistenceContext
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public RandevuSaatleriFacade() {
		super(Randevusaatleri.class);
	}

}
