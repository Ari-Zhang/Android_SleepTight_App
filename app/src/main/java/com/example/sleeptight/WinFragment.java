package com.example.sleeptight;

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
 * Use the {@link WinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WinFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DatabaseReference WinDBRef;

    public WinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TitleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WinFragment newInstance(String param1, String param2) {
        WinFragment fragment = new WinFragment();
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
        return inflater.inflate(R.layout.fragment_end, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView1, textView2;
        Button finishButton;
        textView1 = getView().findViewById(R.id.textView9);
        textView2 = getView().findViewById(R.id.textView15);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(currentTime);
        textView2.setText(dateString);
        textView1.setText("Second trail time:\n"+getArguments().getString("phase2_time_recording")+"\nThird trail time:\n"+getArguments().getString("phase3_time_recording"));
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid = user.getUid();

        WinDBRef = FirebaseDatabase.getInstance().getReference().child(userid).child("Tests");
        finishButton = getView().findViewById(R.id.finishButton1);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                //intent.putExtra("data", "Hello A");
               // getActivity().setResult(1666, intent);
                Test test = new Test(dateString,getArguments().getString("phase2_time_recording"),getArguments().getString("phase3_time_recording"),"success!");
                WinDBRef.push().setValue(test);
                getActivity().finish();
            }
        });
    }
}