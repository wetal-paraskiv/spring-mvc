package mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.config.SpringWebConfig;
import mvc.music_player.*;

@Controller()
public class HomeController {
	
	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Spring MVC Hello World");

		return "home";
	}

	@GetMapping("/hello/{name:.+}")
	public String hello(Model model, @PathVariable("name") String name) {

		model.addAttribute("message", name);

		// view name, map to welcome.html later
		return "home";
	}
	
	@GetMapping("/song")
	public String song(Model model) {

		MusicPlayer musicPlayer = applicationContext.getBean("musicPlayer", MusicPlayer.class);
		String genreIndexAndSong = musicPlayer.playRandom();
		String genreIndex = genreIndexAndSong.split(",")[0];
		Music genreMusic = musicPlayer.getGenreByIndex(genreIndex);
		String genre = genreMusic.getClass().getName().substring(genreMusic.getClass().getName().lastIndexOf('.') + 1);
		String song = genreIndexAndSong.split(",")[1];

		model.addAttribute("song", song);
		model.addAttribute("volume", String.valueOf(musicPlayer.getVolume()));
		model.addAttribute("genre", genre);
		model.addAttribute("name", musicPlayer.getName());

		return "music";
	}

}
