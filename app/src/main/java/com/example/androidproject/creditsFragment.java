package com.example.androidproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link creditsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class creditsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int mParam3;

    public creditsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment creditsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static creditsFragment newInstance(String param1, String param2,int param3) {
        creditsFragment fragment = new creditsFragment();
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
        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle);

        ArrayList<credit> terms = new ArrayList<>();

        terms.add(new credit("BANNER", "Photo by Joel Rohland on Unsplash - banner", R.drawable.banner));
        terms.add(new credit("IMAGE WELCOME 1","Photo by Adam Birkett on Unsplash", R.drawable.first));
        terms.add(new credit("IMAGE WELCOME 2","Image by 3D Animation Production Company from Pixabay", R.drawable.second));
        terms.add(new credit("IMAGE WELCOME 3","Photo by Bram Van Oost on Unsplash", R.drawable.third));
        terms.add(new credit("IMAGE WELCOME 4","Image by Bruno /Germany from Pixabay", R.drawable.forth));
        terms.add(new credit("STEP 1 TROUBLE","Photo by Simon Abrams on Unsplash", R.drawable.trouble));
        terms.add(new credit("STEP 2 ANALYSIS","Photo by John Schnobrich on Unsplash", R.drawable.analysis));
        terms.add(new credit("STEP 3 TICKET","Photo by Tim van der Kuip on Unsplash", R.drawable.last));
        terms.add(new credit("STEP 4 REPAIR","Photo by Nikolai Chernichenko on Unsplash", R.drawable.service));
        terms.add(new credit("STEP 5 SERVICE","Photo by Annie Spratt on Unsplash", R.drawable.pickup));
        terms.add(new credit("SPIRAL CREDITS","Image by Pixel_perfect from Pixabay", R.drawable.spiral));

        //layout manager

//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //adaptor
        recyclerView.setAdapter(new CustomRecyclerViewAdaptor(terms));
        return view;
    }
}