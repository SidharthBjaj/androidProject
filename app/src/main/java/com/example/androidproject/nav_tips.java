package com.example.androidproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        final ListView listView = view.findViewById(R.id.DataTypeList);
        description = view.findViewById(R.id.item_description);

        ArrayList<ListViewItem> dataTypeItemArrayList = new ArrayList<>();
        dataTypeItemArrayList.add(new ListViewItem("First Tip","This is first Tip"));
        dataTypeItemArrayList.add(new ListViewItem("Second Tip","This is second Tip"));
        dataTypeItemArrayList.add(new ListViewItem("third Tip","This is third Tip"));
        dataTypeItemArrayList.add(new ListViewItem("Forth tip","This is forth Tip"));
        dataTypeItemArrayList.add(new ListViewItem("Fifth tip","This is fifth Tip"));
        dataTypeItemArrayList.add(new ListViewItem("Sixth tip","This is sixth Tip"));

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,dataTypeItemArrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                description.setText(((ListViewItem)listView.getItemAtPosition(position)).getDescription());
            }
        });
        return view;
    }


}