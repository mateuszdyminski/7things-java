package com.things.versioning.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class HealthStatus {

    private GitRepositoryState gitRepositoryState;

    public HealthStatus(GitRepositoryState gitRepositoryState) {
        this.gitRepositoryState = gitRepositoryState;
    }

    public GitRepositoryState getGitRepositoryState() {
        return gitRepositoryState;
    }
}
