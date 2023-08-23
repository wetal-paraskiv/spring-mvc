package mvc.dao;

import java.util.ArrayList;
import java.util.List;

import mvc.models.Song;

public class SongDAO {
	
	private static int ID;

	private List<Song> songs;

	{
		songs = new ArrayList<Song>();
		songs.add(new Song(++ID, "Smoke on the water"));
		songs.add(new Song(++ID, "Wish you were here..."));
		songs.add(new Song(++ID, "Signs of life"));
		songs.add(new Song(++ID, "The Dark Side of the Moon"));
		songs.add(new Song(++ID, "Telegraph road"));
	}

	public List<Song> getAll() {
		return songs;
	}

	public Song getOneById(int id) {
		return songs.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
	}
	
	public void save(Song song) {
		song.setId(++ID);
		songs.add(song);
	}
	
	public void update(Song song, int id) {
		Song toUpdateSong = this.getOneById(id);
		toUpdateSong.setTitle(song.getTitle());
	}
	
	public void delete(int id) {
		songs.removeIf(song -> song.getId() == id);
	}

}
