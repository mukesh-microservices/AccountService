package com.tais.AccountService.service;

import com.tais.AccountService.dao.entity.UserProfile;
import com.tais.AccountService.dto.request.UserProfileReqeust;

public interface ProfileService {
	public UserProfile getUser(String userId) ;
	public Iterable<UserProfile> getAllUsers() ;
	public Object saveUser(UserProfileReqeust userProfileReqeust);
}
