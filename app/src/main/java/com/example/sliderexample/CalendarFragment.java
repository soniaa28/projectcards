package com.example.sliderexample;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalendarFragment extends Fragment {
    GridLayout mainGrid;
    static ArrayList<String> topics;
    Map <Integer,String> categories;



    public CalendarFragment() {
        //required empty public constructor
    }

    //initialize all views from xml in onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);



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
        categories=new HashMap<>();

        categories.put(0,"правопис");
        categories.put(1,"наголос");
        categories.put(2,"дефіс");
        categories.put(3,"синтаксис");

        topics = new ArrayList<>();

    }

    private void setToggleEvent(final GridLayout mainGrid) {
        for(int i = 0;i<mainGrid.getChildCount();i++){
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int position=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor()==-1){
                        cardView.setCardBackgroundColor(Color.parseColor("#F7E6D1FB"));
                        topics.add(categories.get(position));
                        Log.v("message",categories.get(position) + "");



                    }else{
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        topics.remove(categories.get(position));




                    }
/*

                    Fragment currentFragment = getFragmentManager().findFragmentByTag("HomeFragment");
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.detach(currentFragment);
                    fragmentTransaction.attach(currentFragment);
                    fragmentTransaction.commit();
*/




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
