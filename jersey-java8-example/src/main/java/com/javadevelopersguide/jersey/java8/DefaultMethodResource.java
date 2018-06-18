package com.javadevelopersguide.jersey.java8;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * JAX-RS resource inheriting some resource method implementations from the implemented interface.
 *
 */
@Path("default-method")
@Produces("text/plain")
public class DefaultMethodResource implements DefaultMethodInterface {

    @GET
    @Path("class")
    public String fromClass() {
        return "class";
    }
}
