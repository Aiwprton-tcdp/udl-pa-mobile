package com.aiwprton.udl_pa_mobile.models;

import android.graphics.Color;

import com.google.gson.annotations.SerializedName;

public class PaymentSheduleModel {
    @SerializedName("status")
    public int Status;

    @SerializedName("date")
    public String Date;

    @SerializedName("status_name")
    public String StatusName;

    @SerializedName("sum")
    public String Sum;

    public Color StatusColor;
    public String StatusImage;
}
