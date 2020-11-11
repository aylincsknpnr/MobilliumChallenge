package com.example.mobilliumchallengeapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VitrinovaService {
    private Retrofit retrofit = null;

    public VitrinovaAPI getAPI() {
        String BASE_URL = "https://www.vitrinova.com/api/v2/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(VitrinovaAPI.class);
    }
}
