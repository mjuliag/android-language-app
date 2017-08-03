package com.example.android.japanese;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("red", "aka", R.drawable.color_red, R.raw.color_black));
        words.add(new Word("green", "midori", R.drawable.color_green, R.raw.color_black));
        words.add(new Word("brown", "kasshoku", R.drawable.color_brown, R.raw.color_black));
        words.add(new Word("orange", "orenji", R.drawable.color_orange, R.raw.color_black));
        words.add(new Word("black", "kuro", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "shiro", R.drawable.color_white, R.raw.color_black));
        words.add(new Word("yellow", "kiiro", R.drawable.color_mustard_yellow, R.raw.color_black));
        words.add(new Word("blue", "ao", R.drawable.color_blue, R.raw.color_black));
        words.add(new Word("purple", "murasaki", R.drawable.color_purple, R.raw.color_black));
        words.add(new Word("pink", "pinku", R.drawable.color_pink, R.raw.color_black));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

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
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioFileId());
                mediaPlayer.start();
            }


        });

    }
}
