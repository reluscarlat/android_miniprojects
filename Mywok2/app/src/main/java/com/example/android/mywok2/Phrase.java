package com.example.android.mywok2;

public class Phrase {
    private String phraseName;
    private String translatedPhrase;

    public Phrase(String phraseName, String translatedPhrase) {
        this.phraseName = phraseName;
        this.translatedPhrase = translatedPhrase;
    }

    public String getPhraseName() {
        return phraseName;
    }

    public void setPhraseName(String phraseName) {
        this.phraseName = phraseName;
    }

    public String getTranslatedPhrase() {
        return translatedPhrase;
    }

    public void setTranslatedPhrase(String translatedPhrase) {
        this.translatedPhrase = translatedPhrase;
    }
}
