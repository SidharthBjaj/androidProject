package com.example.androidproject;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nav_hook#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nav_hook extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public nav_hook() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nav_hook.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_hook newInstance(String param1, String param2) {
        nav_hook fragment = new nav_hook();
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
        View view= inflater.inflate(R.layout.fragment_nav_hook, container, false);
        final EditText email = view.findViewById(R.id.emailEdit);
        final EditText phone = view.findViewById(R.id.phoneEdit);
        final EditText time = view.findViewById(R.id.timeEdit);
        final EditText info = view.findViewById(R.id.infoEdit);
        final EditText device = view.findViewById(R.id.deviceEdit);
        final EditText name = view.findViewById(R.id.nameEdit);


        Button button = view.findViewById(R.id.submitCallBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailfcb = email.getText().toString().trim();
                String phonefcb = phone.getText().toString().trim();
                String timefcb = time.getText().toString().trim();
                String infofcb = info.getText().toString().trim();
                String devicefcb = device.getText().toString().trim();
                String namefcb = name.getText().toString().trim();


                String[]emailAddress={"techgenics@repair.ca"};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,emailAddress);
                intent.putExtra(Intent.EXTRA_TEXT,"Hey there, It will be really helpful if you can call me at  - "+phonefcb+" \naround - "+timefcb+"" +
                        "\n My device "+devicefcb+" is facing some issues like :- "+infofcb+".\n Just in case if this is minor issue, " +
                        "you can also send me an email at "+emailfcb+ "\n Thank You \n"+namefcb);
                startActivity(intent);
//
            }
        });
        return view;
    }
}