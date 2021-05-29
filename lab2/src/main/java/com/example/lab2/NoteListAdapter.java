package com.example.lab2;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class NoteListAdapter extends ListAdapter<NoteEntity, NoteViewHolder> {

    public NoteListAdapter(@NonNull DiffUtil.ItemCallback<NoteEntity> diffCallback) {
        super(diffCallback);
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return NoteViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        NoteEntity current = getItem(position);
        holder.bind(current.getNote());
    }

    public static class WordDiff extends DiffUtil.ItemCallback<NoteEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull NoteEntity oldItem, @NonNull NoteEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull NoteEntity oldItem, @NonNull NoteEntity newItem) {
            return oldItem.getNote().equals(newItem.getNote());
        }
    }
}