package com.example.sleeptight;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondFragment extends Fragment {

    private SecondViewModel mViewModel;

    DatabaseReference DbRef,DbRef2;
    List<String> quotes_list;
    List<Integer> statistic_list;
    Quotes myquote;
    Morning morning;
    int position = 0;
    TextView hours,stresslevel,hardtosleep,quotes;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SecondViewModel.class);
        // TODO: Use the ViewModel

        hours = getView().findViewById(R.id.textView20);
        stresslevel = getView().findViewById(R.id.textView23);
        hardtosleep = getView().findViewById(R.id.textView25);
        quotes = getView().findViewById(R.id.textView14);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid = user.getUid();

        DbRef2 = FirebaseDatabase.getInstance().getReference(userid).child("MorningQestionnarie");
        DbRef = FirebaseDatabase.getInstance().getReference("quotes");
        myquote = new Quotes();
        morning = new Morning();
        quotes_list = new ArrayList<>();
        statistic_list = new ArrayList<>();
        Random random=new Random();
        DbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot i : snapshot.getChildren()){
                    myquote = i.getValue(Quotes.class);
                    if (myquote != null){
                        quotes_list.add(myquote.getTitle());
                    }
                    quotes.setText(quotes_list.get(random.nextInt(quotes_list.size())));
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DbRef2.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot i : snapshot.getChildren()){
                    morning = i.getValue(Morning.class);
                    if (morning != null){
                        statistic_list.add(morning.getSleepstress());
                    }

                }

                //n stresslevel.setText(String.valueOf(sum1((ArrayList<Integer>) statistic_list)/statistic_list.size()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    private int sum1(ArrayList<Integer> arrayList2) {
        int sum = 0;

        int length = arrayList2.size();

        for (int i = 0; i < length; i++) {
            sum += arrayList2.get(i);

        }
        return sum;

    }

}