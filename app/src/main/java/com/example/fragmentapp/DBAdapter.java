package com.example.fragmentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Timestamp;

public class DBAdapter {

    static final String key_rowId = "_id";
    static final String key_title = "title";
    static final String key_detail = "detail";
    static final String key_level = "level";
    static final String key_deadline = "deadline";
    static final String tag = "DBAdapter";
    static final String database_name = "TaskDB";
    static final String database_table = "tasks";
    static final int database_v = 1;
    static final String database_cr =
            "create table tasks (_id integer primary key autoincrement, " +
                    "title text not null, detail text not null, level text not null, deadline timestamp not null);";
    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    public DBAdapter(Context context) {
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context context){
            super(context, database_name, null,database_v);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(database_cr);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(tag, "Upgrading database from version " + oldVersion + " to " + newVersion
            + " ,which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS tasks");
            onCreate(db);
        }
    }
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        DBHelper.close();
    }
    public long insertTask(String title, String detail, String level, Timestamp deadline){
        ContentValues initialValues = new ContentValues();
        initialValues.put(key_title, title);
        initialValues.put(key_detail, detail);
        initialValues.put(key_level, level);
        initialValues.put(key_deadline, deadline.toString());
        return  db.insert(database_table, null, initialValues);
    }
    public boolean deleteTask(long rowId){
        return db.delete(database_table, key_rowId + "=" + rowId, null) > 0;
    }
    public Cursor getAllTask(){
        return db.query(database_table, new String[] {key_rowId, key_title, key_detail, key_level, key_deadline},
                null, null, null, null, null);
    }
    public Cursor getTask(long rowId) throws SQLException{
        Cursor mCursor = db.query(true, database_table, new String[] {key_rowId, key_title, key_detail, key_level, key_deadline}, key_rowId + "=" + rowId,
                null, null, null, null, null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateContact(long rowId, String title, String detail, String level, Timestamp deadline){
        ContentValues updateValue = new ContentValues();
        updateValue.put(key_title, title);
        updateValue.put(key_detail, detail);
        updateValue.put(key_level, level);
        updateValue.put(key_deadline, deadline.toString());
        return db.update(database_table, updateValue, key_rowId + "=" + rowId, null) > 0;
    }
}
