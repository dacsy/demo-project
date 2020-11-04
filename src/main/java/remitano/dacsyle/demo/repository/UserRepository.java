package remitano.dacsyle.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import remitano.dacsyle.demo.model.UserModel;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserModel, Integer>
{
	Optional<UserModel> findByUserName(String userName);
}
