package com.amrodriguezg;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/greeting")
public class Greeting {

    private static final Logger LOG = Logger.getLogger(Class.class);
    GreetingConfig config;
    String confProp;

    @Inject
    public Greeting(@ConfigProperty(name = "application.greeting.recipient") String confProp, GreetingConfig config) {
        this.config = config;
        this.confProp = confProp;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        LOG.info("Starting application...");
        return "Hello " + confProp + config.getRecipient();
    }
}
