package remitano.dacsyle.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import remitano.dacsyle.demo.model.MovieModel;


public interface MovieRepository extends JpaRepository<MovieModel, Integer>
{
}
