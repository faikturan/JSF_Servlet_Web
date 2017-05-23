package com.faikturan.hastaneotomasyonu.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.faikturan.hastaneotomasyonu.controller.SaveAppointments;
import com.faikturan.hastaneotomasyonu.entity.Hastaneler;
import com.faikturan.hastaneotomasyonu.entity.Klinikler;
import com.faikturan.hastaneotomasyonu.entity.Randevusaatleri;
import com.faikturan.hastaneotomasyonu.entity.Uygunrandevular;
import com.faikturan.hastaneotomasyonu.facade.AvailableAppointmentsFacade;

public class AvailableAppointmentsService {

	@PersistenceContext
	private static EntityManager em;
	
	@Autowired
	private AvailableAppointmentsFacade availableAppointmentsFacade;
	
	@Autowired
	private static HospitalsService hospitalsService;
	
	@Autowired
	private static ClinicService clinicService;
	
	public static List<Uygunrandevular> availableAppointments;
	List<Object[]> doctorAndTimeList;
	List<Randevusaatleri> appointmentClockResults;
	
	public static List<Uygunrandevular> getAllAvailableAppointments(String hospitalName, String clinic, String clinicPlace) {
		int hospitalid = 0;
		for (Hastaneler h :hospitalsService.getHospitalResults()) 
		{
			if (h.getHastaneadi().equals(hospitalName)) 
			{
				hospitalid = h.getId();
				break;
			}
		}
		
		int clinicId = 0;
		for (Klinikler k :clinicService.getClinicResults()) 
		{
			if (k.getKlinikadi().equals(clinic)) 
			{
				clinicId = k.getId();
				break;
			}
		}
		
		TypedQuery<Uygunrandevular> query = 
				em.createQuery
				("SELECT u FROM Uygunrandevular AS u WHERE u.hastaneid =: hospitalid AND"
						+ "u.klinikid=: clinicid AND u.klinikyeri =:clinicplace"
						+ "AND u.tarih = "
						+ "(select min (uu.tarih) from Uygunrandevular uu where uu.doktorid = u.doktorid)",
						Uygunrandevular.class);
		query.setParameter("hospitalid", hospitalid);
		query.setParameter("clinicid", clinicId);
		query.setParameter("clinicplace", clinicPlace);
		
		availableAppointments = query.getResultList();
		
		return availableAppointments;
	}

	public Boolean[] changeRenderingStates(SaveAppointments saveAppointments) {
		int doctorid = 0;
		int uygunrandevuid = 0;
		
		if (saveAppointments != null) {
			doctorid = saveAppointments.getSelectedAppointment().getDoktorid();
			uygunrandevuid = saveAppointments.getSelectedAppointment().getUygunrandevuid();
		}
		
		TypedQuery<Object[]> doctorAndTimeQuery = em.createQuery("SELECT u.doktoradi,"
				+ "FUNCTION('DATE',u.tarih), u.uygunrandevuid FROM Uygunrandevular AS u"
				+ "WHERE u.doktorid=: doctorid ORDER BY u.tarih ASC", Object[].class);
		doctorAndTimeQuery.setParameter("doctorid", doctorid);
		doctorAndTimeList = new ArrayList<>();
		doctorAndTimeList = doctorAndTimeQuery.getResultList();
		
		TypedQuery<Randevusaatleri> query = em.createQuery("SELECT c FROM Randevusaatleri c"
				+ "WHERE c.doktorid=:doctorid",Randevusaatleri.class);
		System.out.println("Seçilen Randevunun ID'si" +uygunrandevuid);
		query.setParameter("doctorid", uygunrandevuid);
		appointmentClockResults = new ArrayList<>();
		appointmentClockResults = query.getResultList();
		
		Boolean[] array = new Boolean[2];
		array[0] = false;
		array[1] = true;
		return array;
	}

	public List<Object[]> getDoctorAndTimeList() {
		return doctorAndTimeList;
	}

	public List<Randevusaatleri> getAppointmentClockResults() {
		return appointmentClockResults;
	}

}
