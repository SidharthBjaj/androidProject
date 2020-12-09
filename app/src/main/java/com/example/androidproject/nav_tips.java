package com.example.androidproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nav_tips#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nav_tips extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private SharedPreferences sharedPreferences;
    TextView description;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public nav_tips() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nav_tips.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_tips newInstance(String param1, String param2) {
        nav_tips fragment = new nav_tips();
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

        View view = inflater.inflate(R.layout.fragment_nav_tips, container, false);
//        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.La));

        final ListView listView = view.findViewById(R.id.DataTypeList);
        description = view.findViewById(R.id.item_description);


        ArrayList<ListViewItem> dataTypeItemArrayList = new ArrayList<>();
        dataTypeItemArrayList.add(new ListViewItem("UNINSTALL OLD APPLICATION", "The best thing to do in order to keep your phone healthy is to go through" +
                "        your applications and delete those that you no longer use."));
        dataTypeItemArrayList.add(new ListViewItem("KEEP YOUR SOFTWARE UPDATED", "Regardless of whether you run iOS or Android, it’s vitally important for your phone’s health" +
                "        that you keep the software up-to-date." +
                "        These usually have bug fixes and updates which fix issues on the device"));

        dataTypeItemArrayList.add(new ListViewItem("AVOID OVER CHARGING", "Most modern phones aren’t really supposed to be charged to the max, nor are they meant to run out of battery completely." +
                "        This is due to how the batteries are designed"));

        dataTypeItemArrayList.add(new ListViewItem("INSURE YOU DEVICE", "This may seem obvious, but a fairly easy way to make sure that your mobile phone remains in good" +
                "        shape is to invest in comprehensive phone insurance."));

        dataTypeItemArrayList.add(new ListViewItem("AVOID USING IN EXTREME TEMPS", "The health of your smartphone is very dependent on how well the battery operates. A sure-fire way of putting the battery under undue strain is to expose your smartphone to" +
                "        extreme temperatures – both hot and cold."));

        dataTypeItemArrayList.add(new ListViewItem("LOW POWER MODE", "Most, if not all, modern smartphones have some form of low-power mode, which reduced functionality in order" +
                "        to preserve battery life and power. try to utilize this feature as much as possible"));

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, dataTypeItemArrayList);

        listView.setAdapter(new CustomListViewAdapter(getContext(), dataTypeItemArrayList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                description.setText(((ListViewItem) listView.getItemAtPosition(position)).getDescription());
            }
        });

        description.setTextSize(20);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        int textValue = Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "20")));
        String textStyle = (sharedPreferences.getString("style", "Cursive"));

        if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "20")))) {
            description.setTextSize(Float.parseFloat(String.valueOf(textValue)));
            description.refreshDrawableState();
        } else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "22")))) {
            description.setTextSize(Float.parseFloat(String.valueOf(textValue)));
            description.refreshDrawableState();
        } else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "24")))) {
            description.setTextSize(Float.parseFloat(String.valueOf(textValue)));
            description.refreshDrawableState();
        }else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "26"))))
            description.setTextSize(Float.parseFloat(String.valueOf(textValue)));
        description.refreshDrawableState();


        if (textStyle.equals(sharedPreferences.getString("style", "Cursive"))) {
            Typeface type = Typeface.create("cursive", Typeface.NORMAL);
            description.setTypeface(type);
        }else if (textStyle.equals(sharedPreferences.getString("style", "Sans"))) {
            Typeface type2 = Typeface.create("sans", Typeface.NORMAL);
            description.setTypeface(type2);
        }else if (textStyle.equals(sharedPreferences.getString("style", "Mono"))) {
            Typeface type3 = Typeface.create("Monospace", Typeface.NORMAL);
            description.setTypeface(type3);
        }
        return view;
    }

    @Override
    public void onResume() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        int textValue = Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "20")));

        if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "20")))) {
            description.setTextSize(Float.parseFloat(String.valueOf(textValue)));
            description.refreshDrawableState();
        } else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "22")))) {
            description.setTextSize(Float.parseFloat(String.valueOf(textValue)));
            description.refreshDrawableState();
        } else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "24")))) {
            description.setTextSize(Float.parseFloat(String.valueOf(textValue)));
            description.refreshDrawableState();
        }else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "26"))))
            description.setTextSize(Float.parseFloat(String.valueOf(textValue)));
        description.refreshDrawableState();
        super.onResume();
    }

    public class CustomListViewAdapter extends ArrayAdapter<ListViewItem>{

        public CustomListViewAdapter(@NonNull Context context, ArrayList<ListViewItem> items) {
            super(context, 0,items);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item,parent,false);
                TextView name = convertView.findViewById(R.id.name);
                name.setText(getItem(position).getName());
            }

            return convertView;
        }
    }


}