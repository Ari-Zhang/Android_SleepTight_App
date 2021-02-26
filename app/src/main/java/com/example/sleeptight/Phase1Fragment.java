package com.example.sleeptight;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Phase1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Phase1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView mCountDown;
    private TextView mCountDownView;
    private CountDownTimer timer1;
    private Boolean button_press = false;
    public ArrayList<Integer> dotList = new ArrayList<>(25);
    public int dotLocation1=1;
    public int dotLocation2=2;
    public int dotLocation3=3;

    public Phase1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Phase1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Phase1Fragment newInstance(String param1, String param2) {
        Phase1Fragment fragment = new Phase1Fragment();
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
        View rootView = inflater.inflate(R.layout.fragment_phase1, container, false);

        return inflater.inflate(R.layout.fragment_phase1, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addArray();
        diceLocation();
        ImageView dotView1 = getView().findViewById(dotList.get(dotLocation1));
        ImageView dotView2 = getView().findViewById(dotList.get(dotLocation2));
        ImageView dotView3 = getView().findViewById(dotList.get(dotLocation3));
        TextView textView = getView().findViewById(R.id.textView14);
        dotView1.setBackgroundResource(R.drawable.dot);
        dotView2.setBackgroundResource(R.drawable.dot);
        dotView3.setBackgroundResource(R.drawable.dot);
        ArrayList<Integer> location = new ArrayList<>();
        location.add(dotLocation1);
        location.add(dotLocation2);
        location.add(dotLocation3);
        Bundle bundle1 = new Bundle();
        bundle1.putIntegerArrayList("dot_Location",location);
        timer1 = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                textView.setText( millisUntilFinished / 1000 +"s");
            }

            public void onFinish() {
                if(!button_press){
                NavController controller = Navigation.findNavController(getView());
                controller.navigate(R.id.action_phase1Fragment_to_phase2Fragment,bundle1);}
            }
        }.start();
        Button button1;
        button1 = getView().findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_press = true;
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_phase1Fragment_to_phase2Fragment,bundle1);
            }
        });
    }

    public void addArray(){
        dotList.add(R.id.dot11);
        dotList.add(R.id.dot12);
        dotList.add(R.id.dot13);
        dotList.add(R.id.dot14);
        dotList.add(R.id.dot15);
        dotList.add(R.id.dot21);
        dotList.add(R.id.dot22);
        dotList.add(R.id.dot23);
        dotList.add(R.id.dot24);
        dotList.add(R.id.dot25);
        dotList.add(R.id.dot31);
        dotList.add(R.id.dot32);
        dotList.add(R.id.dot33);
        dotList.add(R.id.dot34);
        dotList.add(R.id.dot35);
        dotList.add(R.id.dot41);
        dotList.add(R.id.dot42);
        dotList.add(R.id.dot43);
        dotList.add(R.id.dot44);
        dotList.add(R.id.dot45);
        dotList.add(R.id.dot51);
        dotList.add(R.id.dot52);
        dotList.add(R.id.dot53);
        dotList.add(R.id.dot54);
        dotList.add(R.id.dot55);
    }

    public void showDots(int i,int j, int k){
       // ImageView dotView1 = dotList.get(i);
        //ImageView dotView2 = dotList.get(j);
        //ImageView dotView3 = dotList.get(k);
        //dotView1.setBackgroundResource(R.drawable.dot);
        //dotView2.setBackgroundResource(R.drawable.dot);
        //dotView3.setBackgroundResource(R.drawable.dot);
    }

    public void diceLocation(){
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        dotLocation1 = r1.nextInt(25) ;
        while(true)
        {
            dotLocation2 = r2.nextInt(25) ;
            if(dotLocation2!=dotLocation1){break;}
        }
        while(true)
        {
            dotLocation3 = r3.nextInt(25);
            if(dotLocation3!=dotLocation2 && dotLocation3!=dotLocation1 &&
                    !(((dotLocation3)/5 == (dotLocation2)/5) &&((dotLocation3)/5==(dotLocation1)/5)&&((dotLocation2)/5== (dotLocation1)/5))
                    &&!(((dotLocation3)%5 == (dotLocation2)%5) &&((dotLocation3)%5== (dotLocation1)%5)&&((dotLocation2)%5== (dotLocation1)%5)))
            {
                break;
            }
        }


    }


    private void startGuideCountDown() {

        mCountDown.setVisibility(View.VISIBLE);
        mCountDown.setScaleY(0);
        mCountDown.setScaleX(0);
        final CountDownTimer timer = new CountDownTimer(3300, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                //Log.d(TAG,"onTick " + millisUntilFinished);
                float remain = millisUntilFinished / 1000f;
                int round = Math.round(remain);
                showGuideCountDownAnim(round);
            }

            @Override
            public void onFinish() {

                mCountDown.setVisibility(View.GONE);
            }
        };

        mCountDown.postDelayed(new Runnable() {
            @Override
            public void run() {
                timer.start();
            }
        }, 300);
    }

    private void showGuideCountDownAnim(int remain) {

        if (remain == 0) {
            return;
        }

        mCountDown.setText(String.valueOf(remain));

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mCountDown, "scaleX", 0, 1);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mCountDown, "scaleY", 0, 1);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(800);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.playTogether(scaleX, scaleY);
        set.start();
    }
}