package com.javadevelopersguide.jersey.resources;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

@Path("/")
public class HelloWorldResource {

	@GET
	@Path("helloworld")
	public String helloworld(){
		return "Helloworld !!!!";
	}
}
