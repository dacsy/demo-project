package remitano.dacsyle.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import remitano.dacsyle.demo.dto.Movie;
import remitano.dacsyle.demo.model.MovieModel;
import remitano.dacsyle.demo.service.UserService;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class MovieConverterRevert implements Converter<Movie, MovieModel>
{

	@Override
	public MovieModel convert(Movie source)
	{
		MovieModel target = new MovieModel();
		target.setCreatedDate(new Date());
		target.setDescription(source.getDescription());
		target.setEmbedId(getEmbedId(source.getYoutubeUrl()));
		target.setTitle(source.getTitle());
		target.setCreatedBy(getCurrentUser());
		target.setYoutubeUrl(source.getYoutubeUrl());
		return target;
	}

	private String getEmbedId(String youtubeUrl){
		String embedId = new String();
		String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";
		Pattern compiledPattern = Pattern.compile(pattern);
		Matcher matcher = compiledPattern.matcher(youtubeUrl);
		if (matcher.find()) {
			embedId = matcher.group();
		}
		return embedId;
	}

	private String getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
