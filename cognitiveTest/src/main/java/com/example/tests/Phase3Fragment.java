package com.example.tests;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Phase3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Phase3Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
   // private int buttonIndex;
    public ArrayList<Integer> locationList = new ArrayList<>(25);
    public Boolean answer1_check = false;
    public Boolean answer2_check = false;
    public Boolean answer3_check = false;
    private Timer mTimer;
    private TimerTask mTask;
    public String phase3_time;
    public Phase3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Phase3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Phase3Fragment newInstance(String param1, String param2) {
        Phase3Fragment fragment = new Phase3Fragment();
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
        return inflater.inflate(R.layout.fragment_phase3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button1, answer1,answer2,answer3;
        button1 = getView().findViewById(R.id.button75);
        //Bundle location = getArguments().getBundle("dot_Location");
        ArrayList<Integer> answer = getArguments().getIntegerArrayList("dot_Location");
        String phase2_time = getArguments().getString("phase2_record_time");
        addArray();
        answer1 = getView().findViewById(locationList.get(answer.get(0)));
        answer2 = getView().findViewById(locationList.get(answer.get(1)));
        answer3 = getView().findViewById(locationList.get(answer.get(2)));
        startCouting();
        /*answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1_check)
                {answer1.setBackgroundResource(R.drawable.blank);
                    answer1_check = false; }
                else{
                    answer1_check = true;
                    answer1.setBackgroundResource(R.drawable.dot);}
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2_check)
                {answer2.setBackgroundResource(R.drawable.blank);
                    answer2_check = false; }
                else{
                    answer2_check = true;
                    answer3.setBackgroundResource(R.drawable.dot);}
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3_check)
                {answer3.setBackgroundResource(R.drawable.blank);
                    answer3_check = false; }
                else{
                answer3_check = true;
                answer3.setBackgroundResource(R.drawable.dot);}
            }
        });*/
        ArrayList<Button> buttonArrayList = new ArrayList<>(25);
        ArrayList<Boolean> buttonPress = new ArrayList<>(25);
        for(int i=0; i<25; i++){
           int buttonIndex = i;
            buttonArrayList.add(i,getView().findViewById(locationList.get(i)));
            buttonPress.add(i,false);
            buttonArrayList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    if(buttonPress.get(buttonIndex) == false){
                    if(buttonIndex == answer.get(0)){answer1_check = true;}
                    if(buttonIndex == answer.get(1)){answer2_check = true;}
                    if(buttonIndex == answer.get(2)){answer3_check = true;}
                    buttonArrayList.get(buttonIndex).setBackgroundResource(R.drawable.dot);
                    buttonPress.set(buttonIndex,true);}
                    else{
                        if(buttonIndex == answer.get(0)){answer1_check = false;}
                        if(buttonIndex == answer.get(1)){answer2_check = false;}
                        if(buttonIndex == answer.get(2)){answer3_check = false;}
                        buttonArrayList.get(buttonIndex).setBackgroundResource(R.drawable.blank);
                        buttonPress.set(buttonIndex,false);
                    }
                }
            });
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("phase2_time_recording",phase2_time);
                NavController controller = Navigation.findNavController(v);
                if( answer1_check&& answer2_check&& answer3_check){
                    String phase3 = stopCouting();
                    bundle3.putString("phase3_time_recording",phase3);
                controller.navigate(R.id.action_phase3Fragment_to_winFragment,bundle3);}
                else{String lose = stopCouting();
                    controller.navigate(R.id.action_phase3Fragment_to_loseFragment,bundle3);}
            }
        });
    }

    public void addArray(){
        locationList.add(R.id.location11);
        locationList.add(R.id.location12);
        locationList.add(R.id.location13);
        locationList.add(R.id.location14);
        locationList.add(R.id.location15);
        locationList.add(R.id.location21);
        locationList.add(R.id.location22);
        locationList.add(R.id.location23);
        locationList.add(R.id.location24);
        locationList.add(R.id.location25);
        locationList.add(R.id.location31);
        locationList.add(R.id.location32);
        locationList.add(R.id.location33);
        locationList.add(R.id.location34);
        locationList.add(R.id.location35);
        locationList.add(R.id.location41);
        locationList.add(R.id.location42);
        locationList.add(R.id.location43);
        locationList.add(R.id.location44);
        locationList.add(R.id.location45);
        locationList.add(R.id.location51);
        locationList.add(R.id.location52);
        locationList.add(R.id.location53);
        locationList.add(R.id.location54);
        locationList.add(R.id.location55);
    }

    private static String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.FRANCE);
        return format.format(new Date());
    }

    private void startCouting(){
        if (mTimer == null && mTask == null) {
            mTimer = new Timer();
            mTask = new TimerTask() {
                int cnt = 0;
                @Override
                public void run() {

                    phase3_time = getStringTime(cnt++);
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
        return phase3_time;
    }
    private String getStringTime(int cnt) {
        int min = (cnt/6000 )% 3600;
        int second = (cnt/100) % 60;
        int milesecond = cnt-second*100-min*6000 ;
        return String.format(Locale.FRANCE,"%02d:%02d:%02d",min,second,milesecond);
    }

    public void buttonClick(View v){

        if(!(v.findViewById(v.getId()).getContentDescription() =="y"))
        {v.findViewById(v.getId()).setBackgroundResource(R.drawable.dot);
            v.findViewById(v.getId()).setContentDescription("y");}
        else{v.findViewById(v.getId()).setBackgroundResource(R.drawable.blank);
            v.findViewById(v.getId()).setContentDescription(""); }
    }
}