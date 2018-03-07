package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.SolicitudDao;
import com.websystique.springmvc.model.Solicitud;


@Service("solicitudService")
@Transactional
public class SolicitudServiceImpl implements SolicitudService{

	@Autowired
	private SolicitudDao dao;

	public Solicitud findById(Integer id) {
		return dao.findById(id);
	}

	public void saveSolicitud(Solicitud solicitud) {
		dao.save(solicitud);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateSolicitud(Solicitud solicitud) {
		Solicitud entity = dao.findById(solicitud.getId());
		if(entity!=null){
			entity.setInstitucionNombre(solicitud.getInstitucionNombre());
			entity.setEstadoDes(solicitud.getEstadoDes());
		}
	}

	public void deleteSolicitudById(Integer id) {
		dao.deleteById(id);
	}

	public List<Solicitud> findAllSolicitudes() {
		return dao.findAllSolicitudes();
	}

}

