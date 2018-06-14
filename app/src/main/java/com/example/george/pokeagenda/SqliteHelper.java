package com.example.george.pokeagenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by George on 6/13/2018.
 */

public class SqliteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PokeAgendaDB";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";

    public static final String USER_ID = "id";

    public static final String USER_USERNAME = "username";

    public static final String USER_PASSWORD = "password";

    public static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_USERS +
            " ( " + USER_ID + "integer primary key autoincrement, "
            + USER_USERNAME + "text"
            + USER_PASSWORD + "text" + " ) ";

    public SqliteHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USER_USERNAME, user.username);
        values.put(USER_PASSWORD, user.password);

        long insert = db.insert(TABLE_USERS,null, values);
    }

    public User Login(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{USER_ID, USER_USERNAME, USER_PASSWORD},
                USER_USERNAME + "=?", new String[]{user.username}, null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            User valido = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2));

            if (user.password.equalsIgnoreCase(valido.password)) {
                return valido;
            }
        }
        return null;
    }
}
