package com.faikturan.hastaneotomasyonu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.faikturan.hastaneotomasyonu.entity.Klinikyerleri;
import com.faikturan.hastaneotomasyonu.facade.ClinicPlacesFacade;


public class ClinicPlacesService {
	@Autowired
	private ClinicPlacesFacade clinicPlacesFacade;
	
	List<String> clinicPlaceNames;
	List<Klinikyerleri> clinicPlaces;

	public List<String> getAllClinicNames(int hospitalId) throws Exception {
		clinicPlaceNames = new ArrayList<>();
		Map map = new HashMap();
		map.put("hastaneid", hospitalId);
		clinicPlaces =
				clinicPlacesFacade.
				findListByNamedQuery("Klinikyerleri.findByHastaneid", map);
		for (Klinikyerleri c : clinicPlaces) {
			clinicPlaceNames.add(c.getKlinikyeri());
		}
		return clinicPlaceNames;
	}

}
