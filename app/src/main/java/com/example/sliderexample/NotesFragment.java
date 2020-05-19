package com.example.sliderexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sliderexample.topics.RecyclerViewAdapter;

public class NotesFragment extends Fragment {
    RecyclerView recyclerView;

    RecyclerView.Adapter recyclerView_Adapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[] numbers = {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",

    };



    public NotesFragment() {
        //required empty public constructor
    }

    //initialize all views from xml in onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view1);
        recyclerViewLayoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerView_Adapter = new RecyclerViewAdapter(getContext(),numbers);

        recyclerView.setAdapter(recyclerView_Adapter);

        return rootView;
    }

    // Do all the job here (like creating database object, doing some job with changing information, etc...
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       //textTitle.setText("Doing some things with fragments");
    }


    }
