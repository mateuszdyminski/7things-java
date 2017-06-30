package com.things.versioning.resources;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("api/health")
public class ExtendedHealthResource {

    @Inject
    private GitRepositoryState gitRepositoryState;

    @Inject
    private MongoDatabase mongoDatabase;

    @Inject
    private AppStatus appStatus;

    @GET
    @Produces("application/json")
    public Response getHealth() {
        Document serverStatus = mongoDatabase.runCommand(new Document("serverStatus", 1));
        return Response.ok().entity(new ExtendedHealthStatus(gitRepositoryState, serverStatus, appStatus)).build();
    }
}
