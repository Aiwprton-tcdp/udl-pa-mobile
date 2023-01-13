package com.aiwprton.udl_pa_mobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DelgetModel {
    @SerializedName("id")
    public String ID;

    @SerializedName("STAGE_ID")
    public String Stage_id;

    @SerializedName("all_data")
    public List<PaymentSheduleModel> Payments;

    @SerializedName("invoice")
    public List<InvoiceModel> Invoices;

    @SerializedName("total_sum")
    public double Total_sum = 0;

    @SerializedName("next_payment_sum")
    public int Next_payment_sum;

    @SerializedName("next_payment_date")
    public String Next_payment_date;
}
