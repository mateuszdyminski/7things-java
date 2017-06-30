package com.things.logcontext.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.glassfish.grizzly.http.server.Request;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.container.*;
import java.io.IOException;
import java.util.UUID;

@PreMatching
public class LoggingFilterWithCtx implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String REQUEST_ID = "requestId";
    private static final String REQUEST_IP = "requestIp";
    private static Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Inject
    private Provider<Request> request;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        ThreadContext.put(REQUEST_ID, UUID.randomUUID().toString());
        ThreadContext.put(REQUEST_IP, request.get().getRemoteAddr());

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

        ThreadContext.remove(REQUEST_ID);
        ThreadContext.remove(REQUEST_IP);
    }
}
