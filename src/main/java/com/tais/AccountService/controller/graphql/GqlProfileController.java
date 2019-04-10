package com.tais.AccountService.controller.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/gql/userProfile")
public class GqlProfileController {

	@Autowired
	GqlProfilesService gqlProfilesService;

	@PostMapping
	public ResponseEntity<Object> getAccountDetails(@RequestBody String query) {

		System.out.println(query);
		System.out.println(gqlProfilesService);
		System.out.println(gqlProfilesService.getGraphQL());
		
		ExecutionResult  executionResult =  gqlProfilesService.getGraphQL().execute(query);

		System.out.println("profileprofileprofileprofile -- " + executionResult);
		return new ResponseEntity<>(executionResult,HttpStatus.OK);
		
	}

}
