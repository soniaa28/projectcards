package com.example.sliderexample;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RulesFragment extends Fragment implements SearchView.OnQueryTextListener {
     ListView list_cards;
    private ArrayList<String> al;
    private ArrayList<Card> arcards;
    private ArrayAdapter<String> arrayAdapter;
    private DBCards dbHelper;
    SearchView c_searchBar;
    String textsee="blablabla";
    DialogFragment dlg1;
    public RulesFragment() {
        //required empty public constructor
    }

    //initialize all views from xml in onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rules, container, false);
        list_cards=rootView.findViewById(R.id.list_cards);
        c_searchBar =  rootView.findViewById(R.id.c_searchBar);
      dlg1= new Dialog();



        return rootView;
    }

    // Do all the job here (like creating database object, doing some job with changing information, etc...
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper = DBCards.getInstance(getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();


        arcards = dbHelper.getObjectListFromDB();
        for(Card temp: arcards){
            Log.v("card",temp.toString() );
        }

        al = new ArrayList<>();

        al.addAll(dbHelper.getListFromDB()) ;

        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, al);
        list_cards.setAdapter(arrayAdapter);
        c_searchBar.setOnQueryTextListener(this);
        list_cards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Card card = dbHelper.getCardByState(list_cards.getItemAtPosition(position).toString());
                Bundle bundle = new Bundle();

                bundle.putString("TEXT",card.getRule());
                bundle.putString("STATE",card.getState());


                dlg1.setArguments(bundle);
                dlg1.show(getFragmentManager(), "dlg1");
                String card_name=list_cards.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), card_name, Toast.LENGTH_SHORT).show();
            }});



    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        al.clear();
        if (charText.length() == 0) {
            al.addAll(dbHelper.getListFromDB());
        } else {
            for (String name : dbHelper.getListFromDB()) {
                if (name.toLowerCase(Locale.getDefault()).contains(charText)) {
                    al.add(name);
                }
            }
        }
        arrayAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        filter(text);
        return false;
    }


}
