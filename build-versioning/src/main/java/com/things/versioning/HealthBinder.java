package com.things.versioning;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.things.versioning.resources.AppStatus;
import com.things.versioning.resources.GitRepositoryState;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

public class HealthBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(getGitRepositoryState()).to(GitRepositoryState.class);
        bind(getMongoDatabase()).to(MongoDatabase.class);
        bind(getAppStatus()).to(AppStatus.class);
    }

    private GitRepositoryState getGitRepositoryState() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("git.properties"));

            return new GitRepositoryState(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MongoDatabase getMongoDatabase() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("mongo.properties"));

            String dbName = properties.getProperty("dbName");
            String host = properties.getProperty("host");
            int port = Integer.parseInt(properties.getProperty("port"));

            MongoClient mongoClient = new MongoClient(host, port);
            return mongoClient.getDatabase(dbName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private AppStatus getAppStatus() {
        String hostname = "Unknown";

        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            throw new RuntimeException(ex);
        }

        return new AppStatus(hostname, LocalDateTime.now());
    }
}