package com.example.jetpack_exper.numgame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.jetpack_exper.R;
import com.example.jetpack_exper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MutableLiveData<String> data = new MutableLiveData<>();
        data.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
        data.setValue("333");
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final GameViewModel gameData = new GameViewModel(getApplication());

        binding.setGameData(gameData);
//        binding.result.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Card36.rightResult = Integer.parseInt(s.toString());
//                gameData.expressValue();
//            }
//        });
        binding.setLifecycleOwner(this);
    }
}
