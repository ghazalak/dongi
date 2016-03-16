package com.example.dongi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class DongiActivity extends Activity {
    static  ArrayList<String> items = new ArrayList<String>();
    static  ArrayList<String> qtys = new ArrayList<String>();
    static  ArrayList<String> prices = new ArrayList<String>();
    final Context context=this;
    @Override
    public void onCreate(Bundle bdl) {
        super.onCreate(bdl);
        setContentView(R.layout.main);
        AdapterActivity adapter = new AdapterActivity(this, items, qtys, prices);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

//actionBar
//        ActionBar actionBar=getActionBar();
//        LayoutInflater inflater=getLayoutInflater();
//        actionBar.setDisplayShowHomeEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(false);
//        View actionbar_view=inflater.inflate(R.layout.actionbar_layout,null);
//        actionBar.setCustomView(actionbar_view);
//        actionBar.setDisplayShowCustomEnabled(true);



        Button btn = (Button) findViewById(R.id.takePic);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
//        Button btnAdd=(Button)findViewById(R.id.goToAddFoodRow);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Dialog dialog=new Dialog(context);
//                dialog.setContentView(R.layout.changedata);
//                dialog.setTitle("���� �������");
//
//
//            }
//        });
//        Toast.makeText(getApplicationContext(), "Your toast message",
//                Toast.LENGTH_LONG).show();
    }
    public void btnAddClickHandler(View view) {
        Intent intent = new Intent(this, ChangeOrAddFoodActivity.class);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();

        if (resultCode == DongiActivity.RESULT_OK) {
            if (requestCode == 1) {
                items.add(data.getStringExtra("nameBack"));
                qtys.add(data.getStringExtra(("qtyBack")));
                prices.add(data.getStringExtra("priceBack"));

            } else if (requestCode == 2) {
                int position = Integer.valueOf(data.getStringExtra("position"));
                items.set(position, data.getStringExtra("nameBack"));
                qtys.set(position, data.getStringExtra(("qtyBack")));
                prices.set(position, data.getStringExtra("priceBack"));
            }
            AdapterActivity adapter = new AdapterActivity(this, items, qtys, prices);
            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
        if (resultCode == DongiActivity.RESULT_CANCELED) {
            //Write your code if there's no result
//                Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_LONG).show();
        }
    }
    public void btnSelectContact(View view) {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
    public void editButtonClickHandler(View view) {
        Intent intent = new Intent(this, ChangeOrAddFoodActivity.class);
        intent.putExtra("name", (String)view.getTag(R.string.name));
        String s = (String) view.getTag(R.string.position);
        intent.putExtra("position", (String) view.getTag(R.string.position));
        intent.putExtra("qty", (String)view.getTag(R.string.qty));
        intent.putExtra("price", (String) view.getTag(R.string.price));
        startActivityForResult(intent,2);
    }
}