package com.example.dongi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class ContactsActivity extends Activity{

    ArrayList<NumberPicker> pickers;
    @Override
    public void onCreate(Bundle bdl){
        super.onCreate(bdl);

        setContentView(R.layout.contact);
        ActionBar actionBar=getActionBar();
        LayoutInflater inflater=getLayoutInflater();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        View actionbar_view=inflater.inflate(R.layout.actionbar_layout, null);
        actionBar.setCustomView(actionbar_view);
        actionBar.setDisplayShowCustomEnabled(true);
<<<<<<< HEAD
//        View rootView = inflater.inflate(R.layout.contact, container, false);
//        NumberPickerCustom np = (NumberPickerCustom) NumberPickerCustom.findViewById(R.id.numberPicker1);
//        np.setOnValueChangedListener(this);
=======
>>>>>>> 916b38b8dcccb07a54b710d2f32f759e3ae721b1

        pickers = new ArrayList<NumberPicker>();
        final RelativeLayout formLayout = (RelativeLayout)findViewById(R.id.layout);
        NumberPicker picker = new NumberPicker(getApplicationContext());
        pickers.add(picker);
        picker.setId(pickers.size());
        picker.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        formLayout.addView(picker);
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if (newVal > oldVal) {
//                    if(picker.getId()>pickers.size()){
//                        picker.
//                    }
                }
                if (newVal < oldVal) {
                    Bundle extras = getIntent().getExtras();
                    picker = new NumberPicker(getApplicationContext());
                    pickers.add(picker);
                    picker.setId(pickers.size());
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, picker.getId()-1);
                    picker.setLayoutParams(params);
                    picker.setValue(oldVal - newVal);
                    picker.setMaxValue(Integer.valueOf(extras.getString("qtyFirst")));
                    formLayout.addView(picker);
                }
            }
        });




        if (getIntent()!= null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                for (int i = 0; i < pickers.size();i++) {
                    pickers.get(i).setMaxValue(Integer.valueOf(extras.getString("qtyFirst")));
                    if(i==0)
                    {
                        pickers.get(i).setValue(Integer.valueOf(extras.getString("qtyFirst")));
                    }
                }
            }
        }
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
