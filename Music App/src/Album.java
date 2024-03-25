

import java.util.ArrayList;
import java.util.LinkedList;

public class Album extends main {

	private String title;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String title, String artist) {
		this.setTitle(title);
		this.artist= artist;
		this.songs= new ArrayList<Song>();

	}
	public Album() {

	}
	public Song findSong(String title) {
		for (Song checkedSong: songs) {
			if(checkedSong.getTitle().equals(title))
				return checkedSong;
		}
		return null;
	}
	public boolean addSong(String title, double duration) {
		if(findSong(title)==null) {
			songs.add(new Song(title, duration));
			System.out.println(title+ " successfully added to the list ");
			return true;
			
		}else {
			System.out.print("Song with name " +title+" Already exists in the list of Songs");
			return false;
		}
	}
	public boolean addToPlaylist(int TrackNumber, LinkedList<Song>Playlist) {
		int index = TrackNumber -1;
		if (index>0 && index <= this.songs.size()) {
			Playlist.add(this.songs.get(index));
			return true;
		}
		System.out.print("this album does not have song with tracknumber " +TrackNumber);
			return false;
	}

	public boolean addToPlaylist(String title,LinkedList<Song> Playlist) {
		for(Song checkedSong: this.songs) {
			if(checkedSong.getTitle().equals(title)) {
				Playlist.add(checkedSong);
				return true;
			
			}
		}
		System.out.println(title + " this song is not avaiable in the album ");
		return false;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
