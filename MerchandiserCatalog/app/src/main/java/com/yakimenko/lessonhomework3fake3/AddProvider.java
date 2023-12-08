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

public class AddProvider extends SQLiteOpenHelper {
    private static final String DB_NAME = "provider4";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "provider";
    private static final String ID_PROVIDER = "id";
    private static final String NAME_PROVIDER = "name";
    private static final String ADDRESS_PROVIDER = "address";
    public AddProvider(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public AddProvider(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AddProvider(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public AddProvider(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_PROVIDER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_PROVIDER + " TEXT,"
                + ADDRESS_PROVIDER + " TEXT)";

        db.execSQL(query);
    }

    public void addProvider(String name, String address) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_PROVIDER, name);
        values.put(ADDRESS_PROVIDER, address);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }
    public ArrayList<Provider> readProviders() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorProviders = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Provider> providerArrayList = new ArrayList<>();

        if (cursorProviders.moveToFirst()) {
            do {

                providerArrayList.add(new Provider(cursorProviders.getString(2),
                        cursorProviders.getString(1)));
            } while (cursorProviders.moveToNext());

        }

        cursorProviders.close();
        return providerArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}