package remitano.dacsyle.demo.service;

import remitano.dacsyle.demo.dto.Movie;

import java.util.List;


public interface MovieService
{
	/**
	 * Share movie
	 * @param movie
	 * @return
	 */
	Movie shareMovie(Movie movie);

	/**
	 * Get all Movies
	 * @return all movies
	 */
	List<Movie> getAll();
}
