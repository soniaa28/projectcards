package com.example.sliderexample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class RulesFragment extends Fragment {
    GridLayout mainGrid;


    public RulesFragment() {
        //required empty public constructor
    }

    //initialize all views from xml in onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rules, container, false);



        return rootView;
    }

    // Do all the job here (like creating database object, doing some job with changing information, etc...
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //textTitle.setText("Doing some things with fragments");
        mainGrid=(GridLayout)view.findViewById(R.id.mainGrid);
        //setSingleEvent(mainGrid);
        setToggleEvent(mainGrid);

    }

    private void setToggleEvent(GridLayout mainGrid) {
        for(int i = 0;i<mainGrid.getChildCount();i++){
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor()==-1){
                        cardView.setCardBackgroundColor(Color.parseColor("#F7E6D1FB"));


                    }else{
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));

                    }
                }
            });

        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i = 0;i<mainGrid.getChildCount();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }


}
