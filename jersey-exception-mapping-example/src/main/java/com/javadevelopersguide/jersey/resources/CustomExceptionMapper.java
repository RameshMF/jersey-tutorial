package com.javadevelopersguide.jersey.resources;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {

	@Override
	public Response toResponse(ResourceNotFoundException exception) {
		return Response
		          .status(Status.NOT_FOUND)
		          .entity(new ApiResponse(ApiResponse.ERROR, exception
		              .getMessage())).build();
	}

}
