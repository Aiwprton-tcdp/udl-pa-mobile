package com.aiwprton.udl_pa_mobile.models;

import com.google.gson.annotations.SerializedName;

public class DealModel {
    @SerializedName("agreement")
    public AgreementModel Agreement;

    @SerializedName("delget")
    public DelgetModel Delget;

    @SerializedName("documents")
    public DocumentsModel Documents;

    @SerializedName("statusDeal")
    public DealStatusModel CurrentDealStatus;

    @SerializedName("statusAllDeal")
    public DealStatusesModel DealStatuses;

    public Boolean IsDealCompleted;
    public Boolean IsDealFailed;
}
