package com.webservice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/")
public class TestService {
	
	Gson gson = new Gson();

	
	@Path("/hello/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello(@PathParam("name") String name){
		String returnVar="Hello "+name;
		return gson.toJson(returnVar);
		
	}
	
}
