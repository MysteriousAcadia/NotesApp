package com.example.notanshuman.appdc4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2;
    RecyclerView recyclerViewLeft;
    RecyclerView recyclerViewRight;


    DatabaseReference nameDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // nameTextView=findViewById(R.id.Name);
//        title=findViewById(R.id.nameTextEdit);
          btn=findViewById(R.id.button);
          btn2=findViewById(R.id.button5);
//        body=findViewById(R.id.editText);
        nameDatabase = FirebaseDatabase.getInstance().getReference();
        recyclerViewLeft = findViewById(R.id.note_view_left);
        recyclerViewRight = findViewById(R.id.note_view_right);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),NotesActivity.class);
                Log.e("Debug","Done  loading new page");
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
                startActivity(intent);
            }
        });




        nameDatabase.child("Diary").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean flag = false;
                ArrayList<NotesModel> noteLeft = new ArrayList<>();
                ArrayList<NotesModel> noteRight = new ArrayList<>();
                for (DataSnapshot noteSnapshot : dataSnapshot.getChildren()) {
                    String title = noteSnapshot.child("title").getValue().toString();
                    String body = noteSnapshot.child("body").getValue().toString();
                    String id = noteSnapshot.child("key").getValue().toString();
                    if (flag) {
                        noteLeft.add(new NotesModel(title, body, id));
                    } else {
                        noteRight.add(new NotesModel(title, body, id));

                    }
                    flag = !flag;
                }
                Log.e("Debug", "Done with data");
                recyclerViewLeft.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                recyclerViewRight.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                NotesAdapter notesAdapterLeft = new NotesAdapter(noteLeft);
                NotesAdapter notesAdapterRight = new NotesAdapter(noteRight);
                recyclerViewLeft.setAdapter(notesAdapterLeft);
                recyclerViewRight.setAdapter(notesAdapterRight);
                Log.e("Debug", "Done with showing data");

            }




              //  String name = dataSnapshot.child("names").child("name_02").child("name").getValue().toString();
//                nameTextView.setText(name);




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Classmate","databaseError.toString()");

            }
        });




    }
}
