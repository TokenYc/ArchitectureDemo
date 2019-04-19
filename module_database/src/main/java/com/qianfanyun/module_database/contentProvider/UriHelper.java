package com.qianfanyun.module_database.contentProvider;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author ArcherYc
 * @date on 2019/4/19  13:41
 * @mail 247067345@qq.com
 */
public class UriHelper {
    public static final String AUTHOR = "com.qianfanyun.module_database";

    public static final String PERSON_PATH = "person";

    public static final Uri BASE_URI = Uri.parse("content://" + AUTHOR);

    public static class PersonEntry implements BaseColumns {

        public static final Uri personUri = BASE_URI.buildUpon().appendPath(PERSON_PATH).build();

        public static Uri buildUri(long id) {
            return ContentUris.withAppendedId(personUri, id);
        }
    }
}
