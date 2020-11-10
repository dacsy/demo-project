package remitano.dacsyle.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import remitano.dacsyle.demo.model.MovieModel;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Integer>
{
}
