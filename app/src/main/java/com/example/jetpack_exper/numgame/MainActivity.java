package com.example.jetpack_exper.numgame;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.jetpack_exper.R;
import com.example.jetpack_exper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final GameViewModel gameData = new GameViewModel(getApplication());

        binding.setGameData(gameData);
        binding.num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gameData.setNum(0,s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gameData.setNum(1,s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gameData.setNum(2,s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.num4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gameData.setNum(3,s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.result.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Card36.rightResult = Integer.parseInt(s.toString());
                gameData.expressValue();
            }
        });
        binding.setLifecycleOwner(this);
    }
}
