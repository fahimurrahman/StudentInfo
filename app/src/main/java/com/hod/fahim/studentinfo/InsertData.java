package com.hod.fahim.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hod.fahim.studentinfo.model.User;

import java.util.UUID;

public class InsertData extends AppCompatActivity {

    EditText name_product, available_product, price_product;
    Button save_button;
    ImageView product_image;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    //User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        name_product = findViewById(R.id.name_editText);
        available_product = findViewById(R.id.availabel_editText2);
        price_product = findViewById(R.id.price_editText3);

        save_button = findViewById(R.id.save_button);
        product_image = findViewById(R.id.product_imageView);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                startActivity(new Intent(InsertData.this,DashBoard.class));
            }
        });

        initFirebase();
    }

    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void createUser() {
        User user1 = new User(UUID.randomUUID().toString(),name_product.getText().toString(),
                available_product.getText().toString(),price_product.getText().toString());

        databaseReference.child("user").child(user1.getUid()).setValue(user1);
        clearEditText();
    }

    private void clearEditText() {
        name_product.setText("");
        available_product.setText("");
        price_product.setText("");
    }
}
