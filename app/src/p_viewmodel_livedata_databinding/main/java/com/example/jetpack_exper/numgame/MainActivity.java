package com.example.jetpack_exper.numgame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
        GameViewModel gameViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(GameViewModel.class);
        binding.setGameData(gameViewModel);
        binding.setLifecycleOwner(this);
    }
}
