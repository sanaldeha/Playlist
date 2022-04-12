package com.company;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Album album = new Album("Close to the Edge");
    private static ArrayList<Album> albums = new ArrayList<Album>();
    private static LinkedList<Song> playlist = new LinkedList<Song>();
    private static boolean goingForward = true;
    private static ListIterator<Song> songIterator = playlist.listIterator();

    public static void main(String[] args) {



        albums.add(album);
        album.addSongToAlbum("Close to the edge", 180);
        album.addSongToAlbum("And you and I", 240);


        application();






    }

    private static void addSong(){
        System.out.println("Enter the name of the song you want to add: ");
        String name = scanner.nextLine();
        if (songInAlbum(name, albums)){
            playlist.add(getSongInAlbum(name, albums));
            System.out.println("Added to the playlist.");
        } else {
            System.out.println("Song does not exist in an album.");
        }
    }

    private static boolean songInAlbum(String name, ArrayList<Album> albums){
        Iterator<Album> albumIterator = albums.iterator();
        boolean flag = true;

        while (flag){
            if (albumIterator.next().getSongTitle(name)){
                flag = false;
                return true;
            } else if (!albumIterator.hasNext()){
                flag = false;
                return false;
            }
        }
        return false;
    }

    private static Song getSongInAlbum(String name, ArrayList<Album> albums){
        Iterator<Album> albumIterator = albums.iterator();
        boolean flag = true;
        Album album = albumIterator.next();

        while (flag){
            if (album.getSongTitle(name)){
                flag = false;
                return album.getSong(name);
            }
        }
        return null;
    }

    private static void printPlaylist(){
        //DO WITH LIST ITERATOR MAYBE YOU WILL HAVE A CHANCE YOU IDIOT
        //THIS FUNCTION SHOULD JUST PRINT THE PLAYLIST
        //REPLAY AND SKIP FUNCTIONS WILL ACTUALLY PRINT OUT THE CURRENT


    }

    private static void replayCurrentSong(){
        ListIterator<Song> songIterator = playlist.listIterator();
        if (playlist.listIterator().hasPrevious()){
            playlist.listIterator().previous();
        }
    }

    private static void removeCurrentSong(){
        System.out.println("I DO NOTHING.");
    }

    private static void skipForward(){
            if (!goingForward){
                if (songIterator.hasNext()) {
                    goingForward = true;
                    Song currentSong = songIterator.next();
                }
            }
            if (songIterator.hasNext()){
                Song currentSong = songIterator.next();
                System.out.println("Now playing: " + currentSong.getTitle());

            } else{
                System.out.println("It's the end of the playlist, baby.");
                goingForward = false;
            }
        }

    private static void skipBackwards(){
        ListIterator<Song> songIterator = playlist.listIterator();
        if(playlist.listIterator().hasPrevious()){
            if (goingForward){
                playlist.listIterator().previous();
            }
            playlist.listIterator().previous();
        } else {
            System.out.println("It's the beginning of the playlist, baby.");
        }
    }

    private static void application(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        printMenu();

        while (flag){
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printPlaylist();
                    break;
                case 1:
                    addSong();
                    break;
                case 2:
                    skipForward();
                    break;
                case 3:
                    skipBackwards();
                    break;
                case 4:
                    replayCurrentSong();
                    break;
                case 5:
                    removeCurrentSong();
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    flag = false;
                    System.out.println("Exiting application...");
                    break;
            }
        }

    }

    private static void printMenu(){
        System.out.println("0 - Show Current Playlist \n" +
                "1 - Add Song to Playlist \n" +
                "2- Skip forward to the next song \n" +
                "3- Skip backwards to the previous song \n" +
                "4 - Replay the current song \n" +
                "5- Remove current song \n" +
                "6- Show options again \n" +
                "7- Quit Application");
    }
}
