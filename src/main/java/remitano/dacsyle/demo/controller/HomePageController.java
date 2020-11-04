package remitano.dacsyle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import remitano.dacsyle.demo.dto.Movie;
import remitano.dacsyle.demo.service.MovieService;

import java.util.List;


@Controller
public class HomePageController
{
	@Autowired
	MovieService movieService;

	@GetMapping("/")
	public String homePage(Model model) {
		List<Movie> movies = movieService.getAll();
		model.addAttribute("movies", movies);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("isAuthenticated", !authentication.getPrincipal().equals("anonymousUser"));
		model.addAttribute("userName", authentication.getName());
		return "homepage";
	}
}
