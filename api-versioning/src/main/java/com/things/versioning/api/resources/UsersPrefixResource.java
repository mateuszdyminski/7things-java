package com.things.versioning.api.resources;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Resource
@Path("/api")
public class UsersPrefixResource {

    @GET
    @Path("/v{version}/users")
    @Produces("application/json")
    public Response getUsers(@PathParam("version") String version) {
        if (version.equalsIgnoreCase("1")) {
            return Response.ok().entity(Arrays.asList(new User("Jan", "Kowalski"))).build();
        } else {
            return Response.ok().entity(Arrays.asList(new User("Jan", "Kowalski", "987654321"))).build();
        }
    }
}
