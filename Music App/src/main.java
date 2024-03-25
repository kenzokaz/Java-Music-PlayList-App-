import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("A Night at the Opera", "Queen");

        album.addSong("Death on Two Legs (Dedicated to...)", 3.43);
        album.addSong("Lazing on a Sunday Afternoon", 1.08);
        album.addSong("I'm in Love with My Car", 3.05);
        album.addSong("You're My Best Friend", 2.52);
        album.addSong("'39", 3.30); 
        album.addSong("Sweet Lady", 4.03);
        album.addSong("Seaside Rendezvous", 2.13);
        album.addSong("The Prophet's Song", 8.21);
        album.addSong("Love of My Life", 3.38);
        album.addSong("Good Company", 3.23);
        album.addSong("Bohemian Rhapsody", 5.54); 
        album.addSong("God Save the Queen", 1.15);
        System.out.println();
        albums.add(album);
        
        album = new Album("In Utero", "Nirvana");
        
        album.addSong("Serve the Servants", 3.36);
        album.addSong("Scentless Apprentice", 3.47);
        album.addSong("Heart-Shaped Box", 4.41);
        album.addSong("Rape Me", 2.49);
        album.addSong("Frances Farmer Will Have Her Revenge on Seattle", 4.09);
        album.addSong("Dumb", 2.32);
        album.addSong("Very Ape", 1.55);
        album.addSong("Milk It", 3.54);
        album.addSong("Pennyroyal Tea", 3.37);
        album.addSong("Radio Friendly Unit Shifter", 4.51);
        album.addSong("tourette's", 1.33);
        album.addSong("All Apologies", 3.51);
        System.out.println();
        albums.add(album);
       

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlaylist("Death on Two Legs (Dedicated to...)", playList_1);
        albums.get(0).addToPlaylist(2, playList_1);
        albums.get(0).addToPlaylist(3, playList_1);
        albums.get(0).addToPlaylist(4, playList_1);
        albums.get(0).addToPlaylist(5, playList_1);
        albums.get(0).addToPlaylist(6, playList_1);
        albums.get(0).addToPlaylist(7, playList_1);
        albums.get(0).addToPlaylist(8, playList_1);
        albums.get(0).addToPlaylist(9, playList_1);
        albums.get(0).addToPlaylist(10, playList_1);
        albums.get(0).addToPlaylist(11, playList_1);
        albums.get(0).addToPlaylist(12, playList_1);
        albums.get(1).addToPlaylist("Serve the Servants", playList_1);
        albums.get(1).addToPlaylist(2, playList_1);
        albums.get(1).addToPlaylist(3, playList_1);
        albums.get(1).addToPlaylist(4, playList_1);
        albums.get(1).addToPlaylist(5, playList_1);
        albums.get(1).addToPlaylist(6, playList_1);
        albums.get(1).addToPlaylist(7, playList_1);
        albums.get(1).addToPlaylist(8, playList_1);
        albums.get(1).addToPlaylist(9, playList_1);
        albums.get(1).addToPlaylist(10, playList_1);
        albums.get(1).addToPlaylist(11, playList_1);
        albums.get(1).addToPlaylist(12, playList_1);
        System.out.println();
        printList(playList_1);

      

        play(playList_1);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner xc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playlist has no songs");
        } else {
        	System.out.println();
            System.out.println("Now playing " + listIterator.next().toString());
            System.out.println();
            printMenu();
        }

        while (!quit) {
            int action = xc.nextInt();
            xc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing " + listIterator.next().toString());
                    } else {
                        System.out.println("No song available, reached the end of the list");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options");
        System.out.println();
        System.out.println("Press");
        System.out.println();
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay current song\n" +
                "4 - list of all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("Playlist:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
