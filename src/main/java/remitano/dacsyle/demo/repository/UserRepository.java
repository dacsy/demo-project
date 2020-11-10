package remitano.dacsyle.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import remitano.dacsyle.demo.model.UserModel;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>
{
	Optional<UserModel> findByUserName(String userName);
}
