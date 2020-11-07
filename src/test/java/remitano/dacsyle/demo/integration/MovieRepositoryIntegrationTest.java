package remitano.dacsyle.demo.integration;

import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import remitano.dacsyle.demo.model.MovieModel;
import remitano.dacsyle.demo.repository.MovieRepository;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public class MovieRepositoryIntegrationTest
{
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MovieRepository movieRepository;

	@Test
	public void whenShareAMovie_thenFoundIt(){
		MovieModel movieModel = new MovieModel();
		movieModel.setYoutubeUrl("https://www.youtube.com/watch?v=rCIXjYo9qs4");
		movieModel.setEmbedId("rCIXjYo9qs4");
		movieModel.setTitle("Music");
		movieModel.setDescription("Take me home");
		entityManager.persist(movieModel);
		entityManager.flush();

		List<MovieModel> found = movieRepository.findAll();
		MovieModel foundMovie = found.get(0);
		Assert.assertEquals(foundMovie.getEmbedId(), movieModel.getEmbedId());
		Assert.assertEquals(foundMovie.getTitle(), movieModel.getTitle());
		Assert.assertEquals(foundMovie.getYoutubeUrl(), movieModel.getYoutubeUrl());
	}
}
