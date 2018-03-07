package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.Solicitud;

public interface UserDao {

	public User findById(int id);
	
	public User findBySSO(String sso);
	
	public void save(User user);
	
	public void deleteBySSO(String sso);
	
	public List<User> findAllUsers();
	
	public List<Solicitud> findAllSolicitudesOfThisuser(User user);

}

