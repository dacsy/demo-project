package remitano.dacsyle.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import remitano.dacsyle.demo.model.UserModel;
import remitano.dacsyle.demo.repository.UserRepository;

import java.util.Optional;


@Service
public class MyUserDetailService  implements UserDetailsService
{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
	{
		Optional<UserModel> user = userRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));
		return user.map(MyUserDetail::new).get();

	}
}
