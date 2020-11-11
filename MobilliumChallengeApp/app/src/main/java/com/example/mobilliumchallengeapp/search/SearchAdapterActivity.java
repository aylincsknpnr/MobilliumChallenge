package com.example.mobilliumchallengeapp.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.example.mobilliumchallengeapp.R;
import com.mancj.materialsearchbar.MaterialSearchBar;



public class SearchAdapterActivity extends AppCompatActivity implements View.OnClickListener {
    private MaterialSearchBar searchBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        searchBar = findViewById(R.id.searchBar);
        searchBar.setSpeechMode(true);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);



        searchBar.setMaxSuggestionCount(2);
        searchBar.setHint("Find Product..");


        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("LOG_TAG", getClass().getSimpleName() + " text changed " + searchBar.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
    }

    @Override
    public void onClick(View view) {
    }

}
