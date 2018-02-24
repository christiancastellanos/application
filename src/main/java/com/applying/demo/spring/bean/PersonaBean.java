package com.applying.demo.spring.bean;

import java.util.List;

public class PersonaBean {

	private long id;
	private String nombres;
	private String apellidos;
	private String telefono;
	private long dni;
	private String direccion;
	private List<Long> listaSolicitudId;

//	private String observacion;

	public PersonaBean() {}
	
	public PersonaBean(int id, String nombres, String apellidos, String telefono, long dni,
			String direccion) {
		this.id=id;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.telefono=telefono;
		this.dni=dni;
		this.direccion=direccion;
	}
	
	/**
	 * @return the observacion
	 
	public String getObservacion() {
		return observacion;
	}
*/
	/**
	 * @param observacion the observacion to set
	 
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
*/	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	////////////////////////////////////////////////////////	
	
	public List<Long> getListaSolicitudId() {
		return listaSolicitudId;
	}

	public void setListaSolicitudId(List<Long> listaSolicitudId) {
		this.listaSolicitudId = listaSolicitudId;
	}

	////////////////////////////////////////////////////////
	
}
