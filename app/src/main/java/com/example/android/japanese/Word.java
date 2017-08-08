package com.example.android.japanese;

/**
 * Created by julia on 7/6/2017.
 */

public class Word {

    /**
     * Default translation for the word
     */
    private String defaultTranslations;

    /**
     * japanese translation for the word
     */
    private String japaneseTranslations;


    /**
     * image for the word
     */
    private int imageResourceIds = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int audioFileId;


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation  is the word in a language that the user is already familiar with
     *                            (such as English)
     * @param japaneseTranslation is the word in the japanese language
     */
    public Word(String defaultTranslation, String japaneseTranslation, int audioFileIds) {
        defaultTranslations = defaultTranslation;
        japaneseTranslations = japaneseTranslation;
        audioFileId = audioFileIds;

    }


    public Word(String defaultTranslation, String japaneseTranslation, int imageResourceId, int audioFileIds) {
        defaultTranslations = defaultTranslation;
        japaneseTranslations = japaneseTranslation;
        imageResourceIds = imageResourceId;
        audioFileId = audioFileIds;

    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return defaultTranslations;
    }

    /**
     * Get the japanese translation of the word.
     */
    public String getjapaneseTranslation() {
        return japaneseTranslations;
    }

    /**
     * Get the image of the word.
     */
    public int getImageResourceId() {
        return imageResourceIds;
    }

    public boolean hasImage() {

        return imageResourceIds != NO_IMAGE_PROVIDED;
    }

    public int getAudioFileId() {
        return audioFileId;
    }

}