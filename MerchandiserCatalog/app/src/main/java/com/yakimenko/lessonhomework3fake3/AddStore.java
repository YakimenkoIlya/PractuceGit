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

public class AddStore extends SQLiteOpenHelper {
    private static final String DB_NAME = "store4";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "store";
    private static final String ID_STORE = "id";
    private static final String NAME_STORE = "name";
    private static final String ADDRESS_STORE = "address";
    public AddStore(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public AddStore(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AddStore(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public AddStore(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_STORE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_STORE + " TEXT,"
                + ADDRESS_STORE + " TEXT)";

        db.execSQL(query);
    }

    public void addStore(String name, String address) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_STORE, name);
        values.put(ADDRESS_STORE, address);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }
    public ArrayList<Store> readStores() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorStores = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Store> storeArrayList = new ArrayList<>();

        if (cursorStores.moveToFirst()) {
            do {

                storeArrayList.add(new Store(cursorStores.getString(2),
                        cursorStores.getString(1)));
            } while (cursorStores.moveToNext());

        }

        cursorStores.close();
        return storeArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}