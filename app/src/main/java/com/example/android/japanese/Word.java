package com.example.android.japanese;

/**
 * Created by julia on 7/6/2017.
 */

public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** japanese translation for the word */
    private String mjapaneseTranslation;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param japaneseTranslation is the word in the japanese language
     */
    public Word(String defaultTranslation, String japaneseTranslation) {
        mDefaultTranslation = defaultTranslation;
        mjapaneseTranslation = japaneseTranslation;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the japanese translation of the word.
     */
    public String getjapaneseTranslation() {
        return mjapaneseTranslation;
    }

}