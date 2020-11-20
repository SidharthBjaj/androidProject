package com.example.androidproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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

    SharedPreferences sharedPreferences;
    TextView description;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int mParam3;

    public nav_tips() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param param3 Parameter 3.
     * @return A new instance of fragment nav_tips.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_tips newInstance(String param1, String param2,int param3) {
        nav_tips fragment = new nav_tips();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_tips, container, false);


        final ListView listView = view.findViewById(R.id.DataTypeList);
        description = view.findViewById(R.id.item_description);


        ArrayList<ListViewItem> dataTypeItemArrayList = new ArrayList<>();
        dataTypeItemArrayList.add(new ListViewItem("UNINSTALL OLD APPLICATION","The best thing to do in order to keep your phone healthy is to go through\n" +
                "        your applications and delete those that you no longer use."));
        dataTypeItemArrayList.add(new ListViewItem("KEEP YOUR SOFTWARE UPDATED","Regardless of whether you run iOS or Android, it’s vitally important for your phone’s health\n" +
                "        that you keep the software up-to-date.\n" +
                "        These usually have bug fixes and updates which fix issues on the device"));

        dataTypeItemArrayList.add(new ListViewItem("AVOID OVER CHARGING","Most modern phones aren’t really supposed to be charged to the max, nor are they meant to run out of battery completely.\n" +
                "        This is due to how the batteries are designed"));

        dataTypeItemArrayList.add(new ListViewItem("INSURE YOU DEVICE","This may seem obvious, but a fairly easy way to make sure that your mobile phone remains in good\n" +
                "        shape is to invest in comprehensive phone insurance."));

        dataTypeItemArrayList.add(new ListViewItem("AVOID USING IN EXTREME TEMPS","The health of your smartphone is very dependent on how well the battery operates. A sure-fire way of putting the battery under undue strain is to expose your smartphone to\n" +
                "        extreme temperatures – both hot and cold."));

        dataTypeItemArrayList.add(new ListViewItem("LOW POWER MODE","Most, if not all, modern smartphones have some form of low-power mode, which reduced functionality in order\n" +
                "        to preserve battery life and power. try to utilize this feature as much as possible"));

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,dataTypeItemArrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                description.setText(((ListViewItem)listView.getItemAtPosition(position)).getDescription());
            }
        });


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

//        if (sharedPreferences.getBoolean("size", Boolean.parseBoolean("22sp"))) {
//            description.setTextSize(22);
//        }
//        if (sharedPreferences.getBoolean("size", Boolean.parseBoolean("20sp"))) {
//            description.setTextSize(Float.parseFloat("28sp"));
//            dataTypeItemArrayList.toString().toUpperCase();
//        }
        return view;
    }


}