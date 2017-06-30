package com.things.versioning.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("health")
public class HealthResource {

    @Inject
    private GitRepositoryState gitRepositoryState;

    @GET
    @Produces("application/json")
    public Response getHealth() {
        return Response.ok().entity(new HealthStatus(gitRepositoryState)).build();
    }
}
