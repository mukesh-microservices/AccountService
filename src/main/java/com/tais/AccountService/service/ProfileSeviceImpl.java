package com.tais.AccountService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.aspectj.weaver.ltw.LTWWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tais.AccountService.dao.entity.RoleName;
import com.tais.AccountService.dao.entity.UserProfile;
import com.tais.AccountService.dao.entity.UserRole;
import com.tais.AccountService.dao.repository.ProfileRepository;
import com.tais.AccountService.dao.repository.RoleRepository;
import com.tais.AccountService.dto.request.UserProfileReqeust;





@Component
public class ProfileSeviceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	RoleRepository reloRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserProfile getUser(String userId) {
		return profileRepository.findById(userId).get();
	}
	
	public Iterable<UserProfile> getAllUsers() {
		return profileRepository.findAll();
	}

	@Transactional
	public Object saveUser(UserProfileReqeust userProfileReqeust) {
		
		UserRole role = new UserRole();
		role.setName(RoleName.ROLE_USER);
		reloRepository.save(role);
		
		
				
		UserProfile profile = new UserProfile();
		profile.setFirstName(userProfileReqeust.getFirstName());
		profile.setLastName(userProfileReqeust.getLastName());
		profile.setEmail(userProfileReqeust.getEmail());
		profile.setPassword(passwordEncoder.encode(userProfileReqeust.getPassword()));
		
		
		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(role);
				
		profile.setRoles(roles);
				
		//BeanUtils.copyProperties(userDto, userEntity);
				
		return profileRepository.save(profile);

	}



	@Override
	public UserProfile getUserByEmail(String email) {
		return profileRepository.findByEmail(email).get();
	}

}
