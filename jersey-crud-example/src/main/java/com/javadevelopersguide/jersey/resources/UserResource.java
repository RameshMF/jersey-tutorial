package com.javadevelopersguide.jersey.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.javadevelopersguide.jersey.model.User;
import com.javadevelopersguide.jersey.services.UserService;

@Path("/users")
public class UserResource {

	private UserService userService = new UserService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> fetchAll() {
		return userService.fetchAll();
	}

	@GET
	@Path("user/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchBy(@PathParam("id") int id)  {
		User user = userService.fetchBy(id);
		return Response.ok().entity(user).build();
	}
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		return Response.ok().entity(new User(100, "me", "me@gmail.com")).build();
	}
	

	@GET
	@Path("exception/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response exception(@PathParam("id") long id) {
		throw new NotFoundException("Resource not found ::" + id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		// create notification
		userService.create(user);
		return Response.status(Status.CREATED).build();
	}

	@POST
    @Path("request_exception")
    public String exceptionInRequestFilter() {
        throw new InternalServerErrorException();        // should not reach here
    }
	
	@PUT
	@Path("/user/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") long id, User user) {
		userService.update(user);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/user/{id}")
	public Response delete(@PathParam("id") long id) {
		userService.delete(id);
		return Response.status(202).entity("User deleted successfully !!").build();
	}
}
