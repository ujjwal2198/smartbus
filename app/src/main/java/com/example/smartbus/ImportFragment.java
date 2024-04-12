package com.example.smartbus;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Y on 10/13/2018.
 import android.view.ViewGroup;
 */

public class ImportFragment extends android.support.v4.app.Fragment {
    public ImportFragment() {
    }
int a=0;
    String go;
    EditText TrackCode;
    String track;
    String mParam1;
    Button b;
    ListView listViewArtists;
TextView textCheck;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            mParam1 = user.getPhoneNumber();
Toast.makeText(getActivity(),"bhai dikh ja",Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_import, null);
        Toast.makeText(getActivity(), "view3 wale me fragment me hu gi", Toast.LENGTH_SHORT).show();
        TrackCode = (EditText)view.findViewById(R.id.track_code);

        b=(Button)view.findViewById(R.id.bhai_button);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     track=TrackCode.getText().toString();

                                     DatabaseReference  postRef = FirebaseDatabase.getInstance().getReference("bus");
                                     final List<UserData> artistList=new ArrayList<>();
                                     //int p=Integer.parseInt(track);
                                     final Query query = postRef.orderByChild("Trackcode").equalTo(track);//by the check int string
                                     query.addListenerForSingleValueEvent(new ValueEventListener() {
                                         @Override
                                         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                             if(dataSnapshot.exists()) {


                                           //  DatabaseReference mmData=FirebaseDatabase.getInstance().getReference(ide+"/"+"id" );

                                                 Intent inent = new Intent(getActivity(), MapsActivity.class);

                                                 // calling an activity using <intent-filter> action name
                                                 //  Intent inent = new Intent("com.hmkcode.android.ANOTHER_ACTIVITY");

                                                 startActivity(inent);


                                          /*     for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                                                 // artistList.clear();
                                        bhai yha pr mere ko track code se matalb hai khali
                                          UserData artist = artistSnapshot.getValue(UserData.class);
                                                 artistList.add(artist);
     Toast.makeText(getActivity(),"yha "+artistList.get(0).getName(),Toast.LENGTH_LONG).show();
     }*/

                                             }
                                             else
                                                 Toast.makeText(getActivity(),"Invalid Code",Toast.LENGTH_SHORT).show();


                                         }

                                         @Override
                                         public void onCancelled(@NonNull DatabaseError databaseError) {
                                             Toast.makeText(getActivity(),"yhI PR AAHA ",Toast.LENGTH_LONG).show();
                                         }
                                     });

                                 }
                             });

       // textCheck=(TextView)view.findViewById(R.id.track);


        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("key");
            Toast.makeText(getActivity(), "create view ka situation"+mParam1, Toast.LENGTH_SHORT).show();
        }



    }



}





