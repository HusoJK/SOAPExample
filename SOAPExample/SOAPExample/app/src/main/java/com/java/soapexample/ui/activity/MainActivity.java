package com.java.soapexample.ui.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.java.soapexample.R;
import com.java.soapexample.database.ProductDatabase;
import com.java.soapexample.model.Product;
import com.java.soapexample.utils.AsyncTasks;
import com.java.soapexample.utils.ParserUtilities;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ProductDatabase productDatabase = new ProductDatabase(this);
    private ParserUtilities parserUtilities = new ParserUtilities();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGet = findViewById(R.id.btnGet);
        Button btnSave = findViewById(R.id.btnSave);
        btnGet.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btnGet:
                getProducts();
                break;
            case R.id.btnSave:
                saveProducts();
                break;
        }
    }

    private void saveProducts() {
        final Product[] product = new Product[1];
        new AsyncTasks() {
            @Override
            public void onPreExecute() {
            }

            @Override
            public void doInBackground() {
                try {
                    product[0] = parserUtilities.getData();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPostExecute() {
                if (product[0] != null) {
                    for (int i = 0; i < product[0].getResponse().size(); i++) {
                        productDatabase.add(product[0].getResponse().get(i));
                    }
                    sendToast(product[0].getResponse().size());
                }
            }
        }.execute();
    }


    private void sendToast(int size) {
        Toast.makeText(this,size + ". Kayıt Eklendi.", Toast.LENGTH_LONG).show();
    }

    private void getProducts() {
        Intent intent = new Intent(this,ProductListActivity.class);
        startActivity(intent);
    }
}
