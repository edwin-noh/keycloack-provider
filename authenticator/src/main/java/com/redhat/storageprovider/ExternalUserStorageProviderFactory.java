package com.redhat.storageprovider;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

public class ExternalUserStorageProviderFactory implements UserStorageProviderFactory<ExternalUserStorageProvider> {
    @Override
    public ExternalUserStorageProvider create(KeycloakSession keycloakSession, ComponentModel componentModel) {
        return new ExternalUserStorageProvider(keycloakSession, componentModel);
    }

    @Override
    public String getId() {
        return "external-user-federation";
    }
}
