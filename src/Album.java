import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String titleSong, double durationOfSong) {
        if (findSong(titleSong) != null) {
            return false;
        }
        Song song = new Song(titleSong, durationOfSong);
        songs.add(song);
        return true;
    }

    public Song findSong(String titleSong) {
        for (Song song : songs) {
            if (song.getTitle().equals(titleSong)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumberOfSongInAlbum, LinkedList<Song> playlist) {
        // Note: trackNumbers start at 1.
        if (trackNumberOfSongInAlbum <= 0 || trackNumberOfSongInAlbum > songs.size()) {
            // tracknumber out of range
            return false;
        }
        // get the song from the album
        Song songToAdd = songs.get(trackNumberOfSongInAlbum - 1);
        String songToAddTitle = songToAdd.getTitle();


        // see if the song already been added to the playlist
        ListIterator<Song> playListIterator = playlist.listIterator();
        while (playListIterator.hasNext()) {
            if (playListIterator.next().getTitle().compareTo(songToAddTitle) == 0) {
                // already in playlist
                return false;
            }
        }
        // Add the song to the end of the playList.
        playlist.add(songToAdd);
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        // check if exist
        Song songToAdd = findSong(title);
        if (songToAdd == null) {
            // the song was not found
            return false;
        }

        // check if already in playlist

        ListIterator<Song> playListIterator = playlist.listIterator();
        while (playListIterator.hasNext()) {
            if (playListIterator.next().getTitle().compareTo(title) == 0) {
                // already exist
                return false;
            }
        }
        // Add the song to the end of the playList.
        playlist.add(songToAdd);
        return true;
    }
}
