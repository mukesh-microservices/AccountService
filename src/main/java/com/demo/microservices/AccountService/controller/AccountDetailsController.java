package com.demo.microservices.AccountService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.microservices.AccountService.serviceProxy.LoyalyServiceProxyFeign; 

@RestController
public class AccountDetailsController {
	
	@Autowired
	private LoyalyServiceProxyFeign loyalyServiceProxyFeign  ;
	
	RestTemplate restTemplate = new RestTemplate();
	
	private String loyaltyURL = "http://192.168.0.7:8083/points/";

	@GetMapping("/accountDetails/{userId}")
	public String getAccountDetails(@PathVariable String userId) {

		ResponseEntity<String> response = restTemplate.getForEntity(loyaltyURL + userId, String.class);

		return "This is account details wilt loyalyu points - " + response.getBody();
	}
	
	@GetMapping("/accountDetails-feign/{userId}")
	public String getAccountDetailsFeign(@PathVariable String userId) {
		
		String points = loyalyServiceProxyFeign.getPoints(userId);
		return "This is account details wilt loyalyu points - " + points;
	}
	
}
