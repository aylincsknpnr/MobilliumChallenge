package com.example.mobilliumchallengeapp.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilliumchallengeapp.R;
import com.example.mobilliumchallengeapp.adapter.CollectionsViewAdapter;
import com.example.mobilliumchallengeapp.model.Collection;

import java.util.List;

public class CollectionDetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Collection> collectionList;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    CollectionsViewAdapter collectionsViewAdapter;
    LinearLayoutManager VerticalLayout;
    LinearLayout linearLayout;
    LinearLayoutManager HorizontalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Koleksiyonlar");
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        HorizontalLayout
                = new LinearLayoutManager(
                CollectionDetailActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView
                = findViewById(
                R.id.recyclerview6);


        recyclerView.setLayoutManager(HorizontalLayout);

        collectionList = ((List<Collection>) getIntent().getExtras().getSerializable("collectionList"));

        collectionsViewAdapter = new CollectionsViewAdapter(collectionList, getApplicationContext());
        recyclerView.setAdapter(collectionsViewAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
