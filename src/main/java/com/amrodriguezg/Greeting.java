package com.amrodriguezg;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/greeting")
public class Greeting {

    private static final Logger LOG = Logger.getLogger(Class.class);
    GreetingConfig config;
    FizzBuzzConfig fizzBuzzConfig;
    String confProp;

    @Inject
    public Greeting(@ConfigProperty(name = "application.greeting.recipient") String confProp
            , GreetingConfig config
            , FizzBuzzConfig fizzBuzzConfig) {
        this.config = config;
        this.confProp = confProp;
        this.fizzBuzzConfig = fizzBuzzConfig;
    }

    @Path("/getGreeting")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        LOG.info("Starting application...");
        return "Hello " + confProp + config.getRecipient();
    }

    @Path("/getFizzBuzz")
    @GET
    public String getFizzBuzz(@QueryParam("maxNumber") int maxNumber) {
        LOG.info("Starting application...");
        String message = fizzBuzzConfig.getFizzBuzzList(maxNumber);
        LOG.info("Stopping application...");
        return message;
    }
}
