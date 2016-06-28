package com.example.dongi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ContactsActivity extends Activity {
    ListView lv;
    int position;
    static ArrayList<String> names = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (names.size() == 0)
        {
            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
            while (phones.moveToNext()) {
                String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                if (!names.contains(name))
                    names.add(name);
            }
            phones.close();
        }
        setContentView(R.layout.contact);
        lv = (ListView) findViewById(R.id.listView1);
        Bundle extras = getIntent().getExtras();
        position = extras.getInt("position");
        ArrayList<String> persons = new ArrayList<String>(Arrays.asList(extras.getStringArray("persons")));

        ArrayList<Model> modelItems = new ArrayList<Model>();
        for(int i = 0; i< names.size();i++) {
            String name = names.get(i);
            int selected = 0;
            if (persons.contains(name)) {
                selected = 1;
            }
            modelItems.add(new Model(name, selected));

        }

        ContactAdapterActivity adapter = new ContactAdapterActivity(this, modelItems.toArray(new Model[0]));
        lv.setAdapter(adapter);



        ActionBar actionBar = getActionBar();
        LayoutInflater inflater = getLayoutInflater();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        View actionbar_view = inflater.inflate(R.layout.actionbar_layout, null);
        actionBar.setCustomView(actionbar_view);
        actionBar.setDisplayShowCustomEnabled(true);

        Button btn=(Button) findViewById(R.id.btnTaeedAddEditFood);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                Model[] modelItems = ((ContactAdapterActivity) lv.getAdapter()).modelItems;
                ArrayList<String> persons = new ArrayList<String>();
                for (int i = 0; i < modelItems.length; i++) {
                    Model m = modelItems[i];
                    if (m.value == 1) {
                        persons.add(m.name);
                    }
                }
                b.putStringArray("persons", persons.toArray(new String[0]));
                b.putInt("position",position);
                intent.putExtras(b);
                if (getParent() == null) {
                    setResult(DongiActivity.RESULT_OK, intent);
                }
                else {
                    getParent().setResult(DongiActivity.RESULT_OK, intent);
                }
                finish();
            }
        });
        btn=(Button) findViewById(R.id.btnBackAddEditFood);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R., menu);
//        return true;
//    }

//    ArrayList<NumberPicker> pickers;
//    @Override
//    public void onCreate(Bundle bdl){
//        super.onCreate(bdl);

//    setContentView(R.layout.contact);


//        pickers = new ArrayList<NumberPicker>();
//        final RelativeLayout formLayout = (RelativeLayout)findViewById(R.id.layout);
//        NumberPicker picker = new NumberPicker(getApplicationContext());
//        pickers.add(picker);
//        picker.setId(pickers.size());
//        picker.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
//        formLayout.addView(picker);
//        picker.setOnValueChangedListener(onValueChangeHandler);
//        if (getIntent()!= null) {
//            Bundle extras = getIntent().getExtras();
//            if (extras != null) {
//                picker.setMinValue(1);
//                picker.setMaxValue(Integer.valueOf(extras.getString("qtyFirst")));
//                picker.setValue(Integer.valueOf(extras.getString("qtyFirst")));
//            }
//        }


//    void reduceNumberPicker(int Id)
//    {
//        final NumberPicker picker = pickers.get(Id - 1);
//        if (picker.getValue() == 1)
//        {
//            final ViewGroup parentView = (ViewGroup) picker.getParent();
//            for (int i = Id ; i < pickers.size();i++)
//            {
//                pickers.get(i).setId(i );
//                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//                params.addRule(RelativeLayout.BELOW, pickers.get(i).getId() - 1);
//                pickers.get(i).setLayoutParams(params);
//            }
//
//            parentView.post(new Runnable() {
//                public void run() {
//                    parentView.removeView(picker);
//                }
//            });
//            pickers.remove(Id - 1);
//        }
//        else
//        {
//            picker.setValue(picker.getValue() - 1);
//        }
//    }

//    NumberPicker.OnValueChangeListener onValueChangeHandler = new NumberPicker.OnValueChangeListener() {
//        @Override
//        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//            if (Math.abs(oldVal - newVal) > 1) {
//                picker.setOnValueChangedListener(null);
//                picker.setValue(oldVal);
//                picker.setOnValueChangedListener(onValueChangeHandler);
//                return;
//            }
//            final RelativeLayout formLayout = (RelativeLayout)findViewById(R.id.layout);
//            if (newVal < oldVal)
//            {
//                if(picker.getId()< pickers.size())
//                {
//                    int c = picker.getId() ;
//                    pickers.get(c).setValue(pickers.get(c).getValue()+ oldVal - newVal);
//                }else
//                {
//                    Bundle extras = getIntent().getExtras();
//                    picker = new NumberPicker(getApplicationContext());
//                    pickers.add(picker);
//                    picker.setId(pickers.size());
//                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//                    params.addRule(RelativeLayout.BELOW, picker.getId() - 1);
//                    picker.setLayoutParams(params);
//
//                    picker.setMaxValue(Integer.valueOf(extras.getString("qtyFirst")));
//                    picker.setMinValue(1);
//                    picker.setValue(oldVal - newVal);
//                    formLayout.addView(picker);
//                    picker.setOnValueChangedListener(onValueChangeHandler);
//                }
//            }
//            if (newVal > oldVal) {
//                int pickerId = picker.getId();
//                if(pickerId >= pickers.size()){
//                    reduceNumberPicker(pickerId - 1);
//                }
//                else if(picker.getId()==0)
//                {
//                    Toast.makeText(getApplicationContext(),"wrong number",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    reduceNumberPicker(pickerId + 1);
//                }
//
//            }
//        }
//    };
    //    @Override
//    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//        Toast.makeText(ContactsActivity.this, "number", Toast.LENGTH_SHORT).show();
//    }
}
