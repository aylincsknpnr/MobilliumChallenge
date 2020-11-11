package com.example.mobilliumchallengeapp.presenter;

import com.example.mobilliumchallengeapp.contract.IVitrinovaContract;
import com.example.mobilliumchallengeapp.model.Vitrinova;
import com.example.mobilliumchallengeapp.service.VitrinovaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VitrinovaPresenter implements IVitrinovaContract.Presenter {
    IVitrinovaContract.View vitrionaView;

    private VitrinovaService vitrinovaService;

    public VitrinovaPresenter(IVitrinovaContract.View view) {
        this.vitrionaView = view;

        if (this.vitrinovaService == null) {
            this.vitrinovaService = new VitrinovaService();
        }
    }

    @Override
    public void start() {
        vitrionaView.init();
    }

    @Override
    public void fetchData() {
        vitrinovaService
                .getAPI()
                .getResults()
                .enqueue(new Callback<List<Vitrinova>>() {
                    @Override
                    public void onResponse(Call<List<Vitrinova>> call, Response<List<Vitrinova>> response) {
                        System.out.println(response.body());
                        List<Vitrinova> vitrinovaList = response.body();
                        vitrionaView.loadList(vitrinovaList);

                    }

                    @Override
                    public void onFailure(Call<List<Vitrinova>> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
