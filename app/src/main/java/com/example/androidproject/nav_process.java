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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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

        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.roll);
        view.startAnimation(animation);
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
                    return ViewPagerFragment.newInstance("BASIC TROUBLESHOOTING","We Will Run Basic Scans for troubleshooting your devices for viruses or any sort of software issue or we can schedule an appointment on remote desktop software\n\n\n- Run Basic Scan\n- Scan for software issues. \n- Remote Desktop Assistance","30 Mins - 1 Hour",R.drawable.trouble);
                case 1:
                    return ViewPagerFragment.newInstance("DROP OFF ITEM","Bring your device to TECH GENICS (without any case,carrying case, etc.)\n\n\n- Please keep your data backed up\n- No Re-installation of software's\n  without written permission.\n- NOTE - WE ARE NOT RESPONSIBLE \n  FOR ANY DATA LOSS","30 Mins - Appointment",R.drawable.analysis);
                case 2:
                    return ViewPagerFragment.newInstance("CREATE A SERVICE TICKET","Our Tech expert will assist you with checking the computer and present virtual ticket to you including a description of the issue as well as contact information\n\n- Device analysis\n- IT Ticket Generation with brief \n  description of issue\n- Get ticket in printed form","30 Mins - device analysis",R.drawable.service);
                case 3:
                    return ViewPagerFragment.newInstance("PICK UP YOUR ITEM","After the device's issues are resolved to the best of our abilities,you will receive a call or email for pickup.You may pick your item up at any time we are open.\n\n- Device repaired to our ability\n- Wait for call from our Rep\n- Pick up your device","3 - 5 Business Days",R.drawable.pickup);
                case 4:
                    return ViewPagerFragment.newInstance("RESOLVE CONTINUED ISSUES","If you notice any new or unresolved issues with your device,\n\n\n- Please reach out to us on -\n  (555)666-7777 or \n\n\n- Email us - techgenics@repair.ca","Work hours (10 AM - 6 PM)",R.drawable.last);
                default:
                    return ViewPagerFragment.newInstance("default","none","none",R.drawable.side_nav_bar);
            }
        }
        @Override
    public int getCount(){
        return 5;
        }
    }}