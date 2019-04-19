package com.qianfanyun.module_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @author ArcherYc
 * @date on 2019/4/19  09:48
 * @mail 247067345@qq.com
 */
public class DbHelper extends SQLiteOpenHelper {

    private static Integer VERSION = 1;

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DbHelper(Context context, String name) {
        super(context, name, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table person(id integer primary key autoincrement,name varchar(64),address varchar(64))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "alter table person add sex varchar(8)";
        db.execSQL(sql);
    }
}
