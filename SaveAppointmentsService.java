package com.faikturan.hastaneotomasyonu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.faikturan.hastaneotomasyonu.controller.GetAvailableAppointments;
import com.faikturan.hastaneotomasyonu.entity.Randevusaatleri;
import com.faikturan.hastaneotomasyonu.entity.Takenappointments;
import com.faikturan.hastaneotomasyonu.entity.Uygunrandevular;
import com.faikturan.hastaneotomasyonu.facade.AvailableAppointmentsFacade;
import com.faikturan.hastaneotomasyonu.facade.RandevuSaatleriFacade;
import com.faikturan.hastaneotomasyonu.facade.TakenAppointmentsFacade;

public class SaveAppointmentsService {

	@Autowired
	private SavePatientsService savePatientsService;
	
	@Autowired
	RandevuSaatleriFacade randevuSaatleriFacade;
	
	@Autowired
	AvailableAppointmentsFacade availableAppointmentsFacade;
	
	@Autowired
	TakenAppointmentsFacade takenAppointmentsFacade;
	
	
	
	public String saveAppointmentToDb(Takenappointments takenappointments) throws Exception {
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext
				(FacesContext.getCurrentInstance());
		List<Randevusaatleri> appointmentClockResults = new ArrayList<>();
		String hour = "";
		int randevuid=0;
		
		appointmentClockResults = 
				randevuSaatleriFacade.findListByNamedQuery("Randevusaatleri.findAll");
		for (Randevusaatleri r : appointmentClockResults) {
			if (r.getSaatid()== takenappointments.getClockid()) {
				System.out.println("Saatin ID'si:" +takenappointments.getClockid());
				hour = r.getSaat();
				randevuid = r.getRandevuid();
				break;
			}
		}
		
		takenappointments.setHour(hour);
		List<Uygunrandevular> appointmentIdResults = new ArrayList<>();
		Map parameters = new HashMap();
		parameters.put("uygunrandevuid", randevuid);
		appointmentIdResults = 
				availableAppointmentsFacade.
				findListByNamedQuery("Uygunrandevular.findByUygunrandevuid",parameters);
		
		for (Uygunrandevular u : appointmentIdResults) {
			takenappointments.setDate(u.getTarih());
		}
		
		Randevusaatleri r = randevuSaatleriFacade.find(takenappointments.getClockid());
		r.setSaatalindimi(true);
		r.setTitle("DOLU");
		randevuSaatleriFacade.updateMemberInfo(r);
		
		String operationResult = takenAppointmentsFacade.create(takenappointments);
		
		GetAvailableAppointments  getAvailableAppointments = new GetAvailableAppointments();
		getAvailableAppointments.changeRenderingStates();
		
		return operationResult;
	}

}
