package com.javadevelopersguide.jersey.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javadevelopersguide.jersey.model.User;

@Path("/users")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> fetchAll() {
		 List<User> users = new ArrayList<User>();
		users.add(new User(100, "A", "demo@gmail.com"));
		users.add(new User(101, "B", "demo1@gmail.com"));
		users.add(new User(102, "C", "demo2@gmail.com"));
		return users;
	}
}
