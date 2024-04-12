package com.example.smartbus;
//this for the main activity.
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText name,email,number;
    String nam,emai,numbe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signUp(View view)
    {
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        number=(EditText)findViewById(R.id.mobile);

        nam=name.getText().toString().trim();
        emai=email.getText().toString().trim();
        numbe=number.getText().toString().trim();
        HashMap<String,String> dataMap=new HashMap<String, String>();
        dataMap.put("name",nam);
        dataMap.put("email",emai);
        dataMap.put("number",numbe);

        int index = emai.indexOf('@');
        emai = emai.substring(0,index);

        DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference(emai+"/Profile");
        Toast.makeText(this,"kam q",Toast.LENGTH_SHORT).show();
        mDatabase.setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"updated data",Toast.LENGTH_SHORT).show();
                 //   FragmentManager manager=getSupportFragmentManager();
              //      FragmentTransaction t=manager.beginTransaction();
                    Bundle b2=new Bundle();
                    b2.putString("key",emai);
                  ImportFragment m=new ImportFragment();
                m.setArguments(b2);
                //    t.add(R.id.screen_area,m);
                  //  t.commit();

                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);


                }
                else
                    Toast.makeText(MainActivity.this,"Error in uploading",Toast.LENGTH_SHORT).show();
            }
        });




    }

}
