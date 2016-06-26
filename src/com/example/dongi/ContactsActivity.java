package com.example.dongi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        picker.setOnValueChangedListener(onValueChangeHandler);
        if (getIntent()!= null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                picker.setMinValue(1);
                picker.setMaxValue(Integer.valueOf(extras.getString("qtyFirst")));
                picker.setValue(Integer.valueOf(extras.getString("qtyFirst")));
            }
        }
    }

    void reduceNumberPicker(int Id)
    {
        final NumberPicker picker = pickers.get(Id - 1);
        if (picker.getValue() == 1)
        {
            final ViewGroup parentView = (ViewGroup) picker.getParent();
            for (int i = Id ; i < pickers.size();i++)
            {
                pickers.get(i).setId(i );
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.BELOW, pickers.get(i).getId() - 1);
                pickers.get(i).setLayoutParams(params);
            }

            parentView.post(new Runnable() {
                public void run() {
                    parentView.removeView(picker);
                }
            });
            pickers.remove(Id - 1);
        }
        else
        {
            picker.setValue(picker.getValue() - 1);
        }
    }

    NumberPicker.OnValueChangeListener onValueChangeHandler = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            if (Math.abs(oldVal - newVal) > 1) {
                picker.setOnValueChangedListener(null);
                picker.setValue(oldVal);
                picker.setOnValueChangedListener(onValueChangeHandler);
                return;
            }
            final RelativeLayout formLayout = (RelativeLayout)findViewById(R.id.layout);
            if (newVal < oldVal)
            {
                if(picker.getId()< pickers.size())
                {
                    int c = picker.getId() ;
                    pickers.get(c).setValue(pickers.get(c).getValue()+ oldVal - newVal);
                }else
                {
                    Bundle extras = getIntent().getExtras();
                    picker = new NumberPicker(getApplicationContext());
                    pickers.add(picker);
                    picker.setId(pickers.size());
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, picker.getId() - 1);
                    picker.setLayoutParams(params);

                    picker.setMaxValue(Integer.valueOf(extras.getString("qtyFirst")));
                    picker.setMinValue(1);
                    picker.setValue(oldVal - newVal);
                    formLayout.addView(picker);
                    picker.setOnValueChangedListener(onValueChangeHandler);
                }
            }
            if (newVal > oldVal) {
                int pickerId = picker.getId();
                if(pickerId >= pickers.size()){
                    reduceNumberPicker(pickerId - 1);
                }
                else if(picker.getId()==0)
                {
                    Toast.makeText(getApplicationContext(),"wrong number",Toast.LENGTH_LONG).show();
                }
                else
                {
                    reduceNumberPicker(pickerId + 1);
                }

            }
        }
    };
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
