package com.example.lab2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.ui.home.HomeViewModel;

class NoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView wordItemView;

    private NoteViewHolder(View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.textView);
        Button deleteButton = itemView.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(v -> HomeViewModel.mRepository.delete(wordItemView.getText().toString()));
    }

    public void bind(String text) {
        wordItemView.setText(text);
    }

    static NoteViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new NoteViewHolder(view);
    }
}