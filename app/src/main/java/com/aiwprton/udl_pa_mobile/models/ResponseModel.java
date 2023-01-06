package com.aiwprton.udl_pa_mobile.models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class ResponseModel<T> {
    @SerializedName("data")
    public T Data;

    @SerializedName("status")
    public String Status;

    @SerializedName("msg")
    public String Msg; // Сообщения обычные

    @SerializedName("message")
    public String Message; // Сообщения об ошибках

    @SerializedName("errors")
    public JSONObject Errors; // Сообщения об ошибках

    @SerializedName("original")
    public JSONObject Original; // Сообщения об ошибках


    private final Class<T> type;

    public ResponseModel(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return this.type;
    }
}
