package com.example.dongi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

public class changeOrAddFoodActivity extends Activity {
        boolean check=true;
        @Override
        public void onCreate(Bundle bdl){
            super.onCreate(bdl);
            setContentView(R.layout.changedata);
            if (getIntent()!= null) {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    ((EditText) findViewById(R.id.NameAddEditFood)).setText(extras.getString("name"));
                    ((EditText) findViewById(R.id.qtyAddEditFood)).setText(extras.getString("qty"));
                    ((EditText) findViewById(R.id.priceAddEditFood)).setText(extras.getString("price"));
                }
            }
            Button btn=(Button) findViewById(R.id.btnTaeedAddEditFood);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText txtName = (EditText) findViewById(R.id.NameAddEditFood);
                    String strUserName = txtName.getText().toString();

                    if(TextUtils.isEmpty(strUserName)) {
                        txtName.setError("yadet rafte begi chi khordi!");
                        check=false;
                        return;
                    }
                    EditText txtNum = (EditText) findViewById(R.id.qtyAddEditFood);
                    String strNum = txtNum.getText().toString();

                    if(TextUtils.isEmpty(strNum)) {
                        txtNum.setError("yadet rafte begi chanta bude!");
                        check=false;
                        return;
                    }
                    EditText txtAmount = (EditText) findViewById(R.id.priceAddEditFood);
                    String strAmount = txtAmount.getText().toString();

                    if(TextUtils.isEmpty(strAmount)) {
                        txtAmount.setError("yadet rafte begi chand shode!");
                        check=false;
                        return;
                    }
                    if(check==true){
//                        public void btnBackClickHandler(View view) {
//                            Intent intent = new Intent(this, dongiActivity.class);
//                            intent.putExtra("nameBack", (String)view.getTag(R.string.name));
//                            intent.putExtra("qtyBack", (String)view.getTag(R.string.qty));
//                            intent.putExtra("priceBack", (String) view.getTag(R.string.price));
//
//                            startActivity(intent);
//                        }
                    }
                }
            });

        }
        public void btnBackToFoodList(View view) {
            finish();
        }
}
