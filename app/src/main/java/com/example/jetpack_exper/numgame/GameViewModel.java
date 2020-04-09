package com.example.jetpack_exper.numgame;

import android.app.Application;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;

public class GameViewModel extends AndroidViewModel{
    public MutableLiveData<String[]> numbers = new MutableLiveData<>();
    public MutableLiveData<String> gameNum = new MutableLiveData<>();//
    public MutableLiveData<String> express = new MutableLiveData<>();//


    public GameViewModel(@NonNull Application application) {
        super(application);
        clear();
    }

    public void setNum(int index, String num) {
        if (numbers == null) {
            return;
        }
        String[] value = numbers.getValue();
        if (value == null || index >= value.length || TextUtils.isEmpty(num)) {
            return;
        }
        value[index] = num;
        numbers.setValue(value);
        expressValue();
    }

    public void clear() {
        String[] value = new String[4];
        Arrays.fill(value, "");
        numbers.setValue(value);
    }

    public void expressValue() {
        String[] value = numbers.getValue();
        for (String s : value) {
            if (TextUtils.isEmpty(s)) {
                return;
            }
        }
        float[] cards = new float[4];
        cards[0] = Float.valueOf(value[0]);
        cards[1] = Float.valueOf(value[1]);
        cards[2] = Float.valueOf(value[2]);
        cards[3] = Float.valueOf(value[3]);
        boolean hasResult = Card36.getCard36ByInputNum(cards, false);
        if (hasResult) {
            Toast.makeText(getApplication(), "bingo ，这个可以算出"+Card36.rightResult+"的值", Toast.LENGTH_LONG)
                    .show
                            ();
            express.setValue(Card36.express);
        } else {
            Toast.makeText(getApplication(), "赶紧换一组牌吧，兄弟们", Toast.LENGTH_SHORT).show();
        }

    }

}
