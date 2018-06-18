package com.javadevelopersguide.jersey.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class AppResourceConfig extends ResourceConfig {
	public AppResourceConfig() {
		// if there are more than two packanges then separate them with semicolon
		// exmaple : packages("org.foo.rest;org.bar.rest");
		packages("com.javadevelopersguide.jersey.helloworld");
	}
}
