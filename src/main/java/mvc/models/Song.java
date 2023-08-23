package mvc.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Song {

	private int id;

	@NotEmpty(message = "The title should not be empty")
	@Size(min = 5, max = 30, message = "The title should be between 5 and 30 chars...")
	private String title;

	public Song() {
	}

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
