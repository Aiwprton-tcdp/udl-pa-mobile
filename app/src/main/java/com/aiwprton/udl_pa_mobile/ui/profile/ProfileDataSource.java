package com.aiwprton.udl_pa_mobile.ui.profile;

import com.aiwprton.udl_pa_mobile.data.Result;
import com.aiwprton.udl_pa_mobile.services.AuthService;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class ProfileDataSource {
    public Result logout() {
        AuthService.LogOut();
        return new Result.Success<>(null);
    }
}