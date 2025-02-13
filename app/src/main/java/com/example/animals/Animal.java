package com.example.animals;

import android.widget.Button;

public class Animal {

    private String name;
    private Button button;
    private int picture, sound;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }


}
