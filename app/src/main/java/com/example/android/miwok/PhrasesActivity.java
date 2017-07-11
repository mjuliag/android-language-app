package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word ("Where are you going?", "Doko ni iku no?"));
        words.add(new Word ("What is your name?", "Anata no namae wa nan desu ka?"));
        words.add(new Word ("My name is...", "Watashi no namae wa..."));
        words.add(new Word ("How are you feeling?", "O genki desuka?"));
        words.add(new Word ("I’m feeling good.", "Genki desu."));
        words.add(new Word ("Are you coming?", "Kimasu ka?"));
        words.add(new Word ("Yes, I'm coming.", "Hai, ima ikimasu."));
        words.add(new Word ("I’m coming.", "Ima ikimasu"));
        words.add(new Word ("Let's go.", "Ikimashō"));
        words.add(new Word ("Come here, please", "Kite kudasai"));


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