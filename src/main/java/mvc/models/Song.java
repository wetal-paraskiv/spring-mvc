package mvc.models;

public class Song {

	private int id;
	private String title;

	public Song(int id, String string) {
		this.id = id;
		this.title = string;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
