package com.example.mobilliumchallengeapp.service;

import com.example.mobilliumchallengeapp.model.Featured;
import com.example.mobilliumchallengeapp.model.Vitrinova;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface VitrinovaAPI {

    @GET("discover/")
    Call<List<Vitrinova>> getResults();

}
