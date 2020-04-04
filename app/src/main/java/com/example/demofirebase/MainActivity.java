package com.example.demofirebase;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demofirebase.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnSuccessListener<Void>, OnFailureListener, ValueEventListener {
    private ActivityMainBinding binding;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference;
    private AdapterChat adapterChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        adapterChat = new AdapterChat(this);
        binding.lisTex.setAdapter(adapterChat);
        reference = database.getReference("chat");
        binding.imageBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String msg = binding.edtText.getText().toString();
        if (msg.isEmpty()){
            Toast.makeText(this,"Message can not empty",Toast.LENGTH_LONG).show();
            return;
        }
        Chat chat = new Chat();
        chat.setMessage(msg);
        chat.setName("BacNV");
        reference.child(chat.getId()+"").setValue(chat).addOnSuccessListener(this).addOnFailureListener(this);
        reference.addValueEventListener(this);
    }

    @Override
    public void onSuccess(Void aVoid) {
        Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        ArrayList<Chat>arrayList = new ArrayList<>();
        for(DataSnapshot  data :dataSnapshot.getChildren()){
            Chat chat = data.getValue(Chat.class);
            arrayList.add(chat);
        }
        adapterChat.setData(arrayList);
        binding.lisTex.scrollToPosition(arrayList.size()-1);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
