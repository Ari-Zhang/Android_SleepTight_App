package com.example.sleeptight;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DatabaseReference LoseDBRef;

    public LoseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoseFragment newInstance(String param1, String param2) {
        LoseFragment fragment = new LoseFragment();
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
        return inflater.inflate(com.example.sleeptight.R.layout.fragment_lose, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView1, textView2;
        Button finishButton;
        textView1 = getView().findViewById(com.example.sleeptight.R.id.textView16);
        textView2 = getView().findViewById(com.example.sleeptight.R.id.textView17);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(currentTime);
        textView1.setText(dateString);
        textView2.setText("Second trail time:\n"+getArguments().getString("phase2_time_recording"));
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid = user.getUid();

        LoseDBRef = FirebaseDatabase.getInstance().getReference().child(userid).child("Tests");
        finishButton = getView().findViewById(com.example.sleeptight.R.id.finishButton2);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data", "Hello A");
                getActivity().setResult(1666, intent);
                Test test = new Test(dateString,getArguments().getString("phase2_time_recording"),getArguments().getString("phase3_time_recording"),"failure!");
                LoseDBRef.push().setValue(test);

                getActivity().finish();
            }
        });
    }
}