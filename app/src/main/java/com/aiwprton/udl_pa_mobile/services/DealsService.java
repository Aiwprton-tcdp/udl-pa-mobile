package com.aiwprton.udl_pa_mobile.services;

import static com.aiwprton.udl_pa_mobile.App.pref;
import static com.aiwprton.udl_pa_mobile.App.prefEditor;
import android.util.Log;
import com.aiwprton.udl_pa_mobile.models.Deal;
import com.aiwprton.udl_pa_mobile.models.DealsModel;
import com.aiwprton.udl_pa_mobile.models.ResponseModel;
import com.aiwprton.udl_pa_mobile.services.controls.CallbackFuture;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DealsService {
    public static List<DealsModel> GetDeals() throws IOException, ExecutionException, InterruptedException {
        List<DealsModel> Deals = getDealsData();
        Log.i("GetDeals", Deals.toString());

        return Deals;
    }


    private static List<DealsModel> getDealsData() throws ExecutionException, InterruptedException, IOException {
        String uri = com.aiwprton.udl_pa_mobile.App.ApiDomenUri + "getDeals";
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
        Log.i("Deals", result);

        Type idOfGsonType = new TypeToken<ResponseModel<JsonObject>>() {}.getType();
        ResponseModel<JsonObject> data = new Gson().fromJson(result, idOfGsonType);

        prefEditor.putString("Deals", data.Data.toString());
        prefEditor.commit();

        return prepareDealsData(data.Data);
    }

    private static List<DealsModel> prepareDealsData(JsonObject data) {
        List<DealsModel> ResultDeals = new ArrayList<>();

        for (Map.Entry<String,JsonElement> entry : data.entrySet()) {
            Log.i("entry", entry.getKey());
            Log.i("entry", entry.getValue().toString());

            DealsModel dm = new DealsModel();
            dm.Name = entry.getKey();
            dm.Deals = new Gson().fromJson(entry.getValue().toString(), Deal[].class);

            ResultDeals.add(dm);
        }

        return ResultDeals;
    }
}
