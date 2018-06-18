package com.javadevelopersguide.jersey.config;

import javax.ws.rs.ApplicationPath;

// Deployment of a JAX-RS application using @ApplicationPath with Servlet 3.0
// Descriptor-less deployment
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("java8")
public class Java8Application extends ResourceConfig {
	public Java8Application() {
		
		// if there are more than two packanges then separate them with semicolon
		// exmaple : packages("org.foo.rest;org.bar.rest");
		packages("com.javadevelopersguide.jersey.java8");
		
		 // Resources.
        //register(DefaultMethodResource.class);
        //register(LambdaResource.class);
	}
}
