package remitano.dacsyle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import remitano.dacsyle.demo.dto.Movie;
import remitano.dacsyle.demo.service.MovieService;

import javax.websocket.server.PathParam;


@Controller
@RequestMapping("/share-movie")
public class ShareMovieController
{
	@Autowired
	MovieService movieService;

	@RequestMapping(value = "/share", method = RequestMethod.GET)
	public String shareMoviePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("isAuthenticated", !authentication.getPrincipal().equals("anonymousUser"));
		model.addAttribute("userName", authentication.getName());
		return "share-movie";
	}

	@RequestMapping(value = "/share", method = RequestMethod.POST)
	public String shareVideo(@PathParam("movie") Movie movie) {
		movieService.shareMovie(movie);
		return "redirect:/";
	}

}
