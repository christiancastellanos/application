package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Solicitud;


public interface SolicitudDao {

	public Solicitud findById(Integer id);
	//public SolicitudBean obtenerSolicitud(Integer id);
	
	public void save(Solicitud solicitud);
	//public Integer agregarSolicitud(SolicitudBean objSolicitudBean);
	
	public void deleteById(Integer Id);
	//public void eliminarSolicitud(Integer id);
	
	//Implementación de modificacion en el service
	//public void modificarSolicitud(SolicitudBean objSolicitudBean) ;
	   
	
	public List<Solicitud> findAllSolicitudes();
	//public List<SolicitudBean> obtenerSolicitudes(SolicitudFiltroBean pSolicitudFiltroBean);

}
