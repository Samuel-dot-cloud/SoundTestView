package com.studiofive.soundtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Model> list = new ArrayList();
        list.add(new Model(Model.TEXT_TYPE, 0, "Hello. This is the Text-only View Type. Nice to meet you"));
        list.add(new Model(Model.IMAGE_TYPE, R.drawable.download, "Hi. I display a cool image too besides the omnipresent TextView."));
        list.add(new Model(Model.AUDIO_TYPE, R.raw.sound, "Hey. Pressing the FAB button will playback an audio file on loop."));
        list.add(new Model(Model.AUDIO_TYPE, R.raw.move, "Another sound file example."));
        list.add(new Model(Model.IMAGE_TYPE, R.drawable.download, "Hi again. Another cool image here. Which one is better?"));

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }
}
