package com.example.tests;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Phase2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Phase2Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public ArrayList<Integer> alphaList = new ArrayList<>();
    private Chronometer ctimer;
    private Timer mTimer;
    private TimerTask mTask;
    public String phase2_time;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Phase2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Phase2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Phase2Fragment newInstance(String param1, String param2) {
        Phase2Fragment fragment = new Phase2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phase2, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addArray();
        startCouting();
        ArrayList<Integer> check = new ArrayList<>();
        ArrayList<Integer> F_location = rollAlpha();
        ArrayList<Button> alpha = new ArrayList<>();
        ArrayList<Boolean> touch_check = new ArrayList<>();
        for( int i = 0; i<13; i++){
            int button = i;
            alpha.add(getView().findViewById(alphaList.get(F_location.get(i))));
            alpha.get(i).setText("F");
            touch_check.add(i,true);
            alpha.get(i).setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (touch_check.get(button)) {
                        alpha.get(button).setBackgroundColor(R.color.ourColor);
                        check.add(1);
                        if (check.size() == 13) {
                            String phase2 = stopCouting();
                            Bundle bundle2 = new Bundle();
                            bundle2.putIntegerArrayList("dot_Location", getArguments().getIntegerArrayList("dot_Location"));
                            bundle2.putString("phase2_record_time",phase2);
                            NavController controller = Navigation.findNavController(getView());
                            controller.navigate(R.id.action_phase2Fragment_to_phase3Fragment, bundle2);
                        }
                        touch_check.set(button,false);
                    }
                }
            });
        }


    }


    public void addArray() {
        alphaList.add(R.id.alpha1);
        alphaList.add(R.id.alpha2);
        alphaList.add(R.id.alpha3);
        alphaList.add(R.id.alpha4);
        alphaList.add(R.id.alpha5);
        alphaList.add(R.id.alpha6);
        alphaList.add(R.id.alpha7);
        alphaList.add(R.id.alpha8);
        alphaList.add(R.id.alpha9);
        alphaList.add(R.id.alpha10);
        alphaList.add(R.id.alpha11);
        alphaList.add(R.id.alpha12);
        alphaList.add(R.id.alpha13);
        alphaList.add(R.id.alpha14);
        alphaList.add(R.id.alpha15);
        alphaList.add(R.id.alpha16);
        alphaList.add(R.id.alpha17);
        alphaList.add(R.id.alpha18);
        alphaList.add(R.id.alpha19);
        alphaList.add(R.id.alpha20);
        alphaList.add(R.id.alpha21);
        alphaList.add(R.id.alpha22);
        alphaList.add(R.id.alpha23);
        alphaList.add(R.id.alpha24);
        alphaList.add(R.id.alpha25);
        alphaList.add(R.id.alpha26);
        alphaList.add(R.id.alpha27);
        alphaList.add(R.id.alpha28);
        alphaList.add(R.id.alpha29);
        alphaList.add(R.id.alpha30);
        alphaList.add(R.id.alpha31);
        alphaList.add(R.id.alpha32);
        alphaList.add(R.id.alpha33);
        alphaList.add(R.id.alpha34);
        alphaList.add(R.id.alpha35);
        alphaList.add(R.id.alpha36);
        alphaList.add(R.id.alpha37);
        alphaList.add(R.id.alpha38);
        alphaList.add(R.id.alpha39);
        alphaList.add(R.id.alpha40);
        alphaList.add(R.id.alpha41);
        alphaList.add(R.id.alpha42);
        alphaList.add(R.id.alpha43);
        alphaList.add(R.id.alpha44);
        alphaList.add(R.id.alpha45);


    }
     public ArrayList rollAlpha(){
         ArrayList<Integer> locationList = new ArrayList<>();
         ArrayList<Integer> randomGenerator = new ArrayList<>();
         Random r = new Random();
         //locationList.add(r.nextInt(45));
         for(int i = 0; i < 45; i++)
         {
             randomGenerator.add(i);;
         }

         for(int i = 1; i < 14; i++)
         {
             int t = r.nextInt(45-i);
             locationList.add(randomGenerator.get(t));
             randomGenerator.set(t,randomGenerator.get(45-i));
             //randomGenerator.set(45-i,locationList.get(i-1));
         }
        return locationList;
     }

    private static String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.FRANCE);
        return format.format(new Date());
    }

    private void startCouting(){
        if (mTimer == null && mTask == null) {
            mTimer = new Timer();

            mTask = new TimerTask()
            {
                int cnt = 0;
                @Override
                public void run() {

                    phase2_time = getStringTime(cnt++);
                }
            };

            mTimer.schedule(mTask, 0, 10);
        }
    }

    private String stopCouting(){

        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTask != null) {
            mTask.cancel();
            mTask = null;
        }
        return phase2_time;
    }


    private String getStringTime(int cnt) {
        int min = (cnt/6000 )% 3600;
        int second = (cnt/100) % 60;
        int milesecond = cnt-second*100-min*6000 ;
        return String.format(Locale.FRANCE,"%02d:%02d:%02d",min,second,milesecond);
    }


}
