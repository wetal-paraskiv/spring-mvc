package mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.music_player.*;

@Controller()
public class HomeController {

	// https://www.youtube.com/watch?v=5fzX70ODuoI&list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ&index=18
	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model, HttpServletRequest httpServletRequest,
			@RequestParam(name = "m", required = false) String message) {

		System.out.println(httpServletRequest.toString());

		model.addAttribute("message", message);

		return "home";
	}

	@GetMapping("/calculator")
	public String calculator(Model model, @RequestParam(name = "a") double a, @RequestParam(name = "b") double b,
			@RequestParam(name = "o") String operation) {
		Double result = null;
		switch (operation) {
		case "add":
			result = a + b;
			break;
		case "subtract":
			result = a - b;
			break;
		case "multiply":
			result = a * b;
			break;
		case "divide":
			result = a / b;
			break;
		default:
			break;
		}
		model.addAttribute("result", result);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("o", operation);
		return "calculator";
	}

	@GetMapping("/hello/{name:.+}")
	public String hello(Model model, @PathVariable("name") String name) {

		model.addAttribute("message", name);

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
