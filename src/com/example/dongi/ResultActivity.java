package com.example.dongi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Hashtable;

public class ResultActivity extends Activity {
    @Override
    public void onCreate(Bundle bdl) {
        super.onCreate(bdl);
        setContentView(R.layout.result);
        ArrayList<Food> foods = (ArrayList<Food>) getIntent().getSerializableExtra("foods");
        Hashtable<String, Integer> dongs=new Hashtable<String, Integer>();
        for(Integer i=0; i<foods.size();i++){
            Food food=foods.get(i);
            for(Integer j=0; j<food.persons.size();j++){
                String personName=food.persons.get(j);
                if(!dongs.containsKey(personName)){
                    dongs.put(personName, 0);
                }
                Integer personDong= dongs.get(personName);
                personDong+=food.price*food.qty/food.persons.size();
                dongs.put(personName, personDong);
            }
        }

        ListView listView = (ListView) findViewById(R.id.resultListView);
        listView.setAdapter(new ResultAdapterActivity(this, dongs));

    }

}
