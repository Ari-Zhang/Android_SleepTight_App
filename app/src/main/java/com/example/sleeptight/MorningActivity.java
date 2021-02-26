package com.example.sleeptight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MorningActivity extends AppCompatActivity {

    EditText sleeptime,getuptime;
    SeekBar sleepstress,hardtosleep,howsleep,worrysleep,prematurely,awaken;
    Button done;

    DatabaseReference MorningDBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);

        sleeptime = findViewById(R.id.a1);
        getuptime = findViewById(R.id.a3);
        sleepstress = findViewById(R.id.seekBar6);
        hardtosleep = findViewById(R.id.seekBar2);
        howsleep = findViewById(R.id.seekBar7);
        worrysleep = findViewById(R.id.seekBar8);
        prematurely = findViewById(R.id.seekBar9);
        awaken = findViewById(R.id.seekBar10);
        done = findViewById(R.id.done);

        final int[] sleeptimenum = new int[1];
        final int[] hardtosleepnum = new int[1];
        final int[] howsleepnum = new int[1];
        final int[] worrysleepnum = new int[1];
        final int[] prematurelynum = new int[1];
        final int[] awakennum = new int[1];

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid = user.getUid();

        MorningDBRef = FirebaseDatabase.getInstance().getReference().child(userid).child("MorningQestionnarie");

        /*
        store the data into the database, use a method called insertMorningdata();
         */
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sleeptimeshow = sleeptime.getText().toString();
                String getuptimeshow = getuptime.getText().toString();
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String dateString = formatter.format(currentTime);

                Morning morningq = new Morning(dateString,sleeptimeshow,getuptimeshow,sleeptimenum[0],hardtosleepnum[0],howsleepnum[0],worrysleepnum[0],prematurelynum[0],awakennum[0]);

                MorningDBRef.push().setValue(morningq);

                Intent i = new Intent(MorningActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });

        /*
        get the value of seekBar;
         */
        sleepstress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sleeptimenum[0] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        hardtosleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                hardtosleepnum[0] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        howsleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                howsleepnum[0] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        worrysleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                worrysleepnum[0] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        prematurely.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prematurelynum[0] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        awaken.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                awakennum[0] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}