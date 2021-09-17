package com.java.soapexample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.java.soapexample.R;
import com.java.soapexample.database.ProductDatabase;
import com.java.soapexample.listener.ItemSelectedListener;
import com.java.soapexample.model.Response;
import com.java.soapexample.ui.adapter.ProductAdapter;

import java.util.List;

public class ProductListActivity extends AppCompatActivity implements ItemSelectedListener {
    private ProductDatabase productDatabase = new ProductDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getDBResults();
    }

    private void getDBResults() {
        List<Response> list = productDatabase.getAll();
        updateUI(list);
    }

    private void updateUI(List<Response> product){
        if (product != null) {
            ProductAdapter productAdapter = new ProductAdapter(product, this);
            RecyclerView recyclerView = findViewById(R.id.rv_product);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(productAdapter);
        }
    }

    @Override
    public void onItemSelected(Response response) {
        startActivity(new Intent(this, ProductDetailActivity.class).putExtra("ProductDetail", response));
    }

    @Override
    public void onItemDeleted(Response response) {
        productDatabase.delete(response);
        Toast.makeText(this,response.getName() + " silindi.",Toast.LENGTH_LONG).show();
    }
}
