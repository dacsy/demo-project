package remitano.dacsyle.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import remitano.dacsyle.demo.dto.Movie;
import remitano.dacsyle.demo.model.MovieModel;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
public class MovieConverter implements Converter<MovieModel, Movie>
{

	@Override
	public Movie convert(MovieModel source)
	{
		Movie target = new Movie();
		target.setCreatedDate(source.getCreatedDate());
		target.setDescription(source.getDescription());
		target.setEmbedId(source.getEmbedId());
		target.setTitle(source.getTitle());
		target.setCreatedBy(source.getCreatedBy());
		target.setYoutubeUrl(source.getYoutubeUrl());
		return target;
	}

	public List<Movie> convertAll(List<MovieModel> movieModels) {
		return movieModels.stream().map(movieModel -> this.convert(movieModel)).collect(Collectors.toList());
	}

}
