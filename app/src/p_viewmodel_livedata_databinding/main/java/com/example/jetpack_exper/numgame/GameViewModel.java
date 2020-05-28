package com.example.jetpack_exper.numgame;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class GameViewModel extends AndroidViewModel{
    public MutableLiveData<String> num1 = new MutableLiveData<>();
    public MutableLiveData<String> num2 = new MutableLiveData<>();
    public MutableLiveData<String> num3 = new MutableLiveData<>();
    public MutableLiveData<String> num4 = new MutableLiveData<>();
    public MutableLiveData<String> gameNum = new MutableLiveData<>();//
    public MutableLiveData<String> express = new MutableLiveData<>();//


    public GameViewModel(@NonNull Application application) {
        super(application);
        clear();
    }

//    public void setNum(int index, String num) {
//        if (numbers == null) {
//            return;
//        }
//        String[] value = numbers.getValue();
//        if (value == null || index >= value.length || TextUtils.isEmpty(num)) {
//            return;
//        }
//        value[index] = num;
//        numbers.setValue(value);
//        expressValue();
//    }

    public void clear() {
        num1.setValue("");
        num2.setValue("");
        num3.setValue("");
        num4.setValue("");
        express.setValue("");
        gameNum.setValue("");
    }

    public String expressValue() {
        String[] nums = new String[]{num1.getValue(),num2.getValue(),num3.getValue(),num4.getValue()};
        for (String num : nums) {
            if (TextUtils.isEmpty(num)) {
                return "";
            }
        }
        float[] cards = new float[4];
        cards[0] = Float.parseFloat(nums[0]);
        cards[1] = Float.parseFloat(nums[1]);
        cards[2] = Float.parseFloat(nums[2]);
        cards[3] = Float.parseFloat(nums[3]);
        for (float card : cards) {
            if (card<=0) {
                return "";
            }
        }
        String value = gameNum.getValue();
        if (!TextUtils.isEmpty(value)) {
            Card36.rightResult = Integer.parseInt(value);
        }
        long l = System.currentTimeMillis();
        boolean hasResult = Card36.getCard36ByInputNum(cards, true);
        long l2 = System.currentTimeMillis();
        Log.d("getCard36ByInputNum", l2 - l+"");
        if (hasResult) {
//            Toast.makeText(getApplication(), "bingo ，这个可以算出"+Card36.rightResult+"的值", Toast.LENGTH_LONG)
//                    .show();
            express.setValue(Card36.express);
        } else {
//            Toast.makeText(getApplication(), "赶紧换一组牌吧，兄弟们", Toast.LENGTH_SHORT).show();
        }
        return express.getValue();
    }

}
