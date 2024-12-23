package com.example.midterm;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "login.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_LOGIN_TABLE = "CREATE TABLE " +
                DBContract.Login.TABLE_NAME + " (" +
                DBContract.Login.COLUMN_FULLNAME + " TEXT NOT NULL," +
                DBContract.Login.COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                DBContract.Login.COLUMN_PASSWORD + " TEXT NOT NULL," +
                DBContract.Login.COLUMN_MOBILE + " TEXT UNIQUE NOT NULL)";

        db.execSQL(SQL_CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.Login.TABLE_NAME);
        onCreate(db);
    }
    public long insertData(String fullname, String username, String password, String mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.Login.COLUMN_FULLNAME, fullname);
        values.put(DBContract.Login.COLUMN_USERNAME, username);
        values.put(DBContract.Login.COLUMN_PASSWORD, password);
        values.put(DBContract.Login.COLUMN_MOBILE, mobile);

        long newRowId = db.insert(DBContract.Login.TABLE_NAME, null, values);


        return newRowId;
    }
}
