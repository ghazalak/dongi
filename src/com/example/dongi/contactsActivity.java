package com.example.dongi;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class contactsActivity extends Activity{
NumberPicker.
//    Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

//    if (cursor != null) {
//        while(cursor.moveToNext()) {
//            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//        }
//    }
    @Override
    public void onCreate(Bundle bdl){
        super.onCreate(bdl);
        setContentView(R.layout.contact);
    }
}
