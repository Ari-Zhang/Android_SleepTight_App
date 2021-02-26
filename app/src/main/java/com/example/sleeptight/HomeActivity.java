package com.example.sleeptight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tests.TestMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    Button test1,test2,test3;
    Boolean test1_finished = false;
    Boolean test2_finished = false;
    Boolean test3_finished = false;
    FirstFragment myFragment = new FirstFragment();
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(bottomNavigationView.getMenu()).build();
        NavigationUI.setupActionBarWithNavController(this,navController,configuration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




                if (resultCode == 1666) {
                    bundle.putBoolean("test1_finished",true);
                }
                else{bundle.putBoolean("test1_finished",false);}
                if (resultCode == 2666) {
                    bundle.putBoolean("test2_finished",true);
                }
                else{bundle.putBoolean("test2_finished",false);}
                if (resultCode == 3666) {
                    bundle.putBoolean("test3_finished",true);
                }
                else{bundle.putBoolean("test3_finished",false);}
        myFragment.setArguments(bundle);
                //FirstFragment menua= (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.firstFragment);
       // ((FirstFragment) getSupportFragmentManager().findFragmentById(R.id.firstFragment)).testFinishedCheck(test1_finished,test2_finished,test3_finished);

        }
    }

