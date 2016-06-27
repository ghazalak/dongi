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
    static ArrayList<Food> foods;
    public AdapterActivity(Context context, ArrayList<Food> foods){
        super(context,R.layout.list_row);
        maincontext = context;
        this.foods = foods;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return foods.size();///////return size of list
    }

//    @Override
//    public Food getItem(int position) {
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

        View row = layoutInflater.inflate(R.layout.list_row, null, true);
        TextView textView = (TextView) row.findViewById(R.id.foodName);
        TextView textView1 = (TextView) row.findViewById(R.id.foodQty);
        TextView textView2 = (TextView) row.findViewById(R.id.foodPrice);
        Button edit = (Button) row.findViewById(R.id.editFoodRow);
        Button selectContact = (Button) row.findViewById(R.id.addContact);
        Food f = foods.get(position);
        textView.setText(f.name);
        textView1.setText(String.valueOf(f.qty));
        textView2.setText(String.valueOf(f.price));

        edit.setTag(R.string.position, String.valueOf(position));
        selectContact.setTag(R.string.position, String.valueOf(position));
        return row;
    }
}
