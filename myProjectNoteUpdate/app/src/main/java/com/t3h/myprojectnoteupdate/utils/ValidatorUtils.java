package com.t3h.myprojectnoteupdate.utils;

import android.widget.EditText;

public class ValidatorUtils {
    public static boolean isImputEmpty(EditText...edts){
        boolean result = false;
        for(EditText editText :edts){
            if(editText.getText().toString().isEmpty()){
                result = true;
                editText.setError("Imput Empty");
            }
        }
        return result;
    }
}
