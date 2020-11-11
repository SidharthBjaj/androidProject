package com.example.androidproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nav_contact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nav_contact extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public nav_contact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nav_contact.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_contact newInstance(String param1, String param2) {
        nav_contact fragment = new nav_contact();
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
        View view = inflater.inflate(R.layout.fragment_nav_contact, container, false);

        Button callButton = view.findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel: 5199816764");
                Intent intent = new Intent(Intent.ACTION_DIAL,number);
                startActivity(intent);
            }
        });

        Button emailButton = view.findViewById(R.id.askButton2);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[]emailAddress={"sb124@myscc.ca"};
                String[]ccEmailAddress={"techSupport@tgenics.ca"};

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,emailAddress);
                intent.putExtra(Intent.EXTRA_CC,ccEmailAddress);
                intent.putExtra(Intent.EXTRA_TEXT, "Some of the problems I am facing with my device are :- ");
                startActivity(intent);
            }
        });

        Button textButton = view.findViewById(R.id.msgButton);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"));
                intent.putExtra("sms body: ", "Some of my concerns regarding the device are :- ");
                startActivity(intent);
            }
        });

        Button locationButton = view.findViewById(R.id.locButton);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=42.2484642,-83.0225078(St Clair College)");
                Intent intent = new Intent(Intent.ACTION_VIEW,location);
                startActivity(intent);
            }
        });

        Button websiteButton = view.findViewById(R.id.websiteButton);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Uri uriUrl = Uri.parse("https://www.stclaircollege.ca/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            }
        });

        Button facebookButton = view.findViewById(R.id.faceButton);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Uri uriUrl = Uri.parse("https://www.facebook.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            }
        });

        return view;
    }
}