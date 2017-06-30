package com.things.versioning.api.resources;


import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Resource
@Path("users")
public class UsersResource {

    @GET
    @Produces("application/vnd.usersapp-v1+json")
    public Response getUsersV1() {
        User user = new User("Jan", "Kowalski");

        return Response.ok().entity(Arrays.asList(user)).build();
    }

    @GET
    @Produces("application/vnd.usersapp-v2+json")
    public Response getUsersV2() {
        User user = new User("Jan", "Kowalski", "987654321");

        return Response.ok().entity(Arrays.asList(user)).build();
    }
}
