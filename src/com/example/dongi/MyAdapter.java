package com.example.dongi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter {
    int qtyFirst;
    Context maincontext;
    public MyAdapter(Context context, int qty) {
        super(context, R.layout.list_row, qty);
        qtyFirst=qty;
    }
    public View getView(View view, ViewGroup viewGroup){
        LayoutInflater layoutInflater = LayoutInflater.from(maincontext);

        View row = layoutInflater.inflate(R.layout.list_row, null, true);
        TextView textView1 = (TextView) row.findViewById(R.id.foodQty);
        Button edit = (Button) row.findViewById(R.id.addContact);
        textView1.setText(qtyFirst);

        edit.setTag(R.string.qty, qtyFirst);
        return row;
    }
}