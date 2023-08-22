package mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.dao.SongDAO;
import mvc.models.Song;

@Controller
@RequestMapping("/songs")
public class SongsController {
	
	// https://www.youtube.com/watch?v=w1FjeTZxQrQ&list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ&index=22
	
	private SongDAO songDAO;
	
	@Autowired
	public SongsController(SongDAO songDAO) {
		this.songDAO = songDAO;
	}
	
	@GetMapping("/all")
	public String getAll(Model model) {
		List<Song> allSongs = songDAO.getAll();
		model.addAttribute("allSongs", allSongs);
		return "player";
	}
	
	@GetMapping("/{id}")
	public String getById(Model model, @PathVariable("id") int id) {
		Song song = songDAO.getOneById(id);
		model.addAttribute("songById", song);
		return "song";
	}

}
