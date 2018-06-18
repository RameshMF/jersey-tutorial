package com.javadevelopersguide.jersey.config;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
// Deployment of a JAX-RS application using @ApplicationPath with Servlet 3.0
// Descriptor-less deployment
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class JerseyServletContainerConfig extends ResourceConfig {
	public JerseyServletContainerConfig() {
		
		// if there are more than two packanges then separate them with semicolon
		// exmaple : packages("org.foo.rest;org.bar.rest");
		packages("com.javadevelopersguide.jersey.helloworld;com.javadevelopersguide.jersey.jsonmoxy");
	}
	
	/* public ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
	        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
	        Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
	        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
	        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
	        return moxyJsonConfig.resolver();
	    }*/
}
