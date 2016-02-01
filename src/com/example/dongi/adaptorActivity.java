package com.example.dongi;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ghazal on 1/30/2016.
 */
public class adaptorActivity extends ArrayAdapter<String> {
    Context maincontext;
    String[] ArrayName;
    String[] ArrayTedad;
    String[] ArrayPrice;
    public adaptorActivity(Context context, String[] item,String[] tedad,String[] price){
        super(context,R.layout.list_row,price);
        maincontext = context;
        ArrayName = item;
        ArrayTedad =tedad;
        ArrayPrice =price;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(maincontext);

        View row = layoutInflater.inflate(R.layout.list_row, null, true);
        TextView textView = (TextView) row.findViewById(R.id.name);
        TextView textView1 = (TextView) row.findViewById(R.id.num);
        TextView textView2 = (TextView) row.findViewById(R.id.fi);
        Button edit = (Button) row.findViewById(R.id.edit);
        textView.setText(ArrayName[position]);
        textView1.setText(ArrayTedad[position]);
        textView2.setText(ArrayPrice[position]);

        edit.setTag(R.string.name, ArrayName[position]);
        edit.setTag(R.string.qty, ArrayTedad[position]);
        edit.setTag(R.string.price, ArrayPrice[position]);

        return row;

    }
}
