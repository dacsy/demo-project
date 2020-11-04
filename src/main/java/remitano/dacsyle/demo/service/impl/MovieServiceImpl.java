package remitano.dacsyle.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import remitano.dacsyle.demo.converter.MovieConverter;
import remitano.dacsyle.demo.converter.MovieConverterRevert;
import remitano.dacsyle.demo.dto.Movie;
import remitano.dacsyle.demo.model.MovieModel;
import remitano.dacsyle.demo.repository.MovieRepository;
import remitano.dacsyle.demo.service.MovieService;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService
{
	@Autowired
	MovieRepository movieRepository;

	@Autowired
	MovieConverter movieConverter;

	@Autowired
	MovieConverterRevert movieConverterRevert;

	@Override
	public Movie shareMovie(Movie movie)
	{
		MovieModel movieModel = movieConverterRevert.convert(movie);
		MovieModel createdMovie = movieRepository.save(movieModel);
		return movieConverter.convert(movieModel);
	}

	@Override
	public List<Movie> getAll()
	{
		List<MovieModel> movieModels = movieRepository.findAll();
		return movieConverter.convertAll(movieModels);
	}

}
