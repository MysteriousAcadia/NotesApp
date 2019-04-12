package com.example.notanshuman.appdc4;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    private ArrayList<NotesModel> notesModel;

    public NotesAdapter(ArrayList<NotesModel> arr){notesModel=arr;}

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.notes_view_holder, viewGroup, false);
        NotesViewHolder notesViewHolder=new NotesViewHolder(view);
        //  Log.e("oncreateviewholder", "on createv view holder, no position");
        return notesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder notesViewHolder, int i) {
        notesViewHolder.title.setText(notesModel.get(notesModel.size()-1-i).getTitle());
        notesViewHolder.body.setText(notesModel.get(notesModel.size()-1-i).getBody());
        //notesViewHolder.noteCard.setCardBackgroundColor(notesModel);

    }


    @Override
    public int getItemCount() {
        return notesModel.size();
    }
}
