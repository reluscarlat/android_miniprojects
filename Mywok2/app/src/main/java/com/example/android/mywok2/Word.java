package com.example.android.mywok2;

import android.graphics.drawable.Drawable;

public class Word {
    private String number;
    private String translatedNumber;
    private int numberImage;
    private int sound;

    public Word(String number, String translatedNumber, int numberImage, int sound) {
        this.number = number;
        this.translatedNumber = translatedNumber;
        this.numberImage = numberImage;
        this.sound = sound;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTranslatedNumber() {
        return translatedNumber;
    }

    public void setTranslatedNumber(String translatedNumber) {
        this.translatedNumber = translatedNumber;
    }

    public int getNumberImage() {
        return numberImage;
    }

    public void setNumberImage(int numberImage) {
        this.numberImage = numberImage;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
