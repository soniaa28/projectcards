package com.example.sliderexample;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotesFragment extends Fragment implements View.OnClickListener {
     private View ach1;
    private TextView ach2;
    private TextView ach3;
    private TextView ach4;

    public NotesFragment() {
        //required empty public constructor
    }

    //initialize all views from xml in onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);
        ach1=rootView.findViewById(R.id.ach1);
        ach2=rootView.findViewById(R.id.ach2);
        ach3=rootView.findViewById(R.id.ach3);
        ach4=rootView.findViewById(R.id.ach4);
        ach1.setOnClickListener(this);
        ach2.setOnClickListener(this);
        ach3.setOnClickListener(this);
        ach4.setOnClickListener(this);







        return rootView;
    }

    // Do all the job here (like creating database object, doing some job with changing information, etc...
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


       //textTitle.setText("Doing some things with fragments");
    }
   public void onClick(View v){
        ach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();


            }
        });
       ach2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();

           }
       });
       ach3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();

           }
       });
       ach4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getContext(), "4", Toast.LENGTH_SHORT).show();

           }
       });

    }


    }
