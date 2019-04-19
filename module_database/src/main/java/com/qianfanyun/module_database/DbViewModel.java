package com.qianfanyun.module_database;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.qianfanyun.module_base.base.BaseViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

/**
 * @author ArcherYc
 * @date on 2019/4/19  09:39
 * @mail 247067345@qq.com
 */
public class DbViewModel extends BaseViewModel {

    public final MutableLiveData<String> console = new MutableLiveData<>();
    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DbViewModel(@NonNull Application application) {
        super(application);
        dbHelper = new DbHelper(application, "test");
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void insert() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", 1);
        contentValues.put("name", "yc");

        sqLiteDatabase.insert("person", "", contentValues);
    }

    public void update() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "dyx");
        contentValues.put("address", "zhuhai");
        sqLiteDatabase.update("person", contentValues, "id=?", new String[]{"1"});
    }

    public void delete() {
        sqLiteDatabase.delete("person", "id=?", new String[]{"1"});
    }

    public void rawQuery() {
        Cursor cursor = sqLiteDatabase.rawQuery("select * from person where id=?", new String[]{"1"});
        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String str = "name-->" + name + "\n" + "address-->" + address;
            console.setValue(str);
        }

        cursor.close();
    }

    public void query() {
        Cursor cursor = sqLiteDatabase.query("person", new String[]{"id", "name", "address"},
                "id=?", new String[]{"1"}, null, null, null);
        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String str = "name-->" + name + "\n" + "address-->" + address;
            console.setValue(str);
        }

        cursor.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sqLiteDatabase.close();
    }
}
