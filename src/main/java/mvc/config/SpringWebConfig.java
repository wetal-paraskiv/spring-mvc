package mvc.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import mvc.music_player.MusicPlayer;
import mvc.music_player.PopMusic;
import mvc.music_player.RockMusic;
import mvc.music_player.ClassicalMusic;
import mvc.music_player.Music;
import mvc.music_player.MusicGenres;

@EnableWebMvc
@Configuration
@ComponentScan({ "mvc" })
@PropertySource("classpath:musicPlayer.properties")
public class SpringWebConfig implements WebMvcConfigurer {

	// https://hellokoding.com/spring-mvc-4-hello-world-example-with-xml-configuration-maven-and-thymeleaf/
	
	@Autowired
	private ApplicationContext applicationContext;

	// Spring + Thymeleaf need this
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/core/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/resources/core/js/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	}

	// Spring + Thymeleaf
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(this.applicationContext);
		templateResolver.setPrefix("/WEB-INF/views/thymeleaf/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCacheable(true);
		return templateResolver;
	}

	// Spring + Thymeleaf
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	// Spring + Thymeleaf
	// Configure Thymeleaf View Resolver
	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}

	@Bean
	public ClassicalMusic classicalMusic() {
		return ClassicalMusic.createClassicalMusic();
	}

	@Bean
	public RockMusic rockMusic() {
		return new RockMusic();
	}

	@Bean
	public PopMusic popMusic() {
		return new PopMusic();
	}

	@Bean
	public MusicGenres musicGenres() {
		return new MusicGenres();
	}

	@Bean
	public MusicPlayer musicPlayer(List<Music> genres) {
		return new MusicPlayer(genres);
	}
}
