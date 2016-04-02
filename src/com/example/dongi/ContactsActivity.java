package com.example.dongi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
                if (newVal < oldVal)
                {
                    if(picker.getId()<pickers.size())
                    {
                        int c=picker.getId()+1;
                        pickers.get(c).setValue(pickers.get(c).getValue()+1);
                    }else
                    {
                        Bundle extras = getIntent().getExtras();
                        picker = new NumberPicker(getApplicationContext());
                        pickers.add(picker);
                        picker.setId(pickers.size()-1);
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.BELOW, picker.getId());
                        picker.setLayoutParams(params);
//                        int d=(picker.getId())-1;
//                        int e=pickers.get(d).getValue();
                        picker.setValue(1);
                        //  picker.setValue(picker.getValue(picker.getId()-1));
                        picker.setMaxValue(Integer.valueOf(extras.getString("qtyFirst")));
                        picker.setMinValue(1);
                        formLayout.addView(picker);
                    }
                }
                if (newVal > oldVal) {
                    if(picker.getId()>pickers.size()){
                        int a=(picker.getId())+1;
                        pickers.get(a).setValue(pickers.get(a).getValue()-1);
                    }
                    else if(picker.getId()==0)
                    {
                        Toast.makeText(getApplicationContext(),"wrong number",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        int b = picker.getId()-1;
                        pickers.get(b).setValue(pickers.get(b).getValue()-1);
                    }

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
