package com.applying.demo.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.bean.PersonaFiltroBean;
import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.bean.SolicitudFiltroBean;

@Service
public class PersonaServiceImp implements PersonaService {
	static List<PersonaBean> listapersonas = null;
	static List<SolicitudBean> listasolicitudes = null;

	static {
		listapersonas = new ArrayList<PersonaBean>();
		listapersonas.add(new PersonaBean(13200115,"Juan Javier", "Flores Antaño","+51 999341788",70549027,"Mz. A"));
		listapersonas.add(new PersonaBean(13200116,"Ricardo Fabrizzio", "Bagua Grande","+51 963827519",79648912,"Mz. B"));
		listapersonas.add(new PersonaBean(13200117,"Luis Ramiro", "Paredes Ramirez","+51 968129483",67483917,"Mz. C"));
		listapersonas.add(new PersonaBean(13200118,"Antony Jefferson", "Guzman Blanco","+51 967273832",16389265,"Mz. D"));
		listapersonas.add(new PersonaBean(13200124,"Antony Jefferson", "Guzman Blanco","+51 967273832",16389265,"Mz. D"));
		listapersonas.add(new PersonaBean(13200123,"Antony Jefferson", "Guzman Blanco","+51 967273832",16389265,"Mz. D"));
		
		
		
	}
	
	@Override
	public Long agregarPersona(PersonaBean objPersonaBean) {		
		PersonaBean personaMax = Collections.max(listapersonas, Comparator.comparing(c -> c.getId()));
		objPersonaBean.setId(personaMax.getId()+1);
		listapersonas.add(objPersonaBean);
		return objPersonaBean.getId();
	}
	
	@Override
	public void modificarPersona(PersonaBean objPersonaBean) {		
		PersonaBean resPersonaBean = listapersonas.stream()                        // Convert to steam
                .filter(per -> objPersonaBean.getId()==per.getId())        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		resPersonaBean.setNombres(objPersonaBean.getNombres());
		resPersonaBean.setApellidos(objPersonaBean.getApellidos());
		resPersonaBean.setDireccion(objPersonaBean.getDireccion());
		resPersonaBean.setTelefono(objPersonaBean.getTelefono());
		
	}

	@Override
	public List<PersonaBean> obtenerPersonas() {
		return listapersonas;
	}

	@Override
	public PersonaBean obtenerPersona(Long id) {
		PersonaBean resPersonaBean = listapersonas.stream()                        // Convert to steam
                .filter(per -> id == per.getId())       // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		return resPersonaBean;
	}

	@Override
	public void eliminarPersona(Long id) {
		PersonaBean resPersonaBean = listapersonas.stream()                        // Convert to steam
                .filter(per -> id.equals(per.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		if(resPersonaBean!=null) {
			listapersonas.remove(resPersonaBean);
		}
	}

	@Override
	public List<SolicitudBean> obtenerSolicitudes() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
