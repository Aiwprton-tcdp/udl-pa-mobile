package com.aiwprton.udl_pa_mobile.models;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserModel {
    @SerializedName("id")
    public Integer Id;
    public Integer ContactId;
    public String EmailVerifiedAt;
    public Date EmailVerifiedDate;
    public String RememberToken;
    public Date CreatedAt;
    public Date EditedAt;
    @SerializedName("partner_id")
    @Nullable
    public Integer Partner_Id = -1;

    public String Password;
    public Integer PartnerId = Partner_Id;

    @SerializedName("surname")
    public String Surname = "";
    @SerializedName("name")
    public String Name = "";
    @SerializedName("patronymic")
    public String Patronymic = "";
    @SerializedName("phone")
    public String Phone = "7";
    @SerializedName("email")
    public String Email = "";
    public String AccessToken = "";
}
