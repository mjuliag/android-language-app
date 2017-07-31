package com.example.android.japanese;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> words = new ArrayList<Word>();
        mediaPlayer = MediaPlayer.create(this, R.raw.number_one);


        words.add(new Word("one", "ichi", R.drawable.number_one));
        words.add(new Word("two", "ni", R.drawable.number_two));
        words.add(new Word("three", "san", R.drawable.number_three));
        words.add(new Word("four", "yon", R.drawable.number_four));
        words.add(new Word("five", "go", R.drawable.number_five));
        words.add(new Word("six", "roku", R.drawable.number_six));
        words.add(new Word("seven", "nana", R.drawable.number_seven));
        words.add(new Word("eight", "hachi", R.drawable.number_eight));
        words.add(new Word("nine", "kyuu", R.drawable.number_nine));
        words.add(new Word("ten", "juu", R.drawable.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listlayout file.
        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mediaPlayer.start();
            }


        });


        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }
}
