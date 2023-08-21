package mvc.music_player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

public class MusicPlayer {

	@Value("${musicPlayer.name}")
	private String name;

	@Value("${musicPlayer.volume}")
	private int volume;

	private List<Music> genres = new ArrayList<Music>();

	public MusicPlayer(List<Music> genres) {
		this.genres = genres;
	}

	public void init() {
		System.out.println("Initializing MusicPlayer bean..." + this.hashCode());
	}

	public void destroy() {
		System.out.println("Destroying MusicPlayer bean...");
	}

	public List<Music> getGenres() {
		return genres;
	}
	
	public Music getGenreByIndex(String index) {
		return genres.get(Integer.parseInt(index));
	}

	public void setGenres(List<Music> genres) {
		this.genres = genres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String playRandom() {
		Random random = new Random();
		int genreIndex = random.nextInt(3);
		int songIndex = random.nextInt(5);

		Music musicGenre = genres.get(genreIndex);
		String song = musicGenre.getSongByIndex(songIndex);
		return genreIndex + "," + song;
	}
}
