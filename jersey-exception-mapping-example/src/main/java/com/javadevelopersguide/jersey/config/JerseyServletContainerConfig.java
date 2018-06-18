package com.javadevelopersguide.jersey.config;

import javax.ws.rs.ApplicationPath;

// Deployment of a JAX-RS application using @ApplicationPath with Servlet 3.0
// Descriptor-less deployment
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class JerseyServletContainerConfig extends ResourceConfig {
	public JerseyServletContainerConfig() {
		
		// if there are more than two packanges then separate them with semicolon
		// exmaple : packages("org.foo.rest;org.bar.rest");
		packages("com.javadevelopersguide.jersey.helloworld;com.javadevelopersguide.jersey.resources");
	}
}
