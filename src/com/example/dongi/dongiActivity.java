package com.example.dongi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class dongiActivity extends Activity {
    String[] items={"ice-cream","hot chocolate","cake","coffee","nescafe","cheese cake","water"};
    String[] tedad={"1","2","3","4","5","6","7"};
    String[] gheimat={"1000","2000","3000","4000","5000","6000","7000"};
    @Override
    public void onCreate(Bundle bdl) {
        super.onCreate(bdl);
        setContentView(R.layout.main);
        adapterActivity adapter = new adapterActivity(this, items, tedad, gheimat);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        Button btn = (Button) findViewById(R.id.takePic);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
    }

    public void btnAddClickHandler(View view) {
        Intent intent = new Intent(this, changeOrAddFoodActivity.class);
        startActivity(intent);
//        if (getIntent()!= null) {
//            Bundle extras = getIntent().getExtras();
//            if (extras != null) {
//                ((TextView) findViewById(R.id.foodName)).setText(extras.getString("nameBack"));
//                ((TextView) findViewById(R.id.foodQty)).setText(extras.getString("qtyBack"));
//                ((TextView) findViewById(R.id.foodPrice)).setText(extras.getString("priceBack"));
//            }
//        }

    }
    public void btnSelectContact(View view) {
        Intent intent = new Intent(this, contactsActivity.class);
        startActivity(intent);
    }
    public void editButtonClickHandler(View view) {
        Intent intent = new Intent(this, changeOrAddFoodActivity.class);
        intent.putExtra("name", (String)view.getTag(R.string.name));
        intent.putExtra("qty", (String)view.getTag(R.string.qty));
        intent.putExtra("price", (String) view.getTag(R.string.price));

        startActivity(intent);

//        if (getIntent()!= null) {
//            Bundle extras = getIntent().getExtras();
//            if (extras != null) {
//                ((TextView) findViewById(R.id.foodName)).setText(extras.getString("nameBack"));
//                ((TextView) findViewById(R.id.foodQty)).setText(extras.getString("qtyBack"));
//                ((TextView) findViewById(R.id.foodPrice)).setText(extras.getString("priceBack"));
//            }
//        }
    }
}
