package com.example.android.japanese;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersFragment extends Fragment {

    private MediaPlayer mediaPlayer;

    private AudioManager audioManager;


   private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

            audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

            final ArrayList<Word> words = new ArrayList<Word>();

            words.add(new Word("one", "ichi", R.drawable.number_one, R.raw.number_one));
            words.add(new Word("two", "ni", R.drawable.number_two, R.raw.number_two));
            words.add(new Word("three", "san", R.drawable.number_three, R.raw.number_three));
            words.add(new Word("four", "yon", R.drawable.number_four, R.raw.number_four));
            words.add(new Word("five", "go", R.drawable.number_five, R.raw.number_five));
            words.add(new Word("six", "roku", R.drawable.number_six, R.raw.number_six));
            words.add(new Word("seven", "nana", R.drawable.number_seven, R.raw.number_seven));
            words.add(new Word("eight", "hachi", R.drawable.number_eight, R.raw.number_eight));
            words.add(new Word("nine", "kyuu", R.drawable.number_nine, R.raw.number_nine));
            words.add(new Word("ten", "juu", R.drawable.number_ten, R.raw.number_ten));

            // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
            // adapter knows how to create list items for each item in the list.
            WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

            // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
            // There should be a {@link ListView} with the view ID called list, which is declared in the
            // words_listlayout file.
            final ListView listView = (ListView) rootView.findViewById(R.id.list);


            // Make the {@link ListView} use the {@link WordAdapter} we created above, so thathe
            // {@link ListView} will display list items for each {@link Word} in the list.
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Word word = words.get(position);
                    releaseMediaPlayer();

                    // Request audio focus for playback
                    int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // Request permanent focus.
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                        mediaPlayer = MediaPlayer.create(getActivity(), word.getAudioFileId());
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(completionListener);
                    }
                }


            });

        return rootView;
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);

        }
    }


}
