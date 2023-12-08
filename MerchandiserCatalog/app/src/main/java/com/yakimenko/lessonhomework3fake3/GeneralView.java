package com.yakimenko.lessonhomework3fake3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GeneralView extends AppCompatActivity {

    private ArrayList<Provider> providerArrayList;
    private AddProvider addProvider;
    private ProviderAdapter providerAdapter;
    private RecyclerView providersRV;

    private ArrayList<Product> productArrayList;
    private AddProduct addProduct;
    private ProductAdapter productAdapter;
    private RecyclerView productsRV;


    private ArrayList<Store> storeArrayList;
    private AddStore addStore;
    private StoreAdapter storeAdapter;
    private RecyclerView storesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provider_view);

        providerArrayList = new ArrayList<>();
        addProvider = new AddProvider(GeneralView.this);

        providerArrayList = addProvider.readProviders();

        providerAdapter = new ProviderAdapter(providerArrayList, GeneralView.this);
        providersRV = findViewById(R.id.idRVProvider);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GeneralView.this, RecyclerView.VERTICAL, false);
        providersRV.setLayoutManager(linearLayoutManager);

        providersRV.setAdapter(providerAdapter);


        productArrayList = new ArrayList<>();
        addProduct = new AddProduct(GeneralView.this);

        productArrayList = addProduct.readProducts();

        productAdapter = new ProductAdapter(productArrayList, GeneralView.this);
        productsRV = findViewById(R.id.idRVProduct);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(GeneralView.this, RecyclerView.VERTICAL, false);
        productsRV.setLayoutManager(linearLayoutManager1);

        productsRV.setAdapter(productAdapter);


        storeArrayList = new ArrayList<>();
        addStore = new AddStore(GeneralView.this);

        storeArrayList = addStore.readStores();

        storeAdapter = new StoreAdapter(storeArrayList, GeneralView.this);
        storesRV = findViewById(R.id.idRVStore);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(GeneralView.this, RecyclerView.VERTICAL, false);
        storesRV.setLayoutManager(linearLayoutManager2);

        storesRV.setAdapter(storeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.provider: {
                Intent i = new Intent(GeneralView.this, AddProviderActivity.class);
                startActivity(i);
            }
                return true;
            case R.id.product: {
                Intent i = new Intent(GeneralView.this, AddProductActivity.class);
                startActivity(i);
            }
                return true;
            case R.id.store: {
                Intent i = new Intent(GeneralView.this, AddStoreActivity.class);
                startActivity(i);
            }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
