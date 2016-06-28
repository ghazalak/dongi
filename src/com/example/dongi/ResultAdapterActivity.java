package com.example.dongi;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class ResultAdapterActivity extends ArrayAdapter<String> {
    Context maincontext;
    Hashtable<String,Integer> dongs;
    String[] keys;
    public ResultAdapterActivity(Context context, Hashtable<String,Integer> dongs){
        super(context,R.layout.result_list_view);
        maincontext = context;
        this.dongs = dongs;
        keys = dongs.keySet().toArray(new String[dongs.size()]);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dongs.size();///////return size of list
    }

//    @Override
//    public Object getItem(int position) {
//        // TODO Auto-generated method stub
//        return foods.get(position);///// dont return null here
//    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;/////////return position as itemID
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup){
        LayoutInflater layoutInflater = LayoutInflater.from(maincontext);
        View row = layoutInflater.inflate(R.layout.result_list_view, null, true);

        String name = keys[position];
        String dong = dongs.get(name).toString();
        TextView textView = (TextView) row.findViewById(R.id.Name);
        TextView textView1 = (TextView) row.findViewById(R.id.Dong);

        textView.setText(name);
        textView1.setText(dong);
        return row;
    }
}
