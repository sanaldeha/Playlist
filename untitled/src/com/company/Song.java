package com.company;

public class Song {
    private String title;
    private int duration;

    public Song (String title, int duration){
        this.title = title;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle(){
        return title;
    }
}
