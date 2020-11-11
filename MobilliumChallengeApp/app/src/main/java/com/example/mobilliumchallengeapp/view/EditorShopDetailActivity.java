package com.example.mobilliumchallengeapp.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilliumchallengeapp.R;
import com.example.mobilliumchallengeapp.adapter.EditorShopViewAdapter;
import com.example.mobilliumchallengeapp.adapter.ItemOffsetDecoration;
import com.example.mobilliumchallengeapp.model.Shop_;

import java.util.List;

public class EditorShopDetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Shop_> shopList;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    EditorShopViewAdapter editorShopViewAdapter;
    LinearLayoutManager VerticalLayout;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Editör Seçimi Vitrinler");
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));

        recyclerView
                = findViewById(
                R.id.recyclerview6);

        RecyclerViewLayoutManager
                = new GridLayoutManager(
                getApplicationContext(), 1);

        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getApplicationContext(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        shopList = ((List<Shop_>) getIntent().getExtras().getSerializable("shopList"));

        editorShopViewAdapter = new EditorShopViewAdapter(shopList, getApplicationContext(),R.layout.card4_all);
        recyclerView.setAdapter(editorShopViewAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
