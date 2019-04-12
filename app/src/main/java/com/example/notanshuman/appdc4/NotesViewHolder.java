package com.example.notanshuman.appdc4;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NotesViewHolder extends RecyclerView.ViewHolder {

    TextView title,body;
    CardView noteCard;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.note_title);
        body = itemView.findViewById(R.id.note_body);
        noteCard = itemView.findViewById(R.id.note_card_view);
    }
}
