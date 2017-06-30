package com.things.logcontext.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.container.*;
import java.io.IOException;

@PreMatching
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        logger.info("HTTP REQUEST: {} /{}  Headers: {}",
                requestContext.getMethod(),
                requestContext.getUriInfo().getPath(),
                requestContext.getHeaders());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        logger.info("HTTP RESPONSE: {} /{}  Status: {}",
                requestContext.getMethod(),
                requestContext.getUriInfo().getPath(),
                responseContext.getStatus());
    }
}
