package mvc.music_player;

import java.util.ArrayList;
import java.util.List;

public class MusicGenres {
	private List<Music> genres = new ArrayList<Music>();
	{
		genres.add(new RockMusic());
		genres.add(ClassicalMusic.createClassicalMusic());
		genres.add(new PopMusic());
	}

	public List<Music> getGenres() {
		return genres;
	}
}
