package com.tais.AccountService.serviceProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="loyaltyServiceFeign",url="localhost:8083")
public interface LoyalyServiceProxyFeign {

	@GetMapping("/points/{X}")
	public String getPoints(@PathVariable("X") String userId) ;
	
}
