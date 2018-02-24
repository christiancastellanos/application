package com.applying.demo.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.service.PersonaService;
import com.applying.demo.spring.service.SolicitudService;

@Controller
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/vistaPersonas")
	public String userForm(Locale locale, Model model) {
		model.addAttribute("personas", personaService.obtenerPersonas());
		return "vistaPersonas";
	}
	
	@GetMapping("/vistaPersona")
	public String vistaPersonaID(@RequestParam(value="id" ,required=false) Long personaId,Model model,Locale locale) {
		PersonaBean objPersonaBean = new PersonaBean();
		if(personaId!=null) {
			objPersonaBean = personaService.obtenerPersona(personaId);
		}
		model.addAttribute("persona", objPersonaBean);
		return "vistaPersona";
	}
	
	@GetMapping("/eliminarPersona/{id}")
	public String eliminarPersona(@PathVariable("id") Long personaId,Model model,Locale locale) {
		personaService.eliminarPersona(personaId);
		return "redirect:/vistaPersonas";
	}


	@PostMapping("/agregarPersona")
	public String agregarPersona(@ModelAttribute("persona") PersonaBean objPersonaBean, Model model) {
		personaService.agregarPersona(objPersonaBean);
		return "redirect:/vistaPersonas";
	}
	
	@PostMapping("/modificarPersona")
	public String modificarPersona(@ModelAttribute("solicitud") PersonaBean objPersonaBean, Model model) {
		personaService.modificarPersona(objPersonaBean);
		return "redirect:/vistaPersonas";
	}
	

}
