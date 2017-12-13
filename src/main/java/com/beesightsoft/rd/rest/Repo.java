package com.beesightsoft.rd.rest;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }
}
