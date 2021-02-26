package com.example.sleeptight;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sleeptight.TestMainActivity;

public class FirstFragment extends Fragment {

    private FirstViewModel mViewModel;
    Button mor,eve,test1,test2,test3;
    private Boolean test1_finished = false;
    private Boolean test2_finished = false;
    private Boolean test3_finished = false;
    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mor=(Button) getView().findViewById(R.id.morning_q);
        mor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MorningActivity.class);
                startActivity(i);
            }
        });
        eve=(Button) getView().findViewById(R.id.evening_q);
        eve.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EveningActivity.class);
                startActivity(i);
            }
        });
        test1=(Button) getView().findViewById(R.id.button2);


        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getArguments()!=null) {
                    test1_finished = getArguments().getBoolean("test1_finished");}
                    if (!test1_finished) {
                        Intent it_to_cognitive_test = new Intent(getActivity(), TestMainActivity.class);
                        startActivityForResult(it_to_cognitive_test, 1);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "You already did this!", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        test2=(Button) getView().findViewById(R.id.button4);


        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getArguments()!=null) {
                    test1_finished = getArguments().getBoolean("test2_finished");}
                if (!test1_finished) {
                    Intent it_to_cognitive_test = new Intent(getActivity(), TestMainActivity.class);
                    startActivityForResult(it_to_cognitive_test, 1);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "You already did this!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        test3=(Button) getView().findViewById(R.id.button5);


        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getArguments()!=null) {
                    test1_finished = getArguments().getBoolean("test3_finished");}
                if (!test1_finished) {
                    Intent it_to_cognitive_test = new Intent(getActivity(), TestMainActivity.class);
                    startActivityForResult(it_to_cognitive_test, 1);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "You already did this!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mViewModel = new ViewModelProvider(this).get(FirstViewModel.class);
        // TODO: Use the ViewModel
    }




}