package remitano.dacsyle.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import remitano.dacsyle.demo.dto.User;
import remitano.dacsyle.demo.converter.UserConverter;
import remitano.dacsyle.demo.model.UserModel;
import remitano.dacsyle.demo.repository.UserRepository;
import remitano.dacsyle.demo.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserConverter userConverter;

	@Override
	public User registration(UserModel userModel)
	{
		UserModel userCreated = userRepository.save(userModel);
		return userConverter.convert(userCreated);
	}

	@Override
	public User findByUserName(String userName)
	{
		Optional<UserModel> userModel = userRepository.findByUserName(userName);
		if (!userModel.isPresent()) return null;
		return userConverter.convert(userModel.get());
	}

}
