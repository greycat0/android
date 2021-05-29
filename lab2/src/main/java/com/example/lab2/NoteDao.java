package com.example.lab2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(NoteEntity word);

    @Query("DELETE FROM note_table WHERE note = :mNote")
    void delete(String mNote);

    @Query("SELECT * FROM note_table ORDER BY note ASC")
    LiveData<List<NoteEntity>> getAlphabetizedNotes();
}