package com.example.smartbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by Y on 10/14/2018.
 */

public class profile extends Fragment {
    TextView name,email,mobile;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav_slideshow, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getActivity(), "slideshow wale me", Toast.LENGTH_SHORT).show();
        name= view.findViewById(R.id.name_gi);
        email=view.findViewById(R.id.email_gi);
        mobile=view.findViewById(R.id.mobile_gi);


    }
}
