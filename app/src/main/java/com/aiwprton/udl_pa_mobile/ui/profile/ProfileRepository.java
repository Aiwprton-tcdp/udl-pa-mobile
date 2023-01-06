package com.aiwprton.udl_pa_mobile.ui.profile;

import com.aiwprton.udl_pa_mobile.data.LoginDataSource;
import com.aiwprton.udl_pa_mobile.data.Result;
import com.aiwprton.udl_pa_mobile.data.model.LoggedInUser;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class ProfileRepository {

    private static volatile ProfileRepository instance;

    private final ProfileDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;

    // private constructor : singleton access
    private ProfileRepository(ProfileDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ProfileRepository getInstance(ProfileDataSource dataSource) {
        if (instance == null) {
            instance = new ProfileRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }
}