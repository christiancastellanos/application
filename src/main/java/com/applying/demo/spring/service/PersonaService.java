package com.applying.demo.spring.service;

import java.util.List;

import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.bean.PersonaFiltroBean;
import com.applying.demo.spring.bean.SolicitudBean;

public interface PersonaService {
	
   public Long agregarPersona(PersonaBean objPersonaBean);
   
   public PersonaBean obtenerPersona(Long id);
   
   public void modificarPersona(PersonaBean objPersonaBean) ;
   
   public void eliminarPersona(Long id);

   public List<PersonaBean> obtenerPersonas();
   
   public List<SolicitudBean> obtenerSolicitudes();
   
}
