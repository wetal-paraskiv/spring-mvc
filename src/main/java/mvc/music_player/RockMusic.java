package mvc.music_player;

import java.util.ArrayList;
import java.util.List;


public class RockMusic implements Music {

	private List<String> songsList = new ArrayList<String>();
	{
		songsList.add("Smoke on the water");
		songsList.add("Wish you were here...");
		songsList.add("Signs of life");
		songsList.add("The Dark Side of the Moon");
		songsList.add("Telegraph road");
	}

	public List<String> getSongsList() {
		return songsList;
	}

	@Override
	public String getSongByIndex(int index) {
		return songsList.get(index);
	}

	@Override
	public String getSong() {
		return null;
	}

}
