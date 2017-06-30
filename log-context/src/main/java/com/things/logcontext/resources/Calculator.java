package com.things.logcontext.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static java.lang.String.format;

@Path("calculator")
public class Calculator {

    private static Logger logger = LogManager.getLogger(Calculator.class);

    @GET
    @Path("add")
    @Produces("text/plain")
    public String add(@QueryParam("val1") Integer val1,
                        @QueryParam("val2") Integer val2) {
        if (val1 != null) {
            logger.info("Got val1: {}", val1);
        }

        if (val2 != null) {
            logger.info("Got val2: {}", val2);
        }

        int result = val1 + val2;
        logger.info("Result: {}", result);

        return format("Result of %d + %d = %d", val1, val2, result);
    }
}