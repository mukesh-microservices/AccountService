package com.tais.AccountService.controller.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tais.AccountService.dao.entity.UserProfile;
import com.tais.AccountService.service.ProfileService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UserDataFatcher implements DataFetcher<UserProfile> {

	@Autowired
	ProfileService profileService;

	@Override
	public UserProfile get(DataFetchingEnvironment environment) {

		UserProfile userProfile = null;
		
		System.out.println("Datafetcher Argument..... " + environment.getArguments());
		
		if (environment.containsArgument("id")) {
			String id = environment.getArgument("id");
			userProfile = profileService.getUser(id);
		} else if (environment.containsArgument("email")) {
			
			String email = environment.getArgument("email");
			userProfile = profileService.getUserByEmail(email);

		}
		return userProfile;

	}

}
