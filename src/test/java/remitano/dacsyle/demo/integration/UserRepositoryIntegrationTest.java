package remitano.dacsyle.demo.integration;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import remitano.dacsyle.demo.model.UserModel;
import remitano.dacsyle.demo.repository.UserRepository;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public class UserRepositoryIntegrationTest
{
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void whenFindByUserName_thenReturnUser() {
		UserModel alex = new UserModel();
		alex.setUserName("alex");
		alex.setPassword("password");
		alex.setActive(Boolean.TRUE);
		entityManager.persist(alex);
		entityManager.flush();

		Optional<UserModel> found = userRepository.findByUserName(alex.getUserName());
		Assert.assertEquals(found.get().getUserName(),alex.getUserName());
	}

}
