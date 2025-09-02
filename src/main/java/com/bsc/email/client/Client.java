package com.bsc.email.client;

/**
 * A client who we are sending emails on behalf of.
 */
public class Client {
    Long clientId;
    String name;
    String adminAddress;

    public Client(Long clientId, String name, String adminAddress) {
        this.clientId = clientId;
        this.name = name;
        this.adminAddress = adminAddress;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

}
