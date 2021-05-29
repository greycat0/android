package com.example.lab2.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lab2.NoteEntity;
import com.example.lab2.NoteRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private NoteRepository mRepository;

    private LiveData<List<NoteEntity>> mAllNotes;

    public HomeViewModel(Application application) {
        super(application);
        mText = new MutableLiveData<>();
        mRepository = new NoteRepository(application);
        mAllNotes = mRepository.getAllNotes();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setText(String text) {
        mText.setValue(text);
    }

    LiveData<List<NoteEntity>> getAllNotes() {
        return mAllNotes;
    }

    public void insertNote(NoteEntity note) {
        mRepository.insert(note);
    }
}