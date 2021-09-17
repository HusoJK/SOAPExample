package com.java.soapexample.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.java.soapexample.R;
import com.java.soapexample.model.Response;

public class ProductDetailActivity extends AppCompatActivity {
    private Response response;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        retrieveResponse();
        initializeViews();
    }

    private void initializeViews() {
        TextView name = findViewById(R.id.textProductName);
        TextView saleprice = findViewById(R.id.saleprice);
        TextView barcode = findViewById(R.id.barcode);
        TextView saleis_taxincluded = findViewById(R.id.saleis_taxincluded);
        TextView purchaseprice = findViewById(R.id.purchaseprice);
        TextView purchasecurrency_code = findViewById(R.id.purchasecurrency_code);

        name.setText(response.getName());
        saleprice.setText(String.valueOf(response.getSaleprice()));
        barcode.setText(response.getBarcode());
        saleis_taxincluded.setText(String.valueOf(response.isSaleis_taxincluded()));
        purchaseprice.setText(String.valueOf(response.getPurchaseprice()));
        purchasecurrency_code.setText(response.getPurchase_recommendedcurrency_code());
    }

    private void retrieveResponse() {
        response = (Response) this.getIntent().getSerializableExtra("ProductDetail");
    }
}
