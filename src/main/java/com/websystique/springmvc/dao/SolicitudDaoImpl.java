package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Solicitud;



@Repository("solicitudDao")
public class SolicitudDaoImpl extends AbstractDao<Integer, Solicitud> implements SolicitudDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public Solicitud findById(Integer id) {
		Solicitud solicitud = getByKey(id);
		if(solicitud!=null){
			Hibernate.initialize(solicitud.getUser());
		}
		return solicitud;
	}

	public void save(Solicitud solicitud) {
		persist(solicitud);
	}
	
	public void deleteById(Integer id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Solicitud solicitud = (Solicitud)crit.uniqueResult();
		delete(solicitud);
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitud> findAllSolicitudes() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Solicitud> solicitudes = (List<Solicitud>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return solicitudes;
	}

	
}
