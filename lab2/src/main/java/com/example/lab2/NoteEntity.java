package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class NoteEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    public NoteEntity(@NonNull String note) {this.mNote = note;}

    public String getNote(){return this.mNote;}
}