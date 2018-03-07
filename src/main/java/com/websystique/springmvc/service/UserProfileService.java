package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.UserProfile;


public interface UserProfileService {

	public UserProfile findById(int id);

	public UserProfile findByType(String type);
	
	public List<UserProfile> findAll();
	
}
