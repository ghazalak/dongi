//package com.example.dongi;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.AttributeSet;
//import android.widget.NumberPicker;
//import android.widget.Toast;
//
//@TargetApi(Build.VERSION_CODES.HONEYCOMB)//For backward-compability
//public class NumberPicker extends NumberPicker {
//   // String value;
//    public void onValueChangedListener(NumberPicker picker, int oldVal, int newVal) {
//        //Toast.makeText(getContext(), "New Value is"+newVal, Toast.LENGTH_SHORT).show();
//    }
//
//    public NumberPicker(Context context) {
//        super(context);
//    }
//    public NumberPicker(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        processAttributeSet(attrs);
//    }
//    public NumberPicker(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        processAttributeSet(attrs);
//    }
//    private void processAttributeSet(AttributeSet attrs) {
//        //This method reads the parameters given in the xml file and sets the properties according to it
//        this.setMinValue(attrs.getAttributeIntValue(null, "min", 0));
//        this.setMaxValue(attrs.getAttributeIntValue(null, "max", 0));
//        this.setValue(attrs.getAttributeIntValue(null, "value", 0));
////        this.onValueChangedListener(findViewById(R.id.numberPicker1),);
//    }
//
//    public interface OnValueChangeListener {
//        void onValueChange(NumberPicker var1, int var2, int var3);
//    }
//    //public
//
//}
//
