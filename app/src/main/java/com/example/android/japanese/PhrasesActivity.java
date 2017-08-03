package com.example.android.japanese;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word ("Where are you going?", "Doko ni iku no?", R.raw.phrase_where_are_you_going));
        words.add(new Word ("What is your name?", "Anata no namae wa nan desu ka?", R.raw.phrase_what_is_your_name));
        words.add(new Word ("My name is...", "Watashi no namae wa...", R.raw.phrase_my_name_is));
        words.add(new Word ("How are you feeling?", "O genki desuka?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word ("I’m feeling good.", "Genki desu.", R.raw.phrase_im_feeling_good));
        words.add(new Word ("Are you coming?", "Kimasu ka?", R.raw.phrase_are_you_coming));
        words.add(new Word ("Yes, I'm coming.", "Hai, ima ikimasu.", R.raw.phrase_yes_im_coming));
        words.add(new Word ("I’m coming.", "Ima ikimasu", R.raw.phrase_im_coming));
        words.add(new Word ("Let's go.", "Ikimashō", R.raw.phrase_lets_go));
        words.add(new Word ("Come here, please", "Kite kudasai", R.raw.phrase_come_here));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listlayout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioFileId());
                mediaPlayer.start();
            }


        });

    }
}