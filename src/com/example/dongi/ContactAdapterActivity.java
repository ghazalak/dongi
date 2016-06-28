package com.example.dongi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
/**
 * Created by ghazal on 6/27/2016.
 */
public class ContactAdapterActivity extends ArrayAdapter {
    public Model[] modelItems = null;
    Context context;

    public ContactAdapterActivity(Context context, Model[] resource) {
        super(context, R.layout.check_layout, resource);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.modelItems = resource;

        //CheckBox cb = (CheckBox) context.get.findViewById(R.id.checkBox1);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.check_layout, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        name.setText(modelItems[position].getName());
        if (modelItems[position].getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);
        cb.setOnClickListener(null);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelItems[position].value = 1 - modelItems[position].value;
            }
        });
        return convertView;
    }


}
