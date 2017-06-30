package com.things.versioning.resources;

import org.bson.Document;

public class ExtendedHealthStatus extends HealthStatus {

    private Document mongoStatus;
    private AppStatus appStatus;

    public ExtendedHealthStatus(GitRepositoryState gitRepositoryState, Document mongoStatus, AppStatus appStatus) {
        super(gitRepositoryState);
        this.mongoStatus = mongoStatus;
        this.appStatus = appStatus;
    }

    public AppStatus getAppStatus() {
        return appStatus;
    }

    public Document getMongoStatus() {
        return mongoStatus;
    }
}
