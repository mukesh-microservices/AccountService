package com.tais.AccountService.controller.graphql;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GqlProfilesService {

	@Value("classpath:user.graphql")
	Resource gqlUserSchema;

	@Autowired
	AllUsersDataFatcher allUsersDataFatcher;
	
	@Autowired
	UserDataFatcher userDataFatcher;
	
	
	private GraphQL graphQL;

	@PostConstruct
	private void loadUserGQLSchema() throws IOException {
		
		System.out.println("===================================");
		// get the schema
		File userGQLSchemaFile  = gqlUserSchema.getFile();
		System.out.println("userGQLSchemaFile------------------" + userGQLSchemaFile);
		
		//parse the schema
		TypeDefinitionRegistry definitionRegistry = new SchemaParser().parse(userGQLSchemaFile);
		
		System.out.println("definitionRegistry------------------" + definitionRegistry); 
		
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		
		System.out.println("runtimeWiring------------------" + runtimeWiring); 
		
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(definitionRegistry, runtimeWiring);
		
		System.out.println("schema------------------" + schema); 
		
		graphQL = GraphQL.newGraphQL(schema).build();
		
		System.out.println("graphQL------------------" + graphQL); 
		
		System.out.println("===================================");
	}

	
	
	
	private RuntimeWiring buildRuntimeWiring() {

		return RuntimeWiring.newRuntimeWiring()
				.type("Query", 
						typeWiring -> typeWiring.dataFetcher("allUsers", allUsersDataFatcher).dataFetcher("user", userDataFatcher).dataFetcher("userByEmail", userDataFatcher)

				).build();
	}
	
	
	
	public GraphQL getGraphQL() {
		return graphQL;
	}

}


