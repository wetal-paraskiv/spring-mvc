package mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.dao.SongDAO;
import mvc.models.Song;

@Controller
@RequestMapping("/songs")
public class SongsController {

	// https://www.youtube.com/watch?v=5LHCmvzugQM&list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ&index=25

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

	// new-create
//	@GetMapping("/new")
//	public String newSong(Model model) {
//		model.addAttribute("song", new Song(0, null));
//		return "new";
//	}
	@GetMapping("/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new";
	}

	@PostMapping
	public String create(@ModelAttribute("song") @Valid Song song, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "new";
		
		songDAO.save(song);
		return "redirect:/songs/all";
	}

	// edit-update
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("song", songDAO.getOneById(id));
		return "edit";
	}

	@PatchMapping("/update/{id}")
	public String patch(@ModelAttribute("song") @Valid Song song, BindingResult bindingResult,
			@PathVariable("id") int id) {
		if (bindingResult.hasErrors())
			return "edit";
		
		songDAO.update(song, id);
		return "redirect:/songs/all";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		songDAO.delete(id);
		return "redirect:/songs/all";
	}

}
