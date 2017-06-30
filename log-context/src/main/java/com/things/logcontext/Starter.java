package com.things.logcontext;

import com.things.logcontext.filters.LoggingFilter;
import com.things.logcontext.filters.LoggingFilterWithCtx;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Starter {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        GrizzlyHttpServerFactory
                .createHttpServer(new URI("http://localhost:" + args[0]), createResources(args[1]), false)
                .start();

        // join server thread to prevent program from exiting
        Thread.currentThread().join();
    }

    public static ResourceConfig createResources(String withCtx) {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("com.things.logcontext.resources");
        if (Boolean.parseBoolean(withCtx)) {
            resourceConfig.register(LoggingFilterWithCtx.class);
        } else {
            resourceConfig.register(LoggingFilter.class);
        }

        return resourceConfig;
    }
}
