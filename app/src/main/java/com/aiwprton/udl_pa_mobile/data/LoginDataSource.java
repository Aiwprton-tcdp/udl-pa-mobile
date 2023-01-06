package com.aiwprton.udl_pa_mobile.data;

import static com.aiwprton.udl_pa_mobile.App.pref;

import com.aiwprton.udl_pa_mobile.data.model.LoggedInUser;
import com.aiwprton.udl_pa_mobile.services.AuthService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String phone, String password) {
        try {
            AuthService.SignIn(phone, password);
            TimeUnit.SECONDS.sleep(3);
            String token = pref.getString("access_token", "empty");
            int user_id = pref.getInt("user_id", 0);
            String name = pref.getString("name", "empty");

            LoggedInUser u = new LoggedInUser(token, Integer.toString(user_id), name);
            // TODO: handle loggedInUser authentication
//            LoggedInUser fakeUser =
//                    new LoggedInUser(
//                            java.util.UUID.randomUUID().toString(),
//                            "Jane Doe");
            return new Result.Success<>(u);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}