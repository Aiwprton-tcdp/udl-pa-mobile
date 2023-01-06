package com.aiwprton.udl_pa_mobile.services;

import static com.aiwprton.udl_pa_mobile.App.ApiDomenUri;
import static com.aiwprton.udl_pa_mobile.App.pref;
import static com.aiwprton.udl_pa_mobile.App.prefEditor;
import com.aiwprton.udl_pa_mobile.models.ResponseModel;
import com.aiwprton.udl_pa_mobile.models.TokenModel;
import com.aiwprton.udl_pa_mobile.models.UserModel;
import com.aiwprton.udl_pa_mobile.services.controls.CallbackFuture;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthService {
    public static void SignIn(String phone, String password) throws IOException, ExecutionException, InterruptedException {
        RequestBody formBody = new FormBody.Builder()
                .add("phone", phone)
                .add("password", password)
                .build();

        TrySignIn(formBody);
        GetUserData();
    }

    public static void LogOut() {
        prefEditor.clear().commit();
    }


    private static void TrySignIn(RequestBody formBody) throws IOException, ExecutionException, InterruptedException {
        String uri = ApiDomenUri + "login";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(uri)
                .post(formBody)
                .addHeader("Accept", "application/json; charset=utf-8")
                .build();
        CallbackFuture future = new CallbackFuture();

        client.newCall(request).enqueue(future);
        Response response = future.get();

        assert response.body() != null;
        String result = response.body().string();
        TokenModel data = new Gson().fromJson(result, TokenModel.class);

        prefEditor.putString("access_token", data.Data);
        prefEditor.commit();
    }

    private static void GetUserData() throws ExecutionException, InterruptedException, IOException {
        String uri = ApiDomenUri + "getUser";
        String token = pref.getString("access_token", "empty");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(uri)
                .post(new FormBody.Builder().build())
                .addHeader("Accept", "application/json; charset=utf-8")
                .addHeader("Authorization", "Bearer " + token)
                .build();
        CallbackFuture future = new CallbackFuture();

        client.newCall(request).enqueue(future);
        Response response = future.get();

        assert response.body() != null;
        String result = response.body().string();
        Type idOfGsonType = new TypeToken<ResponseModel<UserModel>>() {}.getType();
        ResponseModel<UserModel> data = new Gson().fromJson(result, idOfGsonType);
        UserModel u = data.Data;

        prefEditor.putInt("user_id", u.Id);
        prefEditor.putInt("partner_id", u.PartnerId);
        prefEditor.putString("surname", u.Surname);
        prefEditor.putString("name", u.Name);
        prefEditor.putString("patronymic", u.Patronymic);
        prefEditor.putString("phone", u.Phone);
        prefEditor.putString("email", u.Email);
        prefEditor.commit();
    }
}
