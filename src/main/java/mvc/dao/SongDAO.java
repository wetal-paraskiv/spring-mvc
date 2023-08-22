package mvc.dao;

import java.util.ArrayList;
import java.util.List;

import mvc.models.Song;

public class SongDAO {

	private List<Song> songs;

	{
		songs = new ArrayList<Song>();
		songs.add(new Song(1, "Smoke on the water"));
		songs.add(new Song(2, "Wish you were here..."));
		songs.add(new Song(3, "Signs of life"));
		songs.add(new Song(4, "The Dark Side of the Moon"));
		songs.add(new Song(5, "Telegraph road"));
	}

	public List<Song> getAll() {
		return songs;
	}

	public Song getOneById(int id) {
		return songs.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
	}

}
