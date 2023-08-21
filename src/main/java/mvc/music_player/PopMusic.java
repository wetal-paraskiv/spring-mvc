package mvc.music_player;

import java.util.ArrayList;
import java.util.List;

public class PopMusic implements Music {

	private List<String> songsList = new ArrayList<String>();
	{
		songsList.add("Shape of You. Ed Sheeran");
		songsList.add("Sometimes. Jealous Friend.");
		songsList.add("Sugar. Maroon 5");
		songsList.add("In Another Life. Lee Isaacs.");
		songsList.add("Counting Stars. OneRepublic.");
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
		return "Some Pop song :)";
	}

}
