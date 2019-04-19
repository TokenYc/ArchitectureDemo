package com.qianfanyun.module_database.contentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.qianfanyun.module_database.DbHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author ArcherYc
 * @date on 2019/4/19  13:55
 * @mail 247067345@qq.com
 */
public class PersonProvider extends ContentProvider {

    private static final int PERSON = 1;

    DbHelper dbHelper;

    private UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(UriHelper.AUTHOR, UriHelper.PERSON_PATH, PERSON);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DbHelper(getContext(), "test");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (buildUriMatcher().match(uri)) {
            case PERSON:
                cursor = sqLiteDatabase.query("person", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        switch (buildUriMatcher().match(uri)) {
            case PERSON:
                long id_ = sqLiteDatabase.insert("person", null, values);
                return UriHelper.PersonEntry.buildUri(id_);
            default:
                break;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }


}
