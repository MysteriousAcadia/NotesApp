package com.example.notanshuman.appdc4;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

public class NotesModel {
    String title;
    String body;
    String id;
    int noteColor;

     NotesModel(String title,String body,String id){
        this.title=title;
        this.body=body;
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
