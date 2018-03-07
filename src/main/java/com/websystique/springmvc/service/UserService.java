package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Solicitud;
import com.websystique.springmvc.model.User;


public interface UserService {
	
	public User findById(int id);
	
	public User findBySSO(String sso);
	
	void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserBySSO(String sso);

	public List<User> findAllUsers(); 
	
	public List<Solicitud> findAllSolicitudesOfThisuser(User user);
	
	boolean isUserSSOUnique(Integer id, String sso);

}