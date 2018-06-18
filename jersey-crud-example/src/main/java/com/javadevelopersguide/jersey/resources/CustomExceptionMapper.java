package com.javadevelopersguide.jersey.resources;

import java.util.HashMap;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.javadevelopersguide.jersey.exception.BadRequestException;
import com.javadevelopersguide.jersey.exception.ResourceNotFoundException;
import com.javadevelopersguide.jersey.model.APIResponse;

@Provider
public class CustomExceptionMapper  {

	// -- Exception Mappers
    @Provider
    public static class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {

    	@Override
    	public Response toResponse(ResourceNotFoundException exception) {
    		return Response
    		          .status(Status.NOT_FOUND)
    		          .entity(new HashMap<>().put(Status.INTERNAL_SERVER_ERROR, exception.getMessage())).build();
    	}
    }

    @Provider
    public static class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

        @Override
        public Response toResponse(BadRequestException exception) {
            return Response.status(Response.Status.BAD_REQUEST).entity(
                    "Code:" + Response.Status.BAD_REQUEST + ":" + exception.getMessage()).build();
        }
    }

    @Provider
    public static class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

        @Override
        public Response toResponse(NotFoundException exception) {
            Response r = exception.getResponse();
            return Response.status(r.getStatus()).entity(
            		new APIResponse(r.getStatus(),exception.getMessage())).build();
        }
    }

}


