package com.example.mobilliumchallengeapp.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mobilliumchallengeapp.R;
import com.example.mobilliumchallengeapp.adapter.CategoryViewAdapter;
import com.example.mobilliumchallengeapp.adapter.CollectionsViewAdapter;
import com.example.mobilliumchallengeapp.adapter.EditorShopViewAdapter;
import com.example.mobilliumchallengeapp.adapter.NewShopViewAdapter;
import com.example.mobilliumchallengeapp.adapter.ProductViewAdapter;
import com.example.mobilliumchallengeapp.contract.IVitrinovaContract;
import com.example.mobilliumchallengeapp.model.Category_;
import com.example.mobilliumchallengeapp.model.Collection;
import com.example.mobilliumchallengeapp.model.Image;
import com.example.mobilliumchallengeapp.model.Product;
import com.example.mobilliumchallengeapp.model.Shop_;
import com.example.mobilliumchallengeapp.model.Vitrinova;
import com.example.mobilliumchallengeapp.presenter.VitrinovaPresenter;
import com.example.mobilliumchallengeapp.slider.SliderImageAdapter;
import com.example.mobilliumchallengeapp.slider.SliderItem;
import com.google.android.material.navigation.NavigationView;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MaterialSearchBar.OnSearchActionListener, IVitrinovaContract.View, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, RecognitionListener, TextWatcher, DrawController.ClickListener {
    MaterialSearchBar searchBar;
    private DrawerLayout drawer;
    SliderView sliderView;
    private SliderImageAdapter adapter;
    VitrinovaPresenter vitrinovaPresenter;
    RecyclerView recyclerView, recyclerView2, recyclerView3, recyclerView4, recyclerView5;

    List<Product> productList;
    List<Category_> categoryList;
    List<Collection> collectionList;
    List<Shop_> shopList;
    List<Shop_> newShopList;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    ProductViewAdapter productViewAdapter;
    CategoryViewAdapter categoryViewAdapter;
    CollectionsViewAdapter collectionsViewAdapter;
    EditorShopViewAdapter editorShopViewAdapter;
    NewShopViewAdapter newShopViewAdapter;

    LinearLayoutManager HorizontalLayout, HorizontalLayout2, HorizontalLayout3, HorizontalLayout4, HorizontalLAyout5;

    LinearLayout linearLayout;

    TextView tvAllProduct, tvAllCollection, tvAllEdShop, tvNewShop;
    SwipeRefreshLayout swipeRefreshLayout;

    SpeechRecognizer speechRecognizer;
    Intent speechRecognizerIntent;
    public static final Integer RecordAudioRequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vitrinovaPresenter = new VitrinovaPresenter(this);
        vitrinovaPresenter.start();

    }

    @Override
    public void init() {
        vitrinovaPresenter.fetchData();
        swipeRefreshLayout = findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(this);

        tvAllProduct = findViewById(R.id.tvAllProduct);
        tvAllCollection = findViewById(R.id.tvAllCollection);
        tvAllEdShop = findViewById(R.id.tvAllEdShop);
        tvNewShop = findViewById(R.id.tvNewShop);

        tvAllProduct.setOnClickListener(this);
        tvAllCollection.setOnClickListener(this);
        tvAllEdShop.setOnClickListener(this);
        tvNewShop.setOnClickListener(this);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        searchBar = findViewById(R.id.searchBar);
        searchBar.setSpeechMode(true);
        searchBar.setOnSearchActionListener(this);
        searchBar.setText("Ürün veya vitrin ara");
        searchBar.setCardViewElevation(10);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            checkPermission();
        }

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "tr-TR");
        speechRecognizer.setRecognitionListener(this);

        searchBar.addTextChangeListener(this);
        searchBar.setOnClickListener(this);

        sliderView = findViewById(R.id.imageSlider);
        adapter = new SliderImageAdapter(this);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setOnIndicatorClickListener(this);

        recyclerView
                = (RecyclerView) findViewById(
                R.id.recyclerview);
        recyclerView2 = findViewById(R.id.recyclerview2);
        recyclerView3 = findViewById(R.id.recyclerview3);
        recyclerView4 = findViewById(R.id.recyclerview4);
        recyclerView5 = findViewById(R.id.recyclerview5);

        RecyclerViewLayoutManager
                = new LinearLayoutManager(
                getApplicationContext());

        recyclerView.setLayoutManager(
                RecyclerViewLayoutManager);
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        linearLayout = findViewById(R.id.linearlayout3);
        HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout2
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout3
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout4
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLAyout5
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(HorizontalLayout);
        recyclerView2.setLayoutManager(HorizontalLayout2);
        recyclerView3.setLayoutManager(HorizontalLayout3);
        recyclerView4.setLayoutManager(HorizontalLayout4);
        recyclerView5.setLayoutManager(HorizontalLAyout5);

    }

    @Override
    public void loadList(List<Vitrinova> vitrinovas) {
        productList = new ArrayList<>();
        categoryList = new ArrayList<>();
        collectionList = new ArrayList<>();
        shopList = new ArrayList<>();
        newShopList = new ArrayList<>();
        List<SliderItem> sliderItemList = new ArrayList<>();

        for (int i = 0; i < vitrinovas.get(0).getFeatured().size(); i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setImageUrl(vitrinovas.get(0).getFeatured().get(i).getCover().getUrl());
            sliderItem.setTitle(vitrinovas.get(0).getFeatured().get(i).getTitle().toUpperCase());
            sliderItem.setSubtitle(vitrinovas.get(0).getFeatured().get(i).getSubTitle().toUpperCase());
            sliderItemList.add(sliderItem);
        }
        for (int i = 0; i < vitrinovas.get(1).getProducts().size(); i++) {
            Product product = new Product();
            product.setTitle(vitrinovas.get(1).getProducts().get(i).getTitle());
            product.setPrice(vitrinovas.get(1).getProducts().get(i).getPrice());
            List<Image> imageList = vitrinovas.get(1).getProducts().get(i).getImages();
            product.setImages(imageList);
            productList.add(product);
        }

        for (int i = 0; i < vitrinovas.get(2).getCategories().size(); i++) {
            Category_ category = new Category_();
            category.setName(vitrinovas.get(2).getCategories().get(i).getName());
            category.setLogo(vitrinovas.get(2).getCategories().get(i).getLogo());
            categoryList.add(category);
        }
        for (int i = 0; i < vitrinovas.get(3).getCollections().size(); i++) {
            Collection collection = new Collection();
            collection.setTitle(vitrinovas.get(3).getCollections().get(i).getTitle());
            collection.setDefinition(vitrinovas.get(3).getCollections().get(i).getDefinition());
            collection.setCover(vitrinovas.get(3).getCollections().get(i).getCover());
            collectionList.add(collection);
        }
        for (int i = 0; i < vitrinovas.get(4).getShops().size(); i++) {
            Shop_ shop_ = new Shop_();
            shop_.setName(vitrinovas.get(4).getShops().get(i).getName());
            shop_.setDefinition(vitrinovas.get(4).getShops().get(i).getDefinition());
            shop_.setLogo(vitrinovas.get(4).getShops().get(i).getLogo());
            shop_.setCover(vitrinovas.get(4).getShops().get(i).getCover());
            shop_.setPopularProducts(vitrinovas.get(4).getShops().get(i).getPopularProducts());
            shopList.add(shop_);
        }
        for (int i = 0; i < vitrinovas.get(5).getShops().size(); i++) {
            Shop_ shop_ = new Shop_();
            shop_.setName(vitrinovas.get(5).getShops().get(i).getName());
            shop_.setDefinition(vitrinovas.get(5).getShops().get(i).getDefinition());
            shop_.setCover(vitrinovas.get(5).getShops().get(i).getCover());
            shop_.setProductCount(vitrinovas.get(5).getShops().get(i).getProductCount());
            newShopList.add(shop_);
        }
        adapter.renewItems(sliderItemList);
        productViewAdapter = new ProductViewAdapter(productList, getApplicationContext(), R.layout.card);
        categoryViewAdapter = new CategoryViewAdapter(categoryList, getApplicationContext());
        collectionsViewAdapter = new CollectionsViewAdapter(collectionList, getApplicationContext());
        editorShopViewAdapter = new EditorShopViewAdapter(shopList, getApplicationContext(), R.layout.card4);
        newShopViewAdapter = new NewShopViewAdapter(newShopList, getApplicationContext(),R.layout.card5);

        AddItemsToRecyclerViewArrayList(recyclerView, productViewAdapter);
        AddItemsToRecyclerViewArrayList2(recyclerView2, categoryViewAdapter);
        AddItemsToRecyclerViewArrayList3(recyclerView3, collectionsViewAdapter);
        AddItemsToRecyclerViewArrayList4(recyclerView4, editorShopViewAdapter);
        AddItemsToRecyclerViewArrayList5(recyclerView5, newShopViewAdapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RecordAudioRequestCode && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        speechRecognizer.destroy();
    }

    private void checkPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, RecordAudioRequestCode);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {
    }

    @Override
    public void onSearchConfirmed(CharSequence text) {

    }

    @Override
    public void onButtonClicked(int buttonCode) {
        switch (buttonCode) {
            case MaterialSearchBar.BUTTON_NAVIGATION:
                drawer.openDrawer(GravityCompat.START);
                break;
            case MaterialSearchBar.BUTTON_SPEECH:
                break;
            case MaterialSearchBar.BUTTON_BACK:
                searchBar.closeSearch();
                break;
        }
    }

    public void AddItemsToRecyclerViewArrayList5(RecyclerView recyclerView5, NewShopViewAdapter newShopViewAdapter) {
        recyclerView5.setAdapter(newShopViewAdapter);
    }

    public void AddItemsToRecyclerViewArrayList4(RecyclerView recyclerView4, EditorShopViewAdapter editorShopViewAdapter) {
        recyclerView4.setAdapter(editorShopViewAdapter);
    }

    public void AddItemsToRecyclerViewArrayList3(RecyclerView recyclerView3, CollectionsViewAdapter collectionsViewAdapter) {
        recyclerView3.setAdapter(collectionsViewAdapter);
    }

    public void AddItemsToRecyclerViewArrayList2(RecyclerView recyclerView2, CategoryViewAdapter categoryViewAdapter) {
        recyclerView2.setAdapter(categoryViewAdapter);
    }

    public void AddItemsToRecyclerViewArrayList(RecyclerView recyclerView, ProductViewAdapter productViewAdapter) {
        recyclerView.setAdapter(productViewAdapter);
    }


    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);

        productViewAdapter = new ProductViewAdapter(productList, getApplicationContext(), R.layout.card);
        categoryViewAdapter = new CategoryViewAdapter(categoryList, getApplicationContext());
        collectionsViewAdapter = new CollectionsViewAdapter(collectionList, getApplicationContext());
        editorShopViewAdapter = new EditorShopViewAdapter(shopList, getApplicationContext(), R.layout.card4);
        newShopViewAdapter = new NewShopViewAdapter(newShopList, getApplicationContext(),R.layout.card5);

        AddItemsToRecyclerViewArrayList(recyclerView, productViewAdapter);
        AddItemsToRecyclerViewArrayList2(recyclerView2, categoryViewAdapter);
        AddItemsToRecyclerViewArrayList3(recyclerView3, collectionsViewAdapter);
        AddItemsToRecyclerViewArrayList4(recyclerView4, editorShopViewAdapter);
        AddItemsToRecyclerViewArrayList5(recyclerView5, newShopViewAdapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.tvAllProduct:
                Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
                intent.putExtra("productList", (Serializable) productList);
                startActivity(intent);
                break;
            case R.id.tvAllCollection:
                Intent intent2 = new Intent(getApplicationContext(), CollectionDetailActivity.class);
                intent2.putExtra("collectionList", (Serializable) collectionList);
                startActivity(intent2);
                break;
            case R.id.tvAllEdShop:
                Intent intent3 = new Intent(getApplicationContext(), EditorShopDetailActivity.class);
                intent3.putExtra("shopList", (Serializable) shopList);
                startActivity(intent3);
                break;
            case R.id.tvNewShop:
                Intent intent4 = new Intent(getApplicationContext(), NewShopDetailActivity.class);
                intent4.putExtra("newshopList", (Serializable) newShopList);
                startActivity(intent4);
                break;
            case R.id.searchBar:
                speechRecognizer.startListening(speechRecognizerIntent);
                break;
        }
    }

    @Override
    public void onReadyForSpeech(Bundle params) {

    }

    @Override
    public void onBeginningOfSpeech() {
        searchBar.setText("");
        searchBar.setHint("Listening...");
    }

    @Override
    public void onRmsChanged(float rmsdB) {

    }

    @Override
    public void onBufferReceived(byte[] buffer) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int error) {

    }

    @Override
    public void onResults(Bundle results) {
        ArrayList<String> data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        searchBar.setText(data.get(0));
    }

    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        speechRecognizer.startListening(speechRecognizerIntent);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        speechRecognizer.startListening(speechRecognizerIntent);
    }

    @Override
    public void afterTextChanged(Editable s) {
        speechRecognizer.stopListening();
    }

    @Override
    public void onIndicatorClicked(int position) {

    }
}
