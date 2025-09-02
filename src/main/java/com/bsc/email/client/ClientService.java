package com.bsc.email.client;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClientService {
    private List<Client> clients;

    public ClientService(Client... clients) {
        this(Arrays.asList(clients));
    }

    public ClientService(List<Client> clients) {
        this.clients = clients;
    }

    public Optional<Client> getClientById(long clientId) {
        return clients.stream()
                      .filter(c -> Objects.equals(c.getClientId(), clientId))
                      .findFirst();
    }
}
