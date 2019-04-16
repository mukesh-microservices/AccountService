package com.tais.AccountService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tais.AccountService.dao.entity.UserProfile;
import com.tais.AccountService.dao.repository.ProfileRepository;
import com.tais.AccountService.dto.request.UserProfileReqeust;





@Component
public class ProfileSeviceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserProfile getUser(String userId) {
		return profileRepository.findById(userId).get();
	}
	
	public Iterable<UserProfile> getAllUsers() {
		return profileRepository.findAll();
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



	@Override
	public UserProfile getUserByEmail(String email) {
		return profileRepository.findByEmail(email).get();
	}

}
