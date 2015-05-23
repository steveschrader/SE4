package be.odisee.pajotter.service;

import be.odisee.pajotter.domain.Partij;

public interface UserContextService {

    public Partij getAuthenticatedPersoon();
}
