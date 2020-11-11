package com.example.androidproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nav_process#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nav_process extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public nav_process() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nav_process.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_process newInstance(String param1, String param2) {
        nav_process fragment = new nav_process();
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
        View view = inflater.inflate(R.layout.fragment_nav_process, container, false);
        CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.accessContent);
        viewPager.setAdapter(adapter);
        return view;
    }

    public class  CustomViewPagerAdapter extends FragmentPagerAdapter {


        public CustomViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        int resId = 0;
        @NonNull
        @Override
        public ViewPagerFragment getItem(int position) {
            switch (position) {
                case 0:
                    return ViewPagerFragment.newInstance("first","first desc","timeline 1",R.drawable.ic_baseline_contact_phone_24);
                case 1:
                    return ViewPagerFragment.newInstance("second","second desc","timeline 2",R.drawable.ic_baseline_contactless_24);
                case 2:
                    return ViewPagerFragment.newInstance("third","third desc","timeline 3",R.drawable.ic_baseline_mobile_friendly_24);
                case 3:
                    return ViewPagerFragment.newInstance("forth","forth desc","timeline 4",R.drawable.ic_baseline_sync_problem_24);
                case 4:
                    return ViewPagerFragment.newInstance("fifth","fifth desc","timeline 5",R.drawable.ic_baseline_open_in_browser_24);
                default:
                    return ViewPagerFragment.newInstance("default","none","none",R.drawable.side_nav_bar);
            }
        }
        @Override
    public int getCount(){
        return 5;
        }
    }}