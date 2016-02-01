package com.example.dongi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.*;

/**
 * Created by ghazal on 1/31/2016.
 */
public class dataActivity extends Activity {
    boolean check=true;
    @Override
    public void onCreate(Bundle bdl){
        super.onCreate(bdl);
        setContentView(R.layout.getdata);

        Button btn=(Button) findViewById(R.id.taeedBTN);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtName = (EditText) findViewById(R.id.editName);
                String strUserName = txtName.getText().toString();

                if(TextUtils.isEmpty(strUserName)) {
                    txtName.setError("yadet rafte begi chi khordi!");
                    check=false;
                    return;
                }
                EditText txtNum = (EditText) findViewById(R.id.editNum);
                String strNum = txtNum.getText().toString();

                if(TextUtils.isEmpty(strNum)) {
                    txtNum.setError("yadet rafte begi chanta bude!");
                    check=false;
                    return;
                }
                EditText txtAmount = (EditText) findViewById(R.id.editAmount);
                String strAmount = txtAmount.getText().toString();

                if(TextUtils.isEmpty(strAmount)) {
                    txtAmount.setError("yadet rafte begi chand shode!");
                    check=false;
                    return;
                }
                txtName.getText();
                if(check){
                  //  TextView txt=(TextView) findViewById(R.id.name);
                   // txtName.setText(R.id.name, null);
                }
            }
        });

    }
    public void btn2(View view) {
        finish();
    }
}
