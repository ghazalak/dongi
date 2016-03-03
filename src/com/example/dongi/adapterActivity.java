package com.example.dongi;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterActivity extends ArrayAdapter<String> {
    Context maincontext;
    ArrayList<String> ArrayName;
    ArrayList<String> Arrayqty;
    ArrayList<String> ArrayPrice;
    public AdapterActivity(Context context, ArrayList<String> items, ArrayList<String> qtys, ArrayList<String> prices){
        super(context,R.layout.list_row,prices);
        maincontext = context;
        ArrayName = items;
        Arrayqty =qtys;
        ArrayPrice =prices;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup){
        LayoutInflater layoutInflater = LayoutInflater.from(maincontext);

        View row = layoutInflater.inflate(R.layout.list_row, null, true);
        TextView textView = (TextView) row.findViewById(R.id.foodName);
        TextView textView1 = (TextView) row.findViewById(R.id.foodQty);
        TextView textView2 = (TextView) row.findViewById(R.id.foodPrice);
        Button edit = (Button) row.findViewById(R.id.editFoodRow);
        textView.setText(ArrayName.get(position));
        textView1.setText(Arrayqty.get(position));
        textView2.setText(ArrayPrice.get(position));

        edit.setTag(R.string.name, ArrayName.get(position));
        edit.setTag(R.string.qty, Arrayqty.get(position));
        edit.setTag(R.string.price, ArrayPrice.get(position));
        edit.setTag(R.string.position, String.valueOf(position));
        return row;
    }
}
