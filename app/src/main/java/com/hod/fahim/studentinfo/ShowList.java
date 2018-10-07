package com.hod.fahim.studentinfo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hod.fahim.studentinfo.adapter.ListViewAdapter;
import com.hod.fahim.studentinfo.model.User;

import java.util.ArrayList;
import java.util.List;

public class ShowList extends AppCompatActivity {

    ListView listView;
    ProgressBar progressBar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<User> list= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        listView = findViewById(R.id.lists);
        progressBar = findViewById(R.id.progressBar);

        initFirebase();
        addEventFirebaseListener();
    }

    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference();
    }

    private void addEventFirebaseListener() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);

        databaseReference.child("user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (list.size()>0){
                    list.clear();
                }
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    list.add(user);
                }
                ListViewAdapter listViewAdapter = new ListViewAdapter(ShowList.this,list);
                listView.setAdapter(listViewAdapter);

                progressBar.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
