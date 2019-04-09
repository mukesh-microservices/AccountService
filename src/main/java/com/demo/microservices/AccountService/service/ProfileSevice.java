package com.demo.microservices.AccountService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.demo.microservices.AccountService.entity.UserProfile;
import com.demo.microservices.AccountService.pojo.request.UserProfileReqeust;
import com.demo.microservices.AccountService.repository.ProfileRepository;

@Component
public class ProfileSevice {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserProfile getUser(String userId) {
		return profileRepository.findById(userId).get();
	}

	public Object saveUser(UserProfileReqeust userProfileReqeust) {
		UserProfile profile = new UserProfile();

		profile.setFirstName(userProfileReqeust.getFirstName());
		profile.setLastName(userProfileReqeust.getLastName());
		profile.setEmail(userProfileReqeust.getEmail());
		profile.setPassword(passwordEncoder.encode(userProfileReqeust.getPassword()));
		
		
		//BeanUtils.copyProperties(userDto, userEntity);
		
		
		return profileRepository.save(profile);

	}

}
