package com.things.versioning.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Duration;
import java.time.LocalDateTime;

public class AppStatus {

    private String hostname;
    private LocalDateTime StartedAt;

    public AppStatus(String hostname, LocalDateTime startedAt) {
        this.hostname = hostname;
        StartedAt = startedAt;
    }

    public String getHostname() {
        return hostname;
    }

    @JsonProperty
    public String getStartedAt() {
        return StartedAt.toString();
    }

    @JsonProperty
    public String uptime() {
        return Duration.between(StartedAt , LocalDateTime.now()).toString();
    }
}
