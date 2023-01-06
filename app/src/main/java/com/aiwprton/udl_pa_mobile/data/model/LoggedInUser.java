package com.aiwprton.udl_pa_mobile.data.model;

import androidx.annotation.Nullable;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private final String userId;
    private final String displayName;
    private final String accessToken;

    public LoggedInUser(String accessToken, @Nullable String userId, @Nullable String displayName) {
        this.userId = userId;
        this.displayName = displayName;
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
    public String getUserId() {
        return userId;
    }
    public String getDisplayName() {
        return displayName;
    }
}