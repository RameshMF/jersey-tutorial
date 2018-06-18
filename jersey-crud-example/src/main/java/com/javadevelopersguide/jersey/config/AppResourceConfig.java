package com.javadevelopersguide.jersey.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
// Deployment of a JAX-RS application using @ApplicationPath with Servlet 3.0
// Descriptor-less deployment
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class AppResourceConfig extends ResourceConfig {
	
	public AppResourceConfig() {
		// if there are more than two packanges then separate them with semicolon
		// exmaple : packages("org.foo.rest;org.bar.rest");
		packages("com.javadevelopersguide.jersey.resources");
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
	}
}
