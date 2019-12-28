package com.example.andrei.physics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

/**
 * Created by Andrei on 06.05.2017.
 */

public class DBManager {

    private SQLiteDatabase sqlDB;
    static final String DBName="fizica";
    static final String TableName1="intrebari";
    static final String ColIntrebare="intrebare";
    static final String ColClasa="clasa";
    static final int DBVersion=1;
    static final String TableName2="raspunsuri";
    static final String ColRaspuns="raspuns";
    static final String ColIDIntrebare="id_intrebare";
    static final String ColRaspunsCorect="raspuns_corect";

    static final String CreateTable1="create table if not exists "+TableName1+"(id integer primary key autoincrement,"+ColIntrebare+" text,"+ColClasa+" integer)";
    static final String CreateTable2="create table if not exists "+TableName2+"(id integer primary key autoincrement,"+ColRaspuns+" text, "+ColIDIntrebare+" integer, "+ColRaspunsCorect+" integer)";

    static class DatabaseHelperFizica extends SQLiteOpenHelper
    {
        Context context;
        DatabaseHelperFizica(Context context)
        {
            super(context, DBName, null, DBVersion);
            this.context=context;
        }
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CreateTable1);
            db.execSQL(CreateTable2);
            Toast.makeText(context, "table is created", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("drop table if exists "+TableName1);
            db.execSQL("drop table if exists "+TableName2);
            onCreate(db);
        }
    }
    public DBManager(Context context)
    {
        DatabaseHelperFizica db=new DatabaseHelperFizica(context);
        sqlDB=db.getWritableDatabase();
    }

    public long insert(ContentValues values)
    {
        long ID =sqlDB.insert(TableName1,"",values);
        return ID;
    }
    public long insert2(ContentValues values)
    {
        long ID =sqlDB.insert(TableName2,"",values);
        return ID;
    }
    public Cursor query(String[] Projection, String Selection, String[] SelectionArgs, String SortOrder)
    {
        SQLiteQueryBuilder qb= new SQLiteQueryBuilder();
        qb.setTables(TableName1);
        Cursor cursor=qb.query(sqlDB, Projection,Selection,SelectionArgs,null,null,SortOrder);
        return cursor;
    }
    public Cursor query2(String[] Projection, String Selection, String[] SelectionArgs, String SortOrder)
    {
        SQLiteQueryBuilder qb= new SQLiteQueryBuilder();
        qb.setTables(TableName2);
        Cursor cursor=qb.query(sqlDB, Projection,Selection,SelectionArgs,null,null,SortOrder);

        return cursor;
    }
    public int Delete(String Selection, String[] SelectionArgs)
    {
        int count=sqlDB.delete(TableName1,Selection,SelectionArgs);
        return count;
    }
    public int Delete2(String Selection, String[] SelectionArgs)
    {
        int count=sqlDB.delete(TableName2,Selection,SelectionArgs);
        return count;
    }

}
