package com.demo.microservices.AccountService.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.AccountService.entity.UserProfile;
import com.demo.microservices.AccountService.pojo.request.UserProfileReqeust;
import com.demo.microservices.AccountService.service.ProfileSevice;

@RestController
public class ProfileController {

	@Autowired
	ProfileSevice profileSevice;

	@GetMapping("/userProfile/{userId}")
	public UserProfile getAccountDetails(@PathVariable String userId) {

		UserProfile profile = profileSevice.getUser(userId);

		System.out.println("profileprofileprofileprofile -- " + profile);
		return profile;
	}

	@PostMapping("/userProfile/register")
	public boolean registerUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody UserProfileReqeust userProfileReqeust) {

		try {
			profileSevice.saveUser(userProfileReqeust);
			System.out.println(userProfileReqeust);

		} catch (Throwable t) {
			t.printStackTrace();
		}
		return true;
	}

}
