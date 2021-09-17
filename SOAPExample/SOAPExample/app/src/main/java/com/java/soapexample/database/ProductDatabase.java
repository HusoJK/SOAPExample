package com.java.soapexample.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.java.soapexample.model.Response;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "product";
    private static final String TABLE_PRODUCT = "products";
    private static final String ID = "id";
    private static final String BARCODE = "barcode";
    private static final String NAME = "name";
    private static final String UNIT_NAME = "unit_name";
    private static final String TAX_INCLUDED = "saleis_taxincluded";
    private static final String PURCHASE_PRICE = "purchaseprice";
    private static final String CURRENCY_CODE = "purchasecurrency_code";

    public ProductDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE "
                + TABLE_PRODUCT + "("
                + ID + " INTEGER PRIMARY KEY,"
                + NAME + " TEXT,"
                + PURCHASE_PRICE + " TEXT,"
                + BARCODE + " TEXT,"
                + UNIT_NAME + " TEXT,"
                + TAX_INCLUDED + " TEXT,"
                + CURRENCY_CODE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }

    public void add(Response contact) {
        if(!isRecordExistInDatabase(contact.getBarcode())){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(NAME, contact.getName());
            values.put(PURCHASE_PRICE, contact.getPurchaseprice());
            values.put(BARCODE, contact.getBarcode());
            values.put(UNIT_NAME, contact.getUnit_name());
            values.put(TAX_INCLUDED, contact.isPurchaseeis_taxincluded());
            values.put(CURRENCY_CODE, contact.getPurchasecurrency_code());
            db.insert(TABLE_PRODUCT, null, values);
            db.close();
        }
    }

    private boolean isRecordExistInDatabase(String value) {
        String query = "SELECT * FROM " + TABLE_PRODUCT + " WHERE " + BARCODE + " = '" + value + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            c.close();
            return true;
        }
        c.close();
        return false;
    }

    public List<Response> getAll() {
        List<Response> responseList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Response response = new Response(
                        cursor.getInt(0),
                        cursor.getString(1),
                        Double.parseDouble(cursor.getString(2)),
                        cursor.getString(3),
                        cursor.getString(4),
                        Boolean.parseBoolean(cursor.getString(5)),
                        cursor.getString(6)
                );
                responseList.add(response);
            } while (cursor.moveToNext());
        }
        return responseList;
    }

    public void delete(Response response) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCT, ID + " = ?",
                new String[] { String.valueOf(response.getId()) });
        db.close();
    }

}
