package com.things.versioning;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Starter {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        GrizzlyHttpServerFactory
                .createHttpServer(new URI("http://localhost:8090"), createResources(), false)
                .start();

        // join server thread to prevent program from exiting
        Thread.currentThread().join();
    }

    public static ResourceConfig createResources() {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("com.things.versioning.resources");
        resourceConfig.register(new HealthBinder());
        resourceConfig.register(JacksonFeature.class);

        return resourceConfig;
    }
}
