package com.t3h.myprojectnoteupdate.check;

import android.widget.EditText;

public abstract class ValidatorUtils {
    public static  boolean isInputEmpty(EditText... editTexts){
        boolean result = false;
        for (EditText editText: editTexts){
            result = true;
            editText.setError("Imput is Empty");
        }
        return result;
    }
}
