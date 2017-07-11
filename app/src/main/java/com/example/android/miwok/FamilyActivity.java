package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word ("father", "otōsan"));
        words.add(new Word ("mother", "okasan"));
        words.add(new Word ("son", "musuko"));
        words.add(new Word ("daughter", "musume"));
        words.add(new Word ("older brother", "ani"));
        words.add(new Word ("younger brother", "otōto"));
        words.add(new Word ("older sister", "ane"));
        words.add(new Word ("younger sister", "imouto"));
        words.add(new Word ("grandmother", "obāsan"));
        words.add(new Word ("grandfather", "ojīsan"));


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
