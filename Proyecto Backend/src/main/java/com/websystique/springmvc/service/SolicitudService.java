package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Solicitud;


public interface SolicitudService {
	
	public Solicitud findById(Integer id);
	//public SolicitudBean obtenerSolicitud(Integer id);
	
	public void saveSolicitud(Solicitud solicitud);
	//public Integer agregarSolicitud(SolicitudBean objSolicitudBean);
	
	public void updateSolicitud(Solicitud solicitud);
	//public void modificarSolicitud(SolicitudBean objSolicitudBean) ;
	
	public void deleteSolicitudById(Integer Id);
	//public void eliminarSolicitud(Integer id);
	
	public List<Solicitud> findAllSolicitudes();
	//public List<SolicitudBean> obtenerSolicitudes(SolicitudFiltroBean pSolicitudFiltroBean);

}