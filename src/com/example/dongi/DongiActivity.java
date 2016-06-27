package com.example.dongi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.*;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;

class Food implements Parcelable{
    String name;
    int qty;
    int price;
    ArrayList<String> persons;
    Food(String name,
            int qty,
            int price){
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.persons=new ArrayList<String>();
    }
    public Food(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<Food> CREATOR = new Parcelable.Creator<Food>() {
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        public Food[] newArray(int size) {

            return new Food[size];
        }

    };

    public void readFromParcel(Parcel in) {
        name = in.readString();
        qty = in.readInt();
        price = in.readInt();
        //persons = new ArrayList<String>();
        //in.readTypedList();
        int size = in.readInt();
        String[] s = new String[size];
        in.readStringArray(s);

        persons = new ArrayList(Arrays.asList(s));


    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(qty);
        dest.writeInt(price);
        dest.writeInt(persons.size());
        dest.writeStringArray(persons.toArray( new String[persons.size()]));
    }
}
public class DongiActivity extends Activity {

   ArrayList<Food> foods = new ArrayList<Food>();
    final Context context=this;
    AdapterActivity adapter;
    @Override
    public void onCreate(Bundle bdl) {
        super.onCreate(bdl);
        Food f = new Food("برگ", 2, 20000);
        f.persons.add("hamid");
        f.persons.add("ghazal");
        foods.add(f);
         f = new Food("کوبیده", 3, 10000);
        f.persons.add("sarah");
        f.persons.add("tala");
        f.persons.add("khani");
        foods.add(f);
         f = new Food("نوشابه", 3, 1000);
        f.persons.add("hamid");
        f.persons.add("sarah");
        f.persons.add("khani");
        foods.add(f);
        f = new Food("ماست", 2, 3000);
        f.persons.add("sarah");
        f.persons.add("tala");
        foods.add(f);
        setContentView(R.layout.main);
        adapter = new AdapterActivity(this, foods);
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
    public void btnContinueResult(View view) {

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putParcelableArrayListExtra("foods", foods);
        startActivity(intent);
    }
    public void btnAddClickHandler(View view) {
        Intent intent = new Intent(this, ChangeOrAddFoodActivity.class);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == DongiActivity.RESULT_OK) {
            if (requestCode == 1) {

                Food f = new Food(data.getStringExtra("nameBack"), data.getIntExtra("qtyBack", 0), data.getIntExtra("priceBack", 0));
                foods.add(f);
            } else if (requestCode == 2) {
                int position = Integer.valueOf(data.getStringExtra("position"));
                Food f = foods.get(position);
                f.name = data.getStringExtra("nameBack");
                f.qty = data.getIntExtra("qtyBack", 0);
                f.price = data.getIntExtra("priceBack", 0);
            }
            adapter.notifyDataSetChanged();
//            AdapterActivity adapter = new AdapterActivity(this, foods);
//            ListView listView = (ListView) findViewById(R.id.listView);
//            listView.setAdapter(adapter);
        }
    }

    public void btnSelectContact(View view) {
        Intent intent = new Intent(this, ContactsActivity.class);
        Object o = view.getTag(R.string.position);
        String s = (String) view.getTag(R.string.position);
        int position = Integer.valueOf(s);
        Food f = foods.get(position);
        intent.putExtra("qtyFirst", f.qty);
        startActivity(intent);

    }
    public void editButtonClickHandler(View view) {
        Intent intent = new Intent(this, ChangeOrAddFoodActivity.class);
        String s = (String) view.getTag(R.string.position);
        intent.putExtra("position", (String) view.getTag(R.string.position));
        int position = Integer.valueOf(s);
        Food f = foods.get(position);
        intent.putExtra("name", f.name);
        intent.putExtra("qty", f.qty);
        intent.putExtra("price", f.price);

        startActivityForResult(intent, 2);
    }

}