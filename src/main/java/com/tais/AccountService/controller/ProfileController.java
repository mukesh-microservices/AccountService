package com.tais.AccountService.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tais.AccountService.dao.entity.UserProfile;
import com.tais.AccountService.dto.request.UserProfileReqeust;
import com.tais.AccountService.service.ProfileService;


@RestController
public class ProfileController {


	@Autowired
	ProfileService profileService;

	@GetMapping("/userProfile/{userId}")
	public UserProfile getAccountDetails(@PathVariable String userId) {

		UserProfile profile = profileService.getUser(userId);

		System.out.println("profileprofileprofileprofile -- " + profile);
		return profile;
	}
	
	@GetMapping("/userProfile/allUsers")
	public Iterable<UserProfile> getAllAccountDetails() {

		Iterable<UserProfile> profiles = profileService.getAllUsers();

		System.out.println("profileprofileprofileprofile -- " + profiles);
		return profiles;
	}
	

	@PostMapping("/userProfile/register")
	public boolean registerUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody UserProfileReqeust userProfileReqeust) {

		try {
			profileService.saveUser(userProfileReqeust);
			System.out.println(userProfileReqeust);

		} catch (Throwable t) {
			t.printStackTrace();
		}
		return true;
	}

}
