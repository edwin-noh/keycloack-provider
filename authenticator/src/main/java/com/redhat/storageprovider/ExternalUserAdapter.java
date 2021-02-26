package com.redhat.storageprovider;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;
import org.keycloak.storage.federated.UserFederatedStorageProvider;

public class ExternalUserAdapter extends AbstractUserAdapterFederatedStorage {

    private final ExternalUser externalUser;
    private final String keycloakId;

    public ExternalUserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, ExternalUser externalUser) {
        super(session, realm, model);
        this.externalUser = externalUser;
        this.keycloakId = StorageId.keycloakId(model, externalUser.getId());
    }

    @Override
    public UserFederatedStorageProvider getFederatedStorage() {
        // internal JPA user storage in keycloak.
        // used to store data that cannot be stored by the external federation provider
        return super.getFederatedStorage();
    }

    protected ExternalUserStorageProvider getExternalUserStorageProvider() {
        // external user storage provider
        return session.getProvider(ExternalUserStorageProvider.class, this.storageProviderModel);
    }

    @Override
    public String getId() {
        return keycloakId;
    }

    @Override
    public String getUsername() {
        return externalUser.getUsername();
    }

    @Override
    public void setUsername(String username) {
        externalUser.setUsername(username);
    }
}
