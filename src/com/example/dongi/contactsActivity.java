package com.example.dongi;

import android.app.Activity;
import android.database.Cursor;
import android.provider.ContactsContract;

public class contactsActivity extends Activity{

    Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

//    if (cursor != null) {
//        while(cursor.moveToNext()) {
//            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//
//        }
//    }
}
