package com.example.mobilliumchallengeapp.contract;

import com.example.mobilliumchallengeapp.model.Vitrinova;

import java.util.List;

public interface IVitrinovaContract {

    interface View {
        void init();
        void loadList(List<Vitrinova> vitrinovas);
    }

    interface Presenter {
        void start();
        void  fetchData();
    }
}
