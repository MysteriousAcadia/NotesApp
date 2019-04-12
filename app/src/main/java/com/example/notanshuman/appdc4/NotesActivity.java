package com.example.notanshuman.appdc4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class NotesActivity extends AppCompatActivity {

    EditText titleText;
    EditText bodyText;
    ImageButton buttonSave;
    DatabaseReference nameDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        setContentView(R.layout.activity_notes);
        titleText = findViewById(R.id.titleEditText);
        bodyText = findViewById(R.id.bodyEditText);
        buttonSave = findViewById(R.id.button_save);
        nameDatabase = FirebaseDatabase.getInstance().getReference();


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title,body;
                title = titleText.getText().toString();
                body = bodyText.getText().toString();
                Map note = new HashMap();
                note.put("title",title);
                note.put("body",body);
                String key = nameDatabase.push().getKey();
                note.put("key",key);
                nameDatabase.child("Diary").push().setValue(note);
                //nameDatabase.child("Diary").child().child(name).setValue(bo);

                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);

            }
        });


    }
}
