package com.yakimenko.lessonhomework3fake3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class AddProduct extends SQLiteOpenHelper {
    private static final String DB_NAME = "product4";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "product";
    private static final String ID_PRODUCT = "id";
    private static final String NAME_PRODUCT = "name";
    private static final String TYPE_PRODUCT = "type";
    private static final String PROVIDER_PRODUCT = "provider";
    private static final String STORE_PRODUCT = "store";

    public AddProduct(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public AddProduct(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AddProduct(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public AddProduct(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_PRODUCT + " TEXT,"
                + TYPE_PRODUCT + " TEXT,"
                + PROVIDER_PRODUCT + " TEXT,"
                + STORE_PRODUCT + " TEXT)";

        db.execSQL(query);
    }

    public void addProduct(String name, String type, String provider, String store) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_PRODUCT, name);
        values.put(TYPE_PRODUCT, type);
        values.put(PROVIDER_PRODUCT, provider);
        values.put(STORE_PRODUCT, store);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }
    public ArrayList<Product> readProducts() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorProducts = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Product> productsArrayList = new ArrayList<>();

        if (cursorProducts.moveToFirst()) {
            do {

                productsArrayList.add(new Product(cursorProducts.getString(4), cursorProducts.getString(3),
                        cursorProducts.getString(2),
                        cursorProducts.getString(1)));
            } while (cursorProducts.moveToNext());

        }

        cursorProducts.close();
        return productsArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}