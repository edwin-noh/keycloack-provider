package com.redhat.storageprovider;

import org.keycloak.common.util.MultivaluedHashMap;
import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.models.*;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.federated.UserAttributeFederatedStorage;
import org.keycloak.storage.user.UserLookupProvider;
import org.keycloak.storage.user.UserQueryProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExternalUserStorageProvider implements UserStorageProvider, UserLookupProvider, UserQueryProvider,
        UserAttributeFederatedStorage, CredentialInputValidator {

    private final KeycloakSession session;
    private final ComponentModel storageComponentModel;
    private ExternalUser myUser;

    public ExternalUserStorageProvider(KeycloakSession session, ComponentModel storageComponentModel) {
        this.session = session;
        this.storageComponentModel = storageComponentModel;
        myUser = new ExternalUser("edwin-1", "eli", "1111", null);
    }

    @Override
    public void close() {
    }

    @Override
    public void setSingleAttribute(RealmModel realmModel, String s, String s1, String s2) {

    }

    @Override
    public void setAttribute(RealmModel realmModel, String s, String s1, List<String> list) {

    }

    @Override
    public void removeAttribute(RealmModel realmModel, String s, String s1) {

    }

    @Override
    public MultivaluedHashMap<String, String> getAttributes(RealmModel realmModel, String s) {
        return null;
    }

    @Override
    public List<String> getUsersByUserAttribute(RealmModel realmModel, String s, String s1) {
        return null;
    }

    @Override
    public UserModel getUserById(String id, RealmModel realm) {
        return null;
    }

    @Override
    public UserModel getUserByUsername(String username, RealmModel realm) {
        return createAdapter(realm, myUser);
    }

    protected UserModel createAdapter(RealmModel realm, ExternalUser externalUser) {
        if (externalUser == null) {
            return null;
        }
        ExternalUserAdapter externalUserAdapter = new ExternalUserAdapter(session, realm, storageComponentModel, externalUser);
        return externalUserAdapter;
    }

    @Override
    public UserModel getUserByEmail(String email, RealmModel realm) {
        return getUserByUsername(email, realm);
    }

    @Override
    public boolean supportsCredentialType(String credentialType) {
        return PasswordCredentialModel.TYPE.equals(credentialType);
    }

    @Override
    public boolean isConfiguredFor(RealmModel realmModel, UserModel userModel, String credentialType) {
        return supportsCredentialType(credentialType);
    }

    @Override
    public boolean isValid(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {
        return true;
    }

    @Override
    public int getUsersCount(RealmModel realmModel) {
        return 1;
    }

    @Override
    public List<UserModel> getUsers(RealmModel realmModel) {
        List<UserModel> users = new ArrayList<>();
        users.add(new ExternalUserAdapter(session, realmModel, storageComponentModel, myUser));
        return users;
    }

    @Override
    public List<UserModel> getUsers(RealmModel realmModel, int firstResult, int maxResults) {
        return getUsers(realmModel);
    }

    @Override
    public List<UserModel> searchForUser(String s, RealmModel realmModel) {
        return getUsers(realmModel);
    }

    @Override
    public List<UserModel> searchForUser(String s, RealmModel realmModel, int i, int i1) {
        return getUsers(realmModel);
    }

    @Override
    public List<UserModel> searchForUser(Map<String, String> map, RealmModel realmModel) {
        return getUsers(realmModel);
    }

    @Override
    public List<UserModel> searchForUser(Map<String, String> map, RealmModel realmModel, int i, int i1) {
        return getUsers(realmModel);
    }

    @Override
    public List<UserModel> getGroupMembers(RealmModel realmModel, GroupModel groupModel, int i, int i1) {
        return getUsers(realmModel);
    }

    @Override
    public List<UserModel> getGroupMembers(RealmModel realmModel, GroupModel groupModel) {
        return getUsers(realmModel);
    }

    @Override
    public List<UserModel> searchForUserByUserAttribute(String s, String s1, RealmModel realmModel) {
        return null;
    }
}
