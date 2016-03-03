package com.example.dongi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

public class ContactsActivity extends Activity{
    @Override
    public void onCreate(Bundle bdl){
        super.onCreate(bdl);
        setContentView(R.layout.contact);
        ActionBar actionBar=getActionBar();
        LayoutInflater inflater=getLayoutInflater();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        View actionbar_view=inflater.inflate(R.layout.actionbar_layout,null);
        actionBar.setCustomView(actionbar_view);
        actionBar.setDisplayShowCustomEnabled(true);
//        View rootView = inflater.inflate(R.layout.contact, container, false);
//        NumberPickerCustom np = (NumberPickerCustom) NumberPickerCustom.findViewById(R.id.numberPicker1);
//        np.setOnValueChangedListener(this);

    }
//    @Override
//    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//        Toast.makeText(ContactsActivity.this, "number", Toast.LENGTH_SHORT).show();
//    }
    public void btnBackToFoodList(View view ) {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();

    }
}
