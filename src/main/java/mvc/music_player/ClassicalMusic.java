package mvc.music_player;

import java.util.ArrayList;
import java.util.List;

public class ClassicalMusic implements Music {

	private List<String> songsList = new ArrayList<String>();
	{
		songsList.add("Kaffee cantata");
		songsList.add("Hungarian rapsody");
		songsList.add("String quartet");
		songsList.add("Piano concerto nr. 1");
		songsList.add("Libestraum");
	}

	public List<String> getSongsList() {
		return songsList;
	}

	private ClassicalMusic() {
	}

	public static ClassicalMusic createClassicalMusic() {
		return new ClassicalMusic();
	}

	public void init() {
		System.out.println("Initializing MusicClassical bean...");
	}

	public void destroy() {
		System.out.println("Destroying MusicClassical bean...");
	}

	public String getSongByIndex(int index) {
		return songsList.get(index);
	}

	@Override
	public String getSong() {
		return "Hungarian rapsody";
	}

}
