package com.example.android.mywok2;

public class Color {
    private String color;
    private String translatedColor;
    private int colorImage;

    public Color(String color, String translatedColor, int colorImage) {
        this.color = color;
        this.translatedColor = translatedColor;
        this.colorImage = colorImage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTranslatedColor() {
        return translatedColor;
    }

    public void setTranslatedColor(String translatedColor) {
        this.translatedColor = translatedColor;
    }

    public int getColorImage() {
        return colorImage;
    }

    public void setColorImage(int colorImage) {
        this.colorImage = colorImage;
    }
}
