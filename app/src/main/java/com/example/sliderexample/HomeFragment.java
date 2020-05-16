package com.example.sliderexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<String> al;
    private ArrayList<Card> arcards;
    private ArrayList<String> cards;
    private ArrayAdapter<String> arrayAdapter;
    private int i;
    private ConstraintLayout mBackground;
    DBCards dbHelper;
    static SQLiteDatabase database;
    private static final int SLIDE_LEFT= 0;
    private static final int SLIDE_RIGHT= 1;

    public HomeFragment() {
        //required empty public constructor
    }

    //initialize all views from xml in onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

      Window w =  getActivity().getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mBackground=rootView.findViewById(R.id.background);

        return rootView;
    }

    // Do all the job here (like creating database object, doing some job with changing information, etc...
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //textTitle.setText("Doing some things with fragments");
        dbHelper = DBCards.getInstance(getContext());
        database = dbHelper.getWritableDatabase();
        dbHelper.logDB();
        database.close();

        arcards= dbHelper.getObjectListFromDB();
        for(Card temp: arcards){
            Log.v("card",temp.toString() );

        }

        al=new ArrayList<>();
        al.add("PLAY");
        al.addAll(dbHelper.getListFromDB()) ;



        arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.item, R.id.helloText, al );
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView)view.findViewById(R.id.frame);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {



                try{
                    Card card = dbHelper.getCardByState(dataObject.toString());
                    Log.v("cards",card.toString());
                  if (card.getTF() == SLIDE_LEFT){
                      mBackground.setBackgroundResource(R.drawable.truenew);
                      makeToast(getContext(), "True");
                  }else{mBackground.setBackgroundResource(R.drawable.falsenew);
                      makeToast(getContext(), "False");
                  }

                }catch(NullPointerException npe){
                    Log.v("cards","no card found");


                }

            }

            @Override
            public void onRightCardExit(Object dataObject) {


                try{
                    Card card = dbHelper.getCardByState(dataObject.toString());
                    Log.v("cards",card.toString());
                    if (card.getTF() == SLIDE_RIGHT){
                        mBackground.setBackgroundResource(R.drawable.truenew);
                        makeToast(getContext(), "True");
                    }else{mBackground.setBackgroundResource(R.drawable.falsenew);
                        makeToast(getContext(), "False");
                    }

                }catch(NullPointerException npe){
                    Log.v("cards","no card found");


                }

            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
              /*  View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
           */
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                makeToast(getContext(), "Clicked!");
            }
        });

    }

    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }






    /*@OnClick(R.id.right)
    public void right() {
        *//**
     * Trigger the right event manually.
     *//*
        flingContainer.getTopCardListener().selectRight();
    }

    @OnClick(R.id.left)
    public void left() {
        flingContainer.getTopCardListener().selectLeft();
    }
*/


}




