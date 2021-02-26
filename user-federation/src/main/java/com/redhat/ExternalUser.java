package com.redhat;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExternalUser {

    private String id;
    private String username;
    private String password;
    private long createdTimestamp;

    private Map<String, List<String>> attributes;

    public ExternalUser(String id, String username, String password, Map<String, List<String>> attributes) {
        this.id = id;
        this.attributes = attributes;
        this.username = username;
        this.password = password;
        this.createdTimestamp = System.currentTimeMillis();
    }

    public List<String> getAttribute(String name) {
        return attributes.getOrDefault(name, Collections.emptyList());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
