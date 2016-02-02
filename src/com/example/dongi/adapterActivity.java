package com.example.dongi;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class adapterActivity extends ArrayAdapter<String> {
    Context maincontext;
    String[] ArrayName;
    String[] Arrayqty;
    String[] ArrayPrice;
    public adapterActivity(Context context, String[] item, String[] tedad, String[] price){
        super(context,R.layout.list_row,price);
        maincontext = context;
        ArrayName = item;
        Arrayqty =tedad;
        ArrayPrice =price;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(maincontext);

        View row = layoutInflater.inflate(R.layout.list_row, null, true);
        TextView textView = (TextView) row.findViewById(R.id.foodName);
        TextView textView1 = (TextView) row.findViewById(R.id.foodQty);
        TextView textView2 = (TextView) row.findViewById(R.id.foodPrice);
        Button edit = (Button) row.findViewById(R.id.editFoodRow);
        textView.setText(ArrayName[position]);
        textView1.setText(Arrayqty[position]);
        textView2.setText(ArrayPrice[position]);

        edit.setTag(R.string.name, ArrayName[position]);
        edit.setTag(R.string.qty, Arrayqty[position]);
        edit.setTag(R.string.price, ArrayPrice[position]);


//        edit.setTag(R.string.nameBack, ArrayName[position]);
//        edit.setTag(R.string.qtyBack, Arrayqty[position]);
//        edit.setTag(R.string.priceBack, ArrayPrice[position]);

        return row;

    }
}
