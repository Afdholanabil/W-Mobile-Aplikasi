package com.example.recyclickprojek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.recyclickprojek.Fragment.HomeFragment;
import com.example.recyclickprojek.Fragment.LoginFragment;
import com.example.recyclickprojek.Util.Util;
import com.example.recyclickprojek.databinding.FragmentHomeBinding;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Util.pindahFragment(getSupportFragmentManager(), new LoginFragment());
        hideActionBar();

    }
    public void hideActionBar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }



}