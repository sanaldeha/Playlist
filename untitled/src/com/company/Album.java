package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Album {
    private String name;
    private List<Song> songList;

    public Album(String name){
        this.name = name;
        this.songList = new ArrayList<Song>();
    }

    public void addSongToAlbum(String name, int duration){
        if (getSongTitle(name)){
            System.out.println("Song with the same name already exists.");
        } else {
            songList.add(new Song(name, duration));
            System.out.println("Song successfully added to album.");
        }
    }

    public boolean getSongTitle(String name){
        Iterator<Song> iterator = songList.iterator();
        boolean flag = true;

        while (flag){
            if (!iterator.hasNext()){
                flag = false;
                return false;
            } else {
                Song song = iterator.next();
                if (song.getTitle().equals(name)){
                    flag = false;
                    return true;
                }
            }
        }
        return false;
    }

    public Song getSong(String name){
        Iterator<Song> iterator = songList.iterator();
        boolean flag = true;

        while (flag){
            Song song = iterator.next();
            if (song.getTitle().equals(name)){
                flag = false;
                return song;
            }
        }
        return null;
    }
}

