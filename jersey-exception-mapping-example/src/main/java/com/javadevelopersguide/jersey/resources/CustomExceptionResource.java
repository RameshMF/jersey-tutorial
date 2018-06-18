package com.javadevelopersguide.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javadevelopersguide.jersey.resources.exception.BadRequestException;

@Path("customexception/")
public class CustomExceptionResource {

	@GET
	@Path("notfound")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String notfound() throws ResourceNotFoundException {
		throw new ResourceNotFoundException("Resource not found exception.");
	}

	@GET
	@Path("badrequest")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String badrequest() throws BadRequestException {
		throw new BadRequestException(400, "Bad Request Exception.");
	}

}
