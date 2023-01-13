package com.aiwprton.udl_pa_mobile.models;

import com.google.gson.annotations.SerializedName;

public class DocumentModel {
    @SerializedName("DATE")
    public String Date;

    @SerializedName("COMMENT")
    public String Comment;

    @SerializedName("NAME")
    public String Name;

    @SerializedName("STATUS")
    public String Status;

    public String Background;

    public Boolean Visibility;
}
