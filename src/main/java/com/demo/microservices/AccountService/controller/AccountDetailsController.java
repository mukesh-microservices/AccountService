package com.demo.microservices.AccountService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.microservices.AccountService.serviceProxy.LoyalyServiceProxyFeign;

@RestController
public class AccountDetailsController {

	static Logger logger = LoggerFactory.getLogger(AccountDetailsController.class) ;

	@Autowired
	private LoyalyServiceProxyFeign loyalyServiceProxyFeign;

	@Autowired
	RestTemplate restTemplate;

	private String loyaltyURL = "http://192.168.0.7:8083/points/";

	@GetMapping("/accountDetails/{userId}")
	public String getAccountDetails(@PathVariable String userId) {

		logger.info("Before calling Loyalty Service.");

		ResponseEntity<String> response = restTemplate.getForEntity(loyaltyURL + userId, String.class);
		logger.info("After calling Loyalty Service.");

		return "REST - This is account details wilt loyalyu points - " + response.getBody();
	}

	@GetMapping("/accountDetails-feign/{userId}")
	public String getAccountDetailsFeign(@PathVariable String userId) {

		String points = loyalyServiceProxyFeign.getPoints(userId);
		return "This is account details wilt loyalyu points - " + points;
	}

}
