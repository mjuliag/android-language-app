package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word ("red", "aka"));
        words.add(new Word ("green", "midori"));
        words.add(new Word ("brown", "kasshoku"));
        words.add(new Word ("orange", "orenji"));
        words.add(new Word ("black", "kuro"));
        words.add(new Word ("white", "shiro"));
        words.add(new Word ("yellow", "kiiro"));
        words.add(new Word ("blue", "ao"));
        words.add(new Word ("purple", "murasaki"));
        words.add(new Word ("pink", "pinku"));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listlayout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }
}
