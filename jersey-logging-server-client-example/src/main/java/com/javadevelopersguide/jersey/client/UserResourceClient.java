package com.javadevelopersguide.jersey.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

public class UserResourceClient {

	public static void main(String[] args) {
		 getUsers();
	}
	protected static ClientConfig createClientConfig() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		return config;
	}
	
	private static void getUsers() {
		Client client = ClientBuilder.newClient(createClientConfig());

		String entity = client.target("http://localhost:8080/jersey-logging-server-client-example/resources").path("users")
				.request(MediaType.APPLICATION_JSON).header("some-header", "true").get(String.class);

		System.out.println(entity);
	}

}
