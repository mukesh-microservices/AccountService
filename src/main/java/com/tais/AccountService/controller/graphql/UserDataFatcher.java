package com.tais.AccountService.controller.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tais.AccountService.dao.entity.UserProfile;
import com.tais.AccountService.service.ProfileService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UserDataFatcher implements DataFetcher<UserProfile>{
	
	
	@Autowired
	ProfileService profileService;

	@Override
	public UserProfile get(DataFetchingEnvironment environment) {
		String id = environment.getArgument("id");
		return profileService.getUser(id);
	}

	
	
	

}
