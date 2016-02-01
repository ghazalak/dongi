package com.example.dongi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by ghazal on 1/30/2016.
 */
public class listActivity extends Activity {
    String[] items={"ice-cream","hot chocolate","cake","coffee","nescafe","cheese cake","water"};
    String[] tedad={"1","2","3","4","5","6","7"};
    String[] gheimat={"1000","2000","3000","4000","5000","6000","7000"};
    @Override
    public void onCreate(Bundle bdl) {
        super.onCreate(bdl);
        setContentView(R.layout.main);
        adaptorActivity adapter = new adaptorActivity(this, items, tedad, gheimat);
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
    public void btn1(View view) {
        Intent intent = new Intent(this, dataActivity.class);
        startActivity(intent);
    }
    public void editButtonClickHandler(View view) {
        Intent intent = new Intent(this, changedataActivity.class);
        intent.putExtra("name", (String)view.getTag(R.string.name));
        intent.putExtra("qty", (String)view.getTag(R.string.qty));
        intent.putExtra("price", (String)view.getTag(R.string.price));

        startActivity(intent);

    }
}
