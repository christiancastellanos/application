package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.UserProfile;


public interface UserProfileDao {

	public List<UserProfile> findAll();
	
	public UserProfile findByType(String type);
	
	public UserProfile findById(int id);
}
