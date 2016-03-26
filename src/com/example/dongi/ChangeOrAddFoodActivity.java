package com.example.dongi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

public class ChangeOrAddFoodActivity extends Activity {
    boolean nameCheck=true;
    boolean qtyCheck=true;
    boolean priceCheck=true;

    String position;
    @Override
    public void onCreate(Bundle bdl){
        super.onCreate(bdl);
        setContentView(R.layout.changedata);
        ActionBar actionBar=getActionBar();
        LayoutInflater inflater=getLayoutInflater();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        View actionbar_view=inflater.inflate(R.layout.actionbar_layout,null);
        actionBar.setCustomView(actionbar_view);
        actionBar.setDisplayShowCustomEnabled(true);
        if (getIntent()!= null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                ((EditText) findViewById(R.id.NameAddEditFood)).setText(extras.getString("name"));
                ((EditText) findViewById(R.id.qtyAddEditFood)).setText(extras.getString("qty"));
                ((EditText) findViewById(R.id.priceAddEditFood)).setText(extras.getString("price"));
                this.position = extras.getString("position");
            }
        }

        Button btn=(Button) findViewById(R.id.btnTaeedAddEditFood);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtName;
                String strName;
                EditText txtQty ;
                String strQty ;
                EditText txtPrice;
                String strPrice;
                do {
                    txtName = (EditText) findViewById(R.id.NameAddEditFood);
                    strName = txtName.getText().toString();
                    if(TextUtils.isEmpty(strName)) {
                        txtName.setError(":(");
                        nameCheck=false;
                        return;
                    }else nameCheck=true;
                    txtQty = (EditText) findViewById(R.id.qtyAddEditFood);
                    strQty = txtQty.getText().toString();
                    if (TextUtils.isEmpty(strQty)) {
                        txtQty.setError(":(");
                        qtyCheck = false;
                        return;
                    }else qtyCheck=true;
                    txtPrice = (EditText) findViewById(R.id.priceAddEditFood);
                    strPrice = txtPrice.getText().toString();
                    if (TextUtils.isEmpty(strPrice)) {
                        txtPrice.setError(":(");
                        priceCheck = false;
                        return;
                    }else priceCheck=true;
                }
                while (nameCheck==false || qtyCheck==false || priceCheck==false);
                Button btn=(Button) findViewById(R.id.btnTaeedAddEditFood);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText txtName;
                        String strName;
                        EditText txtQty ;
                        String strQty ;
                        EditText txtPrice;
                        String strPrice;
                        do {
                            txtName = (EditText) findViewById(R.id.NameAddEditFood);
                            strName = txtName.getText().toString();
                            if(TextUtils.isEmpty(strName)) {
                                txtName.setError(":(");
                                nameCheck=false;
                                return;
                            }else nameCheck=true;
                            txtQty = (EditText) findViewById(R.id.qtyAddEditFood);
                            strQty = txtQty.getText().toString();
                            if (TextUtils.isEmpty(strQty)) {
                                txtQty.setError(":(");
                                qtyCheck = false;
                                return;
                            }else qtyCheck=true;
                            txtPrice = (EditText) findViewById(R.id.priceAddEditFood);
                            strPrice = txtPrice.getText().toString();
                            if (TextUtils.isEmpty(strPrice)) {
                                txtPrice.setError(":(");
                                priceCheck = false;
                                return;
                            }else priceCheck=true;
                        }while (nameCheck==false || qtyCheck==false || priceCheck==false);

                        if(nameCheck==true && qtyCheck==true && priceCheck==true){
                            Intent intent = new Intent();
                            intent.putExtra("nameBack", strName);
                            intent.putExtra("qtyBack", strQty);
                            intent.putExtra("priceBack", strPrice);
                            intent.putExtra("position", position);
                            if (getParent() == null) {
                                setResult(DongiActivity.RESULT_OK, intent);
                            }
                            else {
                                getParent().setResult(DongiActivity.RESULT_OK, intent);
                            }
                            finish();
                        }
                    }
                });
            }
            public void btnBackToFoodList(View view) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });
    }
}